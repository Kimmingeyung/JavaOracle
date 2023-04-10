package com.oraclejava;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oraclejava.drawing.mode.Circle;
import com.oraclejava.drawing.mode.Triangle;
import com.oraclejava.drawing.service.ShapeService;

public class AopMain {
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = 
				new ClassPathXmlApplicationContext("AppConfig.xml");
		
		/*
		 * Triangle triangle = (Triangle)ctx.getBean("triangle");
		 * System.out.println(triangle.getName());
		 * 
		 * Circle circle = (Circle)ctx.getBean("circle");
		 * System.out.println(circle.getName());
		 */
				
				
		ShapeService ss = (ShapeService)ctx.getBean("shapeService");
		Circle circle = ss.getCircle();
		Triangle tri = ss.getTriangle();
		
		System.out.println(circle.getName());
		System.out.println(tri.getName());
		
		ctx.close();
		
	
	}
}
