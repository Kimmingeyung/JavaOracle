package com.oraclejava.project.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet{

	
	
	@Override
	public void init() throws ServletException {
		getloadDriver();
	
	}

	private void getloadDriver() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로드 성공!");
		} catch (ClassNotFoundException e) {
			throw new ServletException("드라이버 실패!",e);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			System.out.println("커넥션 성공!");
		} catch (SQLException e) {
			System.out.println("커넥션 오류발생!");
		}

		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><link rel='stylesheet' href='html/style1.css'></head>");
		out.println("<body>");
		out.println("<h1> 영화 목록 출력 </h1>");
		out.println("<table>");
		out.println("<thead>");
		out.println("<tr><th>영화id</th><th>제목</th><th>가격</th></tr>");
		out.println("</thead>");
		out.println("<tbody>");
		

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select movie_id, title, price"
					+" from movie");
			
			while(rs.next()) {
				
				int movie_id = rs.getInt("movie_id");
				String title = rs.getString("title");
				int price = rs.getInt("price");
				out.println("<tr><td>"+ movie_id +"</td><td>"+ title +"</td><td>"+ price +"</td>");
					
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("쿼리실행오류!");
			e.printStackTrace();
		}
		
		int price;
		
		//여기에다가 출력하기
		
		out.println("</tbody>");		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
