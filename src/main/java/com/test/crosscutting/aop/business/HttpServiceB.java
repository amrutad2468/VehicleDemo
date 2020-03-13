package com.test.crosscutting.aop.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service	
public class HttpServiceB {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
    public String sendMessage(String message) {
        log.debug(message);
        
        /*
         assume that some message sends via rest client and gets "httpResponse"
        */
        String httpResponse = "httpResponse";
        
        log.debug(httpResponse);
        return httpResponse;

    }
}
