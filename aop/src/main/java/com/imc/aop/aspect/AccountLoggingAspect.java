package com.imc.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@Order(2)
public class AccountLoggingAspect {
	
	
	@Pointcut("execution(public String com.imc.aop.controller.AccountController.createAccount() )")
	private void  forControllerCreateAccount() {}
	
	@Pointcut("execution(*  com.imc.aop.controller.*.*(..) )")
	private void  forControllerPackage() {}
	
	@Pointcut("execution(* com.imc.aop.controller.*.set*(..))")
	private void forSetter() {}
	
	
	@Pointcut("execution(* com.imc.aop.controller.*.get*(..))")
	private void forGetter() {}
	
	
	@Pointcut("forControllerPackage() && !(forSetter() || forGetter())")
	private void execeptSetterAndGetter() {}
	
	
	@Before("execution(public String com.imc.aop.controller.AccountController.createAccount(..))")
	public void logInfoInConsole(JoinPoint joinPoint) {
		log.info("Logging in console :: {}", joinPoint.getSignature().getName());
	}

	
	

}
