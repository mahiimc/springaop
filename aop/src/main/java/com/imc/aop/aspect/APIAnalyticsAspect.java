package com.imc.aop.aspect;

import java.util.concurrent.atomic.AtomicInteger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
@Order(1)
public class APIAnalyticsAspect {
	
	static AtomicInteger counter = new AtomicInteger();
	
	
	@Before("execution(public String com.imc.aop.controller.AccountController.createAccount(*))")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) throws Throwable {
		
		Object[] args =  joinPoint.getArgs();
		
		for(Object obj : args ) {
			String name = obj.toString();
		}
		
		log.info("API Hit count {}",counter.getAndIncrement());
	}
	
	@Around("execution(public String com.imc.aop.controller.AccountController.createAccount(*))")
	public String beforeAddAccountAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object obj = joinPoint.proceed();
		if ( obj instanceof String result) {
			log.info("After returning method, {}", result.toUpperCase());
			return result.toUpperCase()+"__ Modified By AOP";
		}
		return "";
		
	}

}
