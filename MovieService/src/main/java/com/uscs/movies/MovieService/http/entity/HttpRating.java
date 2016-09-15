package com.uscs.movies.MovieService.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Rating;

@XmlRootElement(name = "rating")
public class HttpRating {
	@XmlElement
	public int ratingId;

	@XmlElement
	public int ratings;

	@XmlElement
	public String movieName;

	@XmlElement
	public String movieType;

	@XmlElement
	public String movieDesc;

	@XmlElement
	public String userName;

	// required by framework
	protected HttpRating() {
	}

	public HttpRating(Rating rating) {
		this.ratings = rating.getStar();
		this.movieName = rating.getMovie().getMovieName();
		this.movieDesc=rating.getMovie().getMovieDesc();
		this.movieType=rating.getMovie().getMovieType();
		this.userName = rating.getUser().getFirstName();
		this.ratingId=rating.getRatingId();
	}
}
