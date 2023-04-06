package com.oraclejava.project.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet{


	/*
	 * @Override public void init() throws ServletException { getloadDriver(); }
	 * 
	 * private void getloadDriver() throws ServletException {
	 * 
	 * try { Class.forName("oracle.jdbc.dirver.OracleDriver");
	 * System.out.println("드라이버로드 성공!");
	 * 
	 * } catch (ClassNotFoundException e) { //e.printStackTrace(); throw new
	 * ServletException("드라이버로드 실패!",e); }
	 * 
	 * }
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("</html>");
		out.println("<body>");
		out.println("<h2>Test 중입니다</h2>");
		ServletContext context = getServletContext();
	
		
		String webmaster =(String)context.getAttribute("webmaster");
		out.println("<footer><a href='mailto:"+webmaster+"'>"
				+webmaster + "</a></footer>");
		
		out.println("</footer>");
		
		out.println("</body>");
		out.println("</html>");
	}

	
}
