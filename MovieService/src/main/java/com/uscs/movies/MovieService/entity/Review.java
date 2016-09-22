package com.uscs.movies.MovieService.entity;

import java.util.List;

public interface Review {
	void setReview(Movie movie, User user, String Review);

	int getReviewId();

	String getReview();

	Movie getMovie();

	User getUser();

	List<Review> getReviewByUser(User user);

	List<Review> getReviewByMovie(Movie movie);

	Review getReview(int reviewId);

}
