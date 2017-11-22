package com.ebsco.cdc.producer.model;

public class FormattedGreetingDTO {
	private String formattedGreeting;

	public FormattedGreetingDTO(String formattedGreeting) {
		super();
		this.formattedGreeting = formattedGreeting;
	}

	public String getFormattedGreeting() {
		return formattedGreeting;
	}

	public void setFormattedGreeting(String formattedGreeting) {
		this.formattedGreeting = formattedGreeting;
	}
	
}
