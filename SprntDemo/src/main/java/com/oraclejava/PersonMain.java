package com.oraclejava;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonMain {
	public static void main(String[] args) {
		
		
		/*
		 * Person person = new Person(); 
		 * person.setName("����"); 
		 * person.setAge(57);
		 * person.setBirthPlace("��õ");
		 */
		
		//���� ��ü �����ؼ� ���� ���� ������ ����ߴ� ���� SpringConfig.xml�� ���� �־ �����Ͽ� �����
		AbstractApplicationContext ctx = 
				new ClassPathXmlApplicationContext("SpringConfig.xml");
		
		Person person = (Person)ctx.getBean("person");
		
		System.out.println("�̸�:"+ person.getName());
		System.out.println("����:"+ person.getAge());
		System.out.println("�����:"+ person.getBirthPlace());
		
		ctx.close();
		
	}
}
