package com.ebsco.cdc.consumer.dto;

public class GreetingDTO {
	private String name;
	private String suffix;

	public GreetingDTO() {
		super();
	}

	public GreetingDTO(String name) {
		super();
		this.name = name;
	}

	public GreetingDTO(String name, String suffix) {
		super();
		this.name = name;
		this.suffix = suffix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
