const FormatGreetingServiceClient = require('./FormatGreetingServiceClient');
const Greeting = require('./Greeting');
const formatGreetingServiceClient = new FormatGreetingServiceClient('http://localhost:9876');

formatGreetingServiceClient.formatGreeting(new Greeting("John Doe"))
    .then((data) => {
        console.log(data);
    })
    .catch((error) => {
        console.log(error);
    })
;
