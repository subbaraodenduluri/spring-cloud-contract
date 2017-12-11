package com.ebsco.cdc.producer.service;

import com.ebsco.cdc.producer.model.FormattedGreetingDTO;
import com.ebsco.cdc.producer.model.GreetingDTO;

public interface MessageFormatService {
    public FormattedGreetingDTO formatGreetingMessage(GreetingDTO greeting);
}
