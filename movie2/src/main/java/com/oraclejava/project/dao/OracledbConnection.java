package com.oraclejava.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class OracledbConnection {
	
	// jdbc ����̹�
	private final String DBDRIVER = "oracle.jdbc.OracleDriver";
	
	//db ���� url
	private final String DBURL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	// ����� �̸�
	private final String DBUSER = "hr";
	
	//����� ���
	private final String DBPASSWORD = "hr";
	
	//Ŀ�ؼ� ��ü 
	private Connection con = null;
	
	//������(������ �� DB����) - Ŭ���� �̸��� �����ؾ��� 
	public OracledbConnection() { 
		try {
			Class.forName(DBDRIVER);
			this.con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��ε� ����!");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("URL�̳� ����������� �߸��Ǿ����ϴ�.");
			e.printStackTrace();
		}
	}	
	// ���ӵ� Ŀ�ؼ��� ���
	public Connection getConnetion() {
		return con;
	}
	
	//���� �ݱ�
	public void close() {
		try {
			con.close();
		} catch(SQLException e) {
			System.out.println("db�� �Ҵ� ���� �߻��ϴ� ����");
			e.printStackTrace();
			
		}
	}
		
	}
	
	

