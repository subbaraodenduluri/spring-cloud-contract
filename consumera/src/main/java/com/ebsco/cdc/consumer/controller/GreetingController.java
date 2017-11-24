package com.ebsco.cdc.consumer.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebsco.cdc.consumer.dto.GreetingDTO;
import com.ebsco.cdc.consumer.service.GreetingService;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;
    
    @RequestMapping(method = RequestMethod.POST,
            value = "/greeting",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> greetMe(@RequestBody GreetingDTO greetingDTO) throws MalformedURLException {
        return new ResponseEntity<String>(greetingService.greetPerson(greetingDTO), HttpStatus.OK);
    }

}
