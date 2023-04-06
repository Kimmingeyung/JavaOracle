package com.oraclejava.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oraclejava.project.dto.Movie;

import oracle.jdbc.driver.OracleConnection;

public class MovieDAOImpl implements MovieDAO{  //����ٿ� �������̽� ����
	
	@Override
	public List<Movie> selectMovieAll() {
		
		List<Movie> list = new ArrayList<>(); // �ڹ� ���׸�
		
		String sql = "select * from movie";
		PreparedStatement pstmt = null;  //Statement�� �ӵ��� ������ ���ȿ� �����
		OracledbConnection odc = null;
		
		try {
			odc = new OracledbConnection();
			
			pstmt = odc.getConnetion().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMovie_id(rs.getInt("movie_id"));
				movie.setTitle(rs.getString("title"));
				movie.setPrice(rs.getInt("price"));
				list.add(movie);
			}
			
			rs.close();
			pstmt.close();
		} catch(SQLException e) {
			System.out.println("SQL ���� �߻�:"+ e);
		} finally {
			odc.close();
		}
		
		return list;
	}
}
