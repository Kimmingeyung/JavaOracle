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
	
	@Override
		public void insertMovie(Movie movie) {
			String sql = "insert into movie(movid_id, title, price)"
					+"values(movie_seq.nextval,?,?)";
			
			PreparedStatement pstmt = null;
			OracledbConnection odc = null;
			
			try {
				odc = new OracledbConnection();
				odc.getConnetion().setAutoCommit(false); // 트랜잭션 시작! (기록도 시작)
				
				pstmt = odc.getConnetion().prepareStatement(sql);
				pstmt.setString(1, movie.getTitle());
				pstmt.setInt(2, movie.getPrice());
				
				pstmt.executeUpdate();
				odc.getConnetion().commit();  // 트랜잭션 종료! 마지막 결과를 저장할 수 있도록 함 
				pstmt.close();
				
			} catch (SQLException e) {
				System.out.printf("SQL 에러발생:",e);
			} finally {
				odc.close();
			}
			
			
		}
	
	@Override
		public Movie detailMovie(int id) {
			// TODO Auto-generated method stub
			return null;
		}
	
	@Override
		public void updateMovie(Movie movie) {
			// TODO Auto-generated method stub
			
		}
	
	@Override
		public void deleteMovie(int id) {
			// TODO Auto-generated method stub
			
		}
	
	
	
}
