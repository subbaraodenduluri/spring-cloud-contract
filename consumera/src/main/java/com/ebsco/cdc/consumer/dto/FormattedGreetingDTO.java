package com.ebsco.cdc.consumer.dto;

public class FormattedGreetingDTO {
	private String formattedGreeting;

	public FormattedGreetingDTO() {
		
	}
	
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
