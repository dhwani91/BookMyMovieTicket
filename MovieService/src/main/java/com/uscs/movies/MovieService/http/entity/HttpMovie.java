package com.uscs.movies.MovieService.http.entity;

import com.uscs.movies.MovieService.entity.Movie;

public class HttpMovie {

	public int movieId;

	public String movieName;
	
	
	public String movieType;
	
	
	public String movieDesc;
	
	//required by framework
	protected HttpMovie() {}

	public HttpMovie(Movie movie) {
		this.movieId=movie.getMovieId();
		this.movieName=movie.getMovieName();
		this.movieType=movie.getMovieType();
		this.movieDesc=movie.getMovieDesc();
	}
}
