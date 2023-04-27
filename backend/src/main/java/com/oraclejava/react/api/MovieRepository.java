package com.oraclejava.react.api;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<Movie> list(){
		return sqlSession.selectList("movie.list");
	}
	
	public void insert(Movie movie) {
		sqlSession.insert("movie.insert", movie);
	}
	
	public Movie findById(int id) {
		return sqlSession.selectOne("movie.findById", id);
	}
	
	public void update(Movie movie) {
		sqlSession.update("movie.update",movie);
	}
	
	public void delete(int id) {
	//public void delete(Movie movie) {
		sqlSession.delete("movie.delete",id);
		//sqlSession.delete("movie.delete", movie.getMovie_id);
	}
	
	public void delete(Movie movie) {
		sqlSession.delete("movie.delete", movie.getMovie_id());
	}
	
	
	public List<Movie> search(String keyword) {
		return sqlSession.selectList("movie.search",keyword);
	}
}
