package com.oraclejava.project.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmpServlet2")
public class EmpServlet2 extends HttpServlet {

	private void loadJdbcDriver() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����!");
		} catch (ClassNotFoundException e) {
			throw new ServletException("����̹� �ε� ����", e);
		}
	}

	private Connection getConnection() throws ServletException {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			throw new ServletException("���ӿ����߻�", e);
		}

	}
	
	private void closeConnection(Connection con) throws ServletException{
		
		try {
			con.close();
			System.out.println("Ŀ�ؼ��� ����Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

	@Override
	public void init() throws ServletException {
		// 1. jdbc ����̹� �ε� - �ѹ��� ����̹� ���� : �޸� �����ϱ�
		loadJdbcDriver();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 2. dbĿ�ؼ��� �δ´�.
		Connection con = getConnection(); // �ݺ��� ���ϱ����ؼ� �ѹ��� �����
		
		
		/*
		 * Connection con= null; try { con =
		 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		 * url: jdbc:oracle:thin:localhost:1521:xe System.out.println("2�ܰ� Ŀ�ؼ� ����!"); }
		 * catch (SQLException e) { //System.out.println("Ŀ�ؼ� �����߻�!");
		 * //e.printStackTrace(); throw new ServletException("Ŀ�ؼ� ����!",e); }
		 */
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>����̹��ε� �׽�Ʈ�ð�</h1>");

		// import java.sql�� �����ϱ�!!!
		// 3. ���� ����
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select first_name, last_name, employee_id" + " from employees");
			out.println("<ul>");
			while (rs.next()) {
				int emp_id = rs.getInt("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				out.println("<li>" + emp_id + " " + first_name + " " + last_name + " " + "</li>");
			}
			out.println("</ul>");
			System.out.println("3�ܰ� ���� ���� �Ϸ�");

			rs.close(); // �Ųٷ� �ݱ�
			stmt.close();

		} catch (SQLException e) {
			System.out.println("���� ���� ����!!");
			e.printStackTrace();

		} finally {
			// 4.�ܰ� ������ Ŀ�ؼ��� �����Ѵ�!
			/*
			try {
				con.close();
				System.out.println("Ŀ�ؼ��� ����Ǿ����ϴ�.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			*/
			closeConnection(con); // �̰� ĸ��ȭ�Ѱ� 
		}

		out.println("</body>");
		out.println("</html>");
	}

}
