package com.uscs.movies.MovieService.services;

import java.util.List;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.User;

public interface ReviewService {
	Review getReviewById(int reviewId);

	Review addReview(Review review);

	void deleteReview(Review review);

	List<Review> listReviewByMovie(int movieId);

	void updateReview(Review review);

	List<Review> listReviewByUser(int userId);

}
