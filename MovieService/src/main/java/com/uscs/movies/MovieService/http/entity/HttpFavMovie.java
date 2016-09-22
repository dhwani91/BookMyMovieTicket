package com.uscs.movies.MovieService.http.entity;

import com.uscs.movies.MovieService.entity.FavouriteMovie;
import com.uscs.movies.MovieService.entity.FavouriteTheater;

public class HttpFavMovie {
	int userId;
	int movieId;
	String movieName;
	String userFname;
	String userLname;

	protected   HttpFavMovie() {}

	public HttpFavMovie(FavouriteMovie favMovie) {
		this.movieId = favMovie.getMovie().getMovieId();
		this.movieName = favMovie.getMovie().getMovieName();
		this.userId = favMovie.getUser().getId();
		this.userFname = favMovie.getUser().getFirstName();
		this.userLname = favMovie.getUser().getLastName();

	}
}
