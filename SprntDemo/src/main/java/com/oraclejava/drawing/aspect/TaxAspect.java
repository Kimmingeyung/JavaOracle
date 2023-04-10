package com.oraclejava.drawing.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TaxAspect {
	
	@Before("execution(public int getMoney())")
	private void TaxCounter1() {
		//System.out.println("before");
		System.out.println("금액을 입력하세요?");
	}
	
	@After("execution(public int getMoney())")
	private void TaxCounter2() {
		System.out.println("after");
		//System.out.println("10000");
		
	}
	
	
	@AfterReturning(pointcut="execution(public int getMoney())", returning= "money")
	private void TaxCounter3(int money) { 
		//System.out.println("afterReturn");
		int result = money/10;
		System.out.println("세금은"+ result +"입니다.");
		System.out.println("세금포함 금액" + money + "입니다."); 
	
	}
	
	

}
