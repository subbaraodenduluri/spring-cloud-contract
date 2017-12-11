package com.ebsco.cdc.producer.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.cloud.contract.wiremock.restdocs.SpringCloudContractRestDocs;
import org.springframework.cloud.contract.wiremock.restdocs.WireMockRestDocs;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ebsco.cdc.producer.AbstractTest;
import com.ebsco.cdc.producer.model.GreetingDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@DirtiesContext
public class MessageFormatControllerTests extends AbstractTest{
    
	@Autowired private MockMvc mockMvc;
	private JacksonTester<GreetingDTO> json;

	@Before
	public void setup() {
		ObjectMapper objectMappper = new ObjectMapper();
		// Possibly configure the mapper
		JacksonTester.initFields(this, objectMappper);
	}


	@Test
	public void should_say_hi_when_only_name_is_given() throws Exception {
		GreetingDTO greetingDTO = new GreetingDTO("John Doe");
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/formatgreeting")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(greetingDTO).getJson()))
				.andExpect(jsonPath("$.formattedGreeting").value("Hi John Doe"))
				.andDo(WireMockRestDocs.verify()
//						.jsonPath("$[?(@.name != null)]")
						.contentType(MediaType.valueOf("application/json"))
						.stub("shouldPrintFormattedMessageWhenNameIsGiven"))
				.andDo(MockMvcRestDocumentation.document("shouldPrintFormattedMessageWhenNameIsGiven",
						SpringCloudContractRestDocs.dslContract()));
	}
	
	@Test
	public void should_say_hi_when_only_name_and_prefix_is_given() throws Exception {
		GreetingDTO greetingDTO = new GreetingDTO("Greetings ", "John Doe");
		
		mockMvc.perform(MockMvcRequestBuilders.post("/formatgreeting")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(greetingDTO).getJson()))
				.andExpect(jsonPath("$.formattedGreeting").value("Greetings John Doe"))
				.andDo(WireMockRestDocs.verify()
//						.jsonPath("$[?(@.prefix != null)]")
						.contentType(MediaType.valueOf("application/json"))
						.stub("shouldPrintFormattedMessageWhenThereIsPrefix"))
				.andDo(MockMvcRestDocumentation.document("shouldPrintFormattedMessageWhenThereIsPrefix",
						SpringCloudContractRestDocs.dslContract()));
	}
	
	
	
}
