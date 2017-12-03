const request = require('request');
const FormattedGreeting = require('./FormattedGreeting');

class FormatGreetingServiceClient {

    constructor(endpoint) {
        this.endpoint = endpoint;
    }

    formatGreeting(greeting) {
        return new Promise((resolve, reject) => {

            const options = {
                url: this.endpoint + '/formatgreeting',
                method: 'POST',
                body: JSON.stringify(greeting),

                headers: {'Accept': 'application/json', 'content-type': 'application/json'}
            };

            request(options, (error, response, body) => {
                if (!error && response.statusCode == 200) {
                    const parsedBody = JSON.parse(body);
                    const result = FormattedGreeting.fromJson(parsedBody);

                    resolve(result);
                } else {
                    reject(error);
                }
            });
        });
    }
}


module.exports = FormatGreetingServiceClient;
