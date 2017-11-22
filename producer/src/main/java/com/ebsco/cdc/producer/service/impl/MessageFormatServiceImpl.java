package com.ebsco.cdc.producer.service.impl;

import org.springframework.stereotype.Service;

import com.ebsco.cdc.producer.model.FormattedGreetingDTO;
import com.ebsco.cdc.producer.model.GreetingDTO;
import com.ebsco.cdc.producer.service.MessageFormatService;

@Service
public class MessageFormatServiceImpl implements MessageFormatService {

	@Override
	public FormattedGreetingDTO formatGreetingMessage(GreetingDTO greeting) {

		if (greeting.getName() == null) {
			throw new IllegalArgumentException("Greeting name must not be null");
		}

		if (greeting.getPrefix() != null) {
			if (greeting.getSuffix() != null) {
				return new FormattedGreetingDTO(

						greeting.getPrefix() + greeting.getName() + greeting.getSuffix());
			}else {
				return new FormattedGreetingDTO(greeting.getPrefix() + greeting.getName());
			}
		} else {
			return new FormattedGreetingDTO("Hello " + greeting.getName());
		}

	}

}
