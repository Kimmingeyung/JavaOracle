package com.oraclejava.project.web;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 드라이버를 로드한다.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("1단계 오라클 드라이버를 로드했습니다...");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 로드할 수 없습니다.");
			e.printStackTrace();
		}
		
		//2. db커넥션을 맺는다.
		Connection con= null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			/* url: jdbc:oracle:thin:@localhost:1521:xe */
			System.out.println("2단계 커넥션 성공!");
		} catch (SQLException e) {
			System.out.println("커넥션 오류발생!");
			e.printStackTrace();
		}
		 
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out =resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>드라이버로드 테스트시간</h1>");
		
		// import java.sql로 선택하기!!!
		//3. 쿼리 실행 
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select first_name, last_name, employee_id"
					+" from employees");
			out.println("<ul>");
			while(rs.next()) {
				int emp_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				out.println("<li>"+ emp_id + " " + first_name + " "
						+ last_name +" " + "</li>");
			}
			out.println("</ul>");
			System.out.println("3단계 쿼리 실행 완료");
			
			rs.close();  // 거꾸로 닫기 
			stmt.close();
			
		
		} catch (SQLException e) {
			System.out.println("쿼리 실행 오류!!");
			e.printStackTrace();
			
		} finally {
			// 4.단계 언제나 커넥션을 종료한다!
			try {
				con.close();
				System.out.println("커넥션이 종료되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		out.println("</body>");
		out.println("</html>");
	}
	
}
