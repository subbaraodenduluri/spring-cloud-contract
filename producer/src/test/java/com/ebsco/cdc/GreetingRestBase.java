package com.ebsco.cdc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.argThat;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ebsco.cdc.producer.controller.MessageFormatController;
import com.ebsco.cdc.producer.model.FormattedGreetingDTO;
import com.ebsco.cdc.producer.model.GreetingDTO;
import com.ebsco.cdc.producer.service.MessageFormatService;
import com.ebsco.cdc.producer.service.impl.MessageFormatServiceImpl;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(MockitoJUnitRunner.class)
public abstract class GreetingRestBase {
	
	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(new MessageFormatController(new MessageFormatServiceImpl() ));
	}
	
}
