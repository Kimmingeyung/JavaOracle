package com.oraclejava.project.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regionServlet2")
public class regionServlet2 extends HttpServlet{


	
	private void loadJdbcDriver() throws ServletException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹��ε� ����!");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			throw new ServletException("����̹��ε� ����",e);
		}
		
	}

	
	// 1. ����̹� �ε� -1ȸ
	@Override
	public void init() throws ServletException {

		loadJdbcDriver();
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// ȭ����´�  
		resp.setContentType("text/html;charset=utf8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet href='html/style.css'");
		out.println("</head>");
		out.println("<body>");
		
		//3. ���� ����
		//Statement stmt = 
		
		
		
		
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
	}
	
}
