package com.uscs.movies.MovieService.services;

import com.uscs.movies.MovieService.entity.Reviews;

public interface ReviewService {
	Reviews getReview(int movieId);
	void addReview(Reviews review);
}
