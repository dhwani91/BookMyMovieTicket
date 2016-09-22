package com.uscs.movies.MovieService.entity;

public interface Movie {

	void setMovieName(String moviename);

	void setMovieType(String movieType);

	void setMovieDesc(String movieDesc);

	int getMovieId();

	void setMovieId(int movieId);

	// List<Showtime> getShowtime();

	String getMovieName();

	String getMovieType();

	String getMovieDesc();
}
