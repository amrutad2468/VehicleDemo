package com.test.crosscutting.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class HttpServiceAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	//Weaving & Weaver
	@Before("execution(* com.test.crosscutting.aop.business.*.*(..))")
	public void before(JoinPoint joinPoint){
		//Advice
		logger.info(" Checking for DBService getData ");
		logger.info(" Allowed execution for {}", joinPoint);
	}
}