package com.oraclejava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="move_id_seq")
	@SequenceGenerator(name="move_id_seq", sequenceName="movie_seq", allocationSize = 1)
	private int movieId;
	private String title;
	private int price;
	private String synopsis;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
		
}
