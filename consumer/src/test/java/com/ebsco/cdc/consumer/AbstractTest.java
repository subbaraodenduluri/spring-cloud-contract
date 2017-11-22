package com.ebsco.cdc.consumer;

import org.junit.Before;
import org.springframework.boot.test.json.JacksonTester;

import com.ebsco.cdc.consumer.dto.GreetingDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractTest {

    public JacksonTester<GreetingDTO> json;
    

    @Before
    public void setup() {
        ObjectMapper objectMappper = new ObjectMapper();
        JacksonTester.initFields(this, objectMappper);
    }
}
