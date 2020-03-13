package com.test.crosscutting.aop;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.crosscutting.aop.business.DBServiceA;
import com.test.crosscutting.aop.business.HttpServiceB;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={DBServiceA.class,HttpServiceB.class} )
public class DBServiceATest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DBServiceA dBServiceA;

	@Autowired
	private HttpServiceB httpServiceB;

	@Test
	public void invokeAOPStuff() {
		logger.info(httpServiceB.sendMessage("Hello"));
		logger.info(dBServiceA.getData(12));
		
		assertEquals("httpResponse", httpServiceB.sendMessage("Hello"));
		assertEquals("resultData", dBServiceA.getData(12));
	}
}