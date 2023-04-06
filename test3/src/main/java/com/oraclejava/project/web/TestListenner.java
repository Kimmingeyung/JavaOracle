package com.oraclejava.project.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestListenner implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//System.out.println("�� �¾��..���ֿ���....");
		
		ServletContext context = sce.getServletContext();
		// web.xml�� �����, �����ʿ��� �����ؼ� ����ϴ� ��� 
		//context.setAttribute("webmaster", "damansal@daum.net"); 
	
		//web.xml���� ���� �޾ƿͼ� ����ϴ� ��� 
		String email= context.getInitParameter("webmaster");
		context.setAttribute("webmaster", email);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//System.out.println("�� �׾�... ����");
	
	}
	
}
