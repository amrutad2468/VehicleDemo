package com.test.crosscutting.aop.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DBServiceA {
    
	private Logger log = LoggerFactory.getLogger(this.getClass());

    public String getData(int id) {
        log.debug(String.valueOf(id));

        /*
         assume that some data has been retrieved from DB by id
        */
        String resultData = "resultData";
        
        log.debug(resultData);
        return resultData;
    }
}