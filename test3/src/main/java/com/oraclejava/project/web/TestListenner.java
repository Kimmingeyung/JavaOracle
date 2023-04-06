package com.oraclejava.project.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestListenner implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//System.out.println("나 태어났어..응애예요....");
		
		ServletContext context = sce.getServletContext();
		// web.xml에 등록전, 리스너에서 세팅해서 사용하는 방법 
		//context.setAttribute("webmaster", "damansal@daum.net"); 
	
		//web.xml에서 값을 받아와서 사용하는 방법 
		String email= context.getInitParameter("webmaster");
		context.setAttribute("webmaster", email);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//System.out.println("나 죽어... ㅋㅋ");
	
	}
	
}
