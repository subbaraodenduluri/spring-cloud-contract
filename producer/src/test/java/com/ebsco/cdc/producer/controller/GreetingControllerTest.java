package com.ebsco.cdc.producer.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ebsco.cdc.producer.AbstractTest;
import com.ebsco.cdc.producer.controller.GreetingController;
import com.ebsco.cdc.producer.model.Greeting;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class GreetingControllerTest extends AbstractTest{

    @Autowired MockMvc mockMvc;
    @Autowired GreetingController greetingController;
    @Test public void should_print_a_generic_message_when_there_is_no_prefix() throws Exception {}
    @Test public void should_print_a_formatted_message_when_there_is_a_prefix() throws Exception {}

}
