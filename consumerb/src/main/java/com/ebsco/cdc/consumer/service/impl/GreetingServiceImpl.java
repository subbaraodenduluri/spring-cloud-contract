package com.ebsco.cdc.consumer.service.impl;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ebsco.cdc.consumer.dto.FormattedGreetingDTO;
import com.ebsco.cdc.consumer.dto.GreetingDTO;
import com.ebsco.cdc.consumer.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {
    
    private final RestTemplate restTemplate;

    int port = 8092;
    GreetingServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String greetPerson(GreetingDTO greetingDTO) {
    	ResponseEntity<FormattedGreetingDTO> formattedGreetingRespEntity = this.restTemplate.exchange(
				RequestEntity
						.post(URI.create("http://localhost:" + port + "/formatgreeting"))
						.contentType(MediaType.APPLICATION_JSON)
						.body(greetingDTO),
						FormattedGreetingDTO.class);
		
        return formattedGreetingRespEntity.getBody().getFormattedGreeting();
    }
}
