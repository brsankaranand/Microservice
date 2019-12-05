package com.ms.movieinfoservice.models;

public class Movie {

	private String movieId;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Movie(String movieId, String movieName) {
		this.movieId = movieId;
		this.name = movieName;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

}
