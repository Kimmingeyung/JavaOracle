package com.oraclejava;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonMain {
	public static void main(String[] args) {
		
		
		/*
		 * Person person = new Person(); 
		 * person.setName("허재"); 
		 * person.setAge(57);
		 * person.setBirthPlace("춘천");
		 */
		
		//월래 객체 생성해서 값을 넣은 다음에 사용했던 것을 SpringConfig.xml에 값을 넣어서 연결하여 사용함
		AbstractApplicationContext ctx = 
				new ClassPathXmlApplicationContext("SpringConfig.xml");
		
		Person person = (Person)ctx.getBean("person");
		
		System.out.println("이름:"+ person.getName());
		System.out.println("나이:"+ person.getAge());
		System.out.println("출생지:"+ person.getBirthPlace());
		
		ctx.close();
		
	}
}
