package com.uscs.movies.MovieService.entity;

import java.util.List;

public interface Movie {
	
	void setMovieName(String moviename);

	void setMovieType(String movieType);

	void setMovieDesc(String movieDesc);

	int getId();

	//List<Showtime> getShowtime();

	String getMovieName();

	String getMovieType();

	String getMovieDesc();
}
