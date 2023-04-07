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
		
		String sql = "select * from movie order by title";
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
	
	@Override
		public void insertMovie(Movie movie) {
			String sql = "insert into movie(movie_id, title, price)"
					+" values(movie_seq.nextval,?,?)";  // ��ĭ �پ�⸦ �ؾ���
			
			PreparedStatement pstmt = null;
			OracledbConnection odc = null;
			
			try {
				odc = new OracledbConnection();
				odc.getConnetion().setAutoCommit(false); // Ʈ����� ����! (��ϵ� ����)
				
				pstmt = odc.getConnetion().prepareStatement(sql);
				pstmt.setString(1, movie.getTitle());
				pstmt.setInt(2, movie.getPrice());
				
				pstmt.executeUpdate();
				odc.getConnetion().commit();  // Ʈ����� ����! ������ ����� ������ �� �ֵ��� �� 
				pstmt.close();
				
			} catch (SQLException e) {
				System.out.println("SQL �����߻�:"+ e);
			} finally {
				odc.close();
			}
			
			
		}
	
	@Override
		public Movie detailMovie(int id) {
			Movie movie = new Movie();
			String sql = "select * from movie where movie_id=?";
			
			PreparedStatement pstmt = null;
			OracledbConnection odc = null;
			
			try {
				odc = new OracledbConnection();
				pstmt = odc.getConnetion().prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					movie.setMovie_id(rs.getInt("movie_id")); // �÷��� ��Ȯ�ϰ� ���� ��!!!
					movie.setTitle(rs.getString("title"));
					movie.setPrice(rs.getInt("price"));
					movie.setSynopsis(rs.getString("synopsis")); // ��ȭ�ٰŸ� �߰�!!!
				}
				rs.close();
				pstmt.close();
				
			} catch (SQLException e) {
				System.out.println("SQL �����߻�:"+e);
			} finally {
				odc.close();				
			}
			return movie;
		}
	
	@Override
		public void updateMovie(Movie movie) {
			// TODO Auto-generated method stub
			
		}
	
	@Override
		public void deleteMovie(int id) {
			// TODO Auto-generated method stub
			
		}
	
	
	@Override
		public List<Movie> searchMovie(String keyword) {
			// TODO Auto-generated method stub
			List<Movie> list = new ArrayList<>(); // �ڹ� ���׸�
		
			String sql = "select * from movie where title like ?";
			PreparedStatement pstmt = null;  //Statement�� �ӵ��� ������ ���ȿ� �����
			OracledbConnection odc = null;
			
			try {
				odc = new OracledbConnection();
				pstmt = odc.getConnetion().prepareStatement(sql);
				pstmt.setString(1, "%"+keyword+"%");
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
				System.out.println("SQL ���� �߻�!!!");
				
			} finally {
				odc.close();
			}
		
			return list;
		}
	
}
