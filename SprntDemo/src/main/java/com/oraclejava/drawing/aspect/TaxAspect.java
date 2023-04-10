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
		System.out.println("�ݾ��� �Է��ϼ���?");
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
		System.out.println("������"+ result +"�Դϴ�.");
		System.out.println("�������� �ݾ�" + money + "�Դϴ�."); 
	
	}
	
	

}
