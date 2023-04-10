package com.oraclejava;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaxMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�ݾ��� �Է��ϼ���?");
		int money = sc.nextInt();
		System.out.println(money);
		
		AbstractApplicationContext ctx = 
				new ClassPathXmlApplicationContext("TaxConfig.xml");
		
		
		Tax tax = (Tax)ctx.getBean("tax");
		tax.setMoney(money);
		System.out.println("�ݾ�:"+ tax.getMoney());
		
		ctx.close();
		
	}
}
