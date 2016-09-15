package com.uscs.movies.MovieService.services;

import java.util.List;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.User;

public interface ReviewService {
	Review getReviewById(int reviewId);
	Review getReview(int movieId);

	Review addReview(Review review);

	void deleteReview(int  reviewId);

	List<Review> listReviewByUser(User user);
	List<Review> listReviewByMovie(Movie movie);

	void updateReview(Review review);

}
