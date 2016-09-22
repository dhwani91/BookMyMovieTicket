package com.uscs.movies.MovieService.http.entity;

import com.uscs.movies.MovieService.entity.Review;

public class HttpReview {

	public int reviewId;
	public String reviews;
	public int movieId;
	public int userId;

	// required by framework
	protected HttpReview() {
	}

	public HttpReview(Review review) {
		this.reviews = review.getReview();
		this.reviewId = review.getReviewId();
		this.userId = review.getUser().getId();
		this.movieId = review.getMovie().getMovieId();
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
