package com.ebsco.cdc.consumer.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ebsco.cdc.consumer.model.Greeting;
import com.ebsco.cdc.consumer.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {
    
    private final RestTemplate restTemplate;

    int port = 8090;
    GreetingServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String greetPerson(Greeting greeting) {
        return null;
    }
}
