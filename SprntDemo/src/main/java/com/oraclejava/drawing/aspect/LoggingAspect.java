package com.oraclejava.drawing.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Before("execution(public String getName())")
	private void loggingAdvice() {
		// TODO Auto-generated method stub
		System.out.println("Logging Advice is running-before");
	}
	
	@After("execution(public String getName())")
	private void Loggingadvice() {
		// TODO Auto-generated method stub
		System.out.println("Logging Advice is running-after");
	}
	
	@AfterReturning(pointcut="execution(public String getName())",returning= "name")
	private void logggingAdvice(String name) {
		// TODO Auto-generated method stub
		//System.out.println("리턴값:" + name);
		System.out.println(name+"맛있겠구나!");
		
	}
	
}
