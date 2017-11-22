package com.ebsco.cdc.producer.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebsco.cdc.producer.model.FormattedGreetingDTO;
import com.ebsco.cdc.producer.model.GreetingDTO;
import com.ebsco.cdc.producer.service.MessageFormatService;

@RestController
public class MessageFormatController {

    @Autowired
    MessageFormatService messageFormatService;
    
    @RequestMapping(method = RequestMethod.POST,
            value = "/formatgreeting",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormattedGreetingDTO> gimmeABeer(@RequestBody GreetingDTO greetingDTO) throws MalformedURLException {
        return new ResponseEntity<FormattedGreetingDTO>(messageFormatService.formatGreetingMessage(greetingDTO), HttpStatus.OK);
    }

}
