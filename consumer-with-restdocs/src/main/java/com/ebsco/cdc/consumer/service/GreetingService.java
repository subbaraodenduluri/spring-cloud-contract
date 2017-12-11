package com.ebsco.cdc.consumer.service;

import com.ebsco.cdc.consumer.dto.GreetingDTO;

public interface GreetingService {
    public String greetPerson(GreetingDTO greeting);
}
