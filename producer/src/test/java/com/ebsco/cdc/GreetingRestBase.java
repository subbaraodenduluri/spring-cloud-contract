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

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(MockitoJUnitRunner.class)
public abstract class GreetingRestBase {
	
	// Take this out for simplicity and replace the interface with its impl in the actual controller call
	@Mock MessageFormatService messageFormatService;
	@InjectMocks MessageFormatController messageFormatController;
	
	@Before
	public void setup() {
		// Take this out for simplicity
		given(messageFormatService.formatGreetingMessage(argThat(messageFormatWithPrefix()))).willReturn(
				new FormattedGreetingDTO("Greetings John Doe")
				);
		given(messageFormatService.formatGreetingMessage(argThat(messageFormatWithSuffix()))).willReturn(
				new FormattedGreetingDTO("John Doe, How are you doing?")
				);
		given(messageFormatService.formatGreetingMessage(argThat(messageFormatDefault()))).willReturn(
				new FormattedGreetingDTO("Hi John Doe")
				);
		
		// end
		RestAssuredMockMvc.standaloneSetup(messageFormatController);
	}
	
	// Take this out for simplicity
	private TypeSafeMatcher<GreetingDTO> messageFormatWithPrefix() {
		return new TypeSafeMatcher<GreetingDTO>() {
			@Override protected boolean matchesSafely(GreetingDTO greetingDTO) {
				
				if(greetingDTO.getPrefix() != null) {
					return greetingDTO.getName() != null && greetingDTO.getPrefix() != null
							&& (greetingDTO.getPrefix() + greetingDTO.getName()).equals("Greetings John Doe");
				}
				
				return false;
				
			}

			@Override public void describeTo(Description description) {

			}
		};
	}
	
	private TypeSafeMatcher<GreetingDTO> messageFormatWithSuffix() {
		return new TypeSafeMatcher<GreetingDTO>() {
			@Override protected boolean matchesSafely(GreetingDTO greetingDTO) {
				
				if(greetingDTO.getSuffix() != null) {
					return greetingDTO.getName() != null && greetingDTO.getSuffix() != null
							&& (greetingDTO.getName() + greetingDTO.getSuffix()).equals("John Doe, How are you doing?");
				}
				
				return false;
				
			}

			@Override public void describeTo(Description description) {

			}
		};
	}
	
	private TypeSafeMatcher<GreetingDTO> messageFormatDefault() {
		return new TypeSafeMatcher<GreetingDTO>() {
			@Override protected boolean matchesSafely(GreetingDTO greetingDTO) {
				
				if(greetingDTO.getSuffix() == null && greetingDTO.getPrefix() == null) {
					return greetingDTO.getName() != null 
							&& ("Hi "+ greetingDTO.getName()).equals("Hi John Doe");
				}

				return false;				
			}

			@Override public void describeTo(Description description) {

			}
		};
	}

}
