package com.uscs.movies.MovieService.http.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Rating;

public class HttpRating {

	public int ratingId;

	public int rating;

	public int movieId;
	public int userId;

	// required by framework
	protected HttpRating() {
	}

	public HttpRating(Rating rating) {
		this.rating = rating.getStar();
		this.ratingId = rating.getRatingId();
		this.movieId = rating.getMovie().getMovieId();
		this.userId = rating.getUser().getId();
	}
}
