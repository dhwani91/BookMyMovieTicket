package com.uscs.movies.MovieService.repository;

import java.util.List;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.User;

public interface ReviewRepository {

	Review getReview(int reviewId);
	

	int addReview(Review review);

	void updateReview(Review review);

	void deleteReview(Review  review);

	void deleteReviewByUser(User user);

	List<Review> listReviewByMovies(Movie movie);

	List<Review> listReviewByUser(User user);


	void deleteReview(int reviewid);
}
