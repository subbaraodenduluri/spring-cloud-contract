var request = require('request');

request.post(
  {
    url: 'http://localhost:9876/formatgreeting',
    json: {
      name: 'John Doe'
    }
  },
  function(error, response, body) {
    if (!error && response.statusCode >= 200 && response.statusCode < 400) {
      console.log(body)
    } else {
      console.log("ERROR - status [" + (response === undefined ?
        "undefined" : response.statusCode) + "]")
    }
  }
);
