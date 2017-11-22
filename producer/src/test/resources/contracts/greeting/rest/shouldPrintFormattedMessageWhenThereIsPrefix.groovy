// rest/shouldPrintGenericMessageWhenThereIsNoPrefix.groovy
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
				prefix: "Greetings ",
				suffix: ", How are you?"
		)
		headers {
			contentType(applicationJson())
		}
	}
	response {
		status 200
		body("""
			{
				"formattedGreeting": "Greetings John Doe, How are you?"
			}
			""")
		headers {
			contentType(applicationJson())
		}
	}
}