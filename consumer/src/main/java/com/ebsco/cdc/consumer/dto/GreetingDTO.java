package com.ebsco.cdc.consumer.dto;

public class GreetingDTO {
	private String name;
	private String prefix;

	public GreetingDTO() {
		super();
	}

	public GreetingDTO(String name) {
		super();
		this.name = name;
	}

	public GreetingDTO(String prefix, String name) {
		super();
		this.prefix = prefix;
		this.name = name;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
