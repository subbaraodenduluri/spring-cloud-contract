const path = require('path');
const chai = require('chai');
const Pact = require('pact');
const chaiAsPromised = require('chai-as-promised');
const wrapper = require('@pact-foundation/pact-node');
const FormatGreetingServiceClient = require('../FormatGreetingServiceClient');
const FormattedGreeting = require('../FormattedGreeting');
const Greeting = require('../Greeting');

const expect = chai.expect;

chai.use(chaiAsPromised);

describe('Pact', () => {
  let provider;

  // Configure mock server
  const mockServer = wrapper.createServer({
    port: 9876,
    log: path.resolve(process.cwd(), 'logs', 'mockserver-integration.log'),
    dir: path.resolve(process.cwd(), 'pacts'),
    spec: 2
  });

  // Define expected payloads
  const expectedBodyFormattedGreeting = {
    formattedGreeting: 'Hi John Doe'
  };

  before((done) => {

    // Start mock server
    mockServer.start().then(() => {
      provider = Pact({
        consumer: 'My Consumer',
        provider: 'Format Greeting Provider',
        port: 9876
      });

      // Add interactions
      provider.addInteraction({
        state: 'Send a name',
        uponReceiving: 'a request for formatting a greeting with name only',
        withRequest: {
          method: 'POST',
          path: '/formatgreeting',
          body: {name: "John Doe"},
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        },
        willRespondWith: {
          status: 200,
          headers: {
            'Content-Type': 'application/json'
          },
          body: expectedBodyFormattedGreeting
        }
      }).then(() => done())
    })
  });

  it('successfully receives a formatted greeting', (done) => {
    const formatGreetingServiceClient = new FormatGreetingServiceClient('http://localhost:9876');
    const verificationPromise = formatGreetingServiceClient.formatGreeting(new Greeting("John Doe"));


    expect(verificationPromise).to.eventually.eql({result: "Hi John Doe"}).notify(done);
  });


  after(() => {
    // Write pact files
    provider.finalize().then(() => {
      wrapper.removeAllServers()
    })
  });


});
/*
describe('Pact', () => {
  let provider;

  // Configure mock server
  const mockServer = wrapper.createServer({
    port: 9876,
    log: path.resolve(process.cwd(), 'logs', 'mockserver-integration.log'),
    dir: path.resolve(process.cwd(), 'pacts'),
    spec: 2
  });

  const greeting = {
    name: 'John Doe'
  };
  const expectedFormattedGreeting = {
    result: "Hi John Doe"
  };

  before((done) => {

    // Start mock server
    mockServer.start().then(() => {
      provider = Pact({
        consumer: 'My Consumer',
        provider: 'Format Greeting Provider',
        port: 9876
      });

      // Add interactions
      provider.addInteraction({
        state: 'Send a name',
        uponReceiving: 'a request for formatting a greeting with name only',
        withRequest: {
          method: 'POST',
          path: '/formatgreeting',
          body: greeting,
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        },
        willRespondWith: {
          status: 200,
          headers: {
            'Content-Type': 'application/json'
          },
          body: expectedFormattedGreeting
        }
      }).then(() => done())
    })
  });

  it('successfully receives a formatted greeting', (done) => {
    const formatGreetingServiceClient = new FormatGreetingServiceClient('http://localhost:9876');
    const verificationPromise = formatGreetingServiceClient.formatGreeting(new Greeting("John Doe"));
    const expectedFinalGreeting = FormattedGreeting.fromJson(expectedFormattedGreeting.result);

    expect(verificationPromise).to.eventually.eql(expectedFinalGreeting).notify(done);
  });

  after(() => {
    // Write pact files
    provider.finalize().then(() => {
      wrapper.removeAllServers()

    })
  });
});
*/
