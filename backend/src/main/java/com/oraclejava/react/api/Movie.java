package com.oraclejava.react.api;

import lombok.Data;

@Data
public class Movie {
	private Integer movie_id;
	private String title;
	private int price;
	private String synopsis;
	private byte[] movie_picture;
	
}
