package com.imc.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
@Order(3)
public class LogtoCloudAspect {
	
	@Before("execution(public String com.imc.aop.controller.AccountController.createAccount(..))")
	public void logToCloud() {
		log.info("Logging to cloud...");
	}


}
