package com.uscs.movies.MovieService.http.entity;

import com.uscs.movies.MovieService.entity.FavouriteMovie;
import com.uscs.movies.MovieService.entity.FavouriteTheater;

public class HttpFavTheater {
	int userId;
	int theaterId;
	String theterName;
	String userFname;
	String userLname;

	protected HttpFavTheater() {
	}

	public HttpFavTheater(FavouriteTheater theater) {
		this.theaterId = theater.getTheater().getTheaterId();
		this.theterName = theater.getTheater().getTheaterName();
		this.userId = theater.getUser().getId();
		this.userFname = theater.getUser().getFirstName();
		this.userLname = theater.getUser().getLastName();

	}
}
