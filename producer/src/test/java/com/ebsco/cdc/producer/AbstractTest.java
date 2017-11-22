package com.ebsco.cdc.producer;

import org.junit.Before;
import org.springframework.boot.test.json.JacksonTester;

import com.ebsco.cdc.producer.model.Greeting;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractTest {

    public JacksonTester<Greeting> json;
    

    @Before
    public void setup() {
        ObjectMapper objectMappper = new ObjectMapper();
        JacksonTester.initFields(this, objectMappper);
    }
}
