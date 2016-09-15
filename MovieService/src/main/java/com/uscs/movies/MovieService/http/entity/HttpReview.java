package com.uscs.movies.MovieService.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uscs.movies.MovieService.entity.Rating;
import com.uscs.movies.MovieService.entity.Review;
@XmlRootElement(name = "review")
public class HttpReview {
	@XmlElement
	public int reviewId;

	@XmlElement
	public String reviews;

	@XmlElement
	public String movieName;

	@XmlElement
	public String movieType;

	@XmlElement
	public String movieDesc;

	@XmlElement
	public String userName;

	// required by framework
	protected HttpReview() {
	}

	public HttpReview(Review review) {
		this.reviews=review.getReview();
		
		this.movieName = review.getMovie().getMovieName();
		this.movieDesc=review.getMovie().getMovieDesc();
		this.movieType=review.getMovie().getMovieType();
		this.userName = review.getUser().getFirstName();
		this.reviewId=review.getReviewId();
	}
}
