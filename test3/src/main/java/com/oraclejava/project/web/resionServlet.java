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

@WebServlet("/resionServlet")
public class resionServlet extends HttpServlet{

	
	private void loadJdbcDriver() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����!");
		}catch (ClassNotFoundException e) {
			throw new ServletException("����̹� �ε� ����",e);
		}
	}
	
	@Override
	public void init() throws ServletException {
		loadJdbcDriver(); // �ѹ��� ����̺� �ε� �غ���!!!
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr","hr");
			System.out.println("Ŀ�ؼ� ����!");
		} catch (SQLException e) {
			System.out.println("Ŀ�ؼ� �����߻�!");
			e.printStackTrace();
		}
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='html/style.css'>");
		out.println("</head>");
		
		
		out.println("<body>");
		
		
		
		// 3 ���� ���� 
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select region_id, region_name"
					+" from regions");
			System.out.println("��������!");
			out.println("<table>");
			out.println("<tr><th>����id</th><th>����</th></tr>");
			while(rs.next()) {
				int region_id = rs.getInt("region_id");
				String region_name = rs.getString("region_name");
				out.println("<tr>");
				out.println("<td>"+region_id +"</td>");
				out.println("<td>"+region_name +"</td>");
				out.println("</tr>");
			}
		
			rs.close();
			stmt.close();
			out.println("</table>");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�����������");
		} finally {
			try {
				con.close();
				System.out.println("Ŀ�ؼ� ����!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		out.println("<body>");
		out.println("</html>");
	}
	
}
