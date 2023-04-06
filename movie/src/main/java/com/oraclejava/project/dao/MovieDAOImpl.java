package com.oraclejava.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oraclejava.project.dto.Movie;

import oracle.jdbc.driver.OracleConnection;

public class MovieDAOImpl implements MovieDAO{  //무비다오 인터페이스 구현
	
	@Override
	public List<Movie> selectMovieAll() {
		
		List<Movie> list = new ArrayList<>(); // 자바 제네릭
		
		String sql = "select * from movie";
		PreparedStatement pstmt = null;  //Statement가 속도가 느리고 보안에 취약함
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
			System.out.println("SQL 에러 발생:"+ e);
		} finally {
			odc.close();
		}
		
		return list;
	}
}
