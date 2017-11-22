package contracts.greeting.rest

import org.springframework.cloud.contract.spec.Contract

// rest/shouldPrintFormattedMessageWhenThereIsPrefix.groovy
org.springframework.cloud.contract.spec.Contract.make {
		description("""
Represents a successful scenario of printing a custom greeting

```
given:
	a name
when:
	prefix and suffix is passed
then:
	we'll print a custom message
```

""")
	request {
		method 'POST'
		url '/formatgreeting'
		body(
			
			name: "John Doe",
			suffix: ", How are you doing?"
		)
		headers {
			contentType(applicationJson())
		}
	}
	response {
		status 200
		body("""
			{
				"formattedGreeting": "John Doe, How are you doing?"
			}
			""")
		headers {
			contentType(applicationJson())
		}
	}
}