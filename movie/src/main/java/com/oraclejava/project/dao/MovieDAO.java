package com.oraclejava.project.dao;

import java.util.List;

import com.oraclejava.project.dto.Movie;

public interface MovieDAO {
	public List<Movie>  selectMovieAll();
}
