package com.oraclejava.project.dao;

import java.util.List;

import com.oraclejava.project.dto.Movie;

public interface MovieDAO {
	public List<Movie>  selectMovieAll();
	
	public void insertMovie(Movie movie); // 영화목록 삽입
	
	public Movie detailMovie(int id);
	public void updateMovie(Movie movie);
	public void deleteMovie(int id);
	
}


