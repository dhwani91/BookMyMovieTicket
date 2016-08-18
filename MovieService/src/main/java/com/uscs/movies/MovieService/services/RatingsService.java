package com.uscs.movies.MovieService.services;

import com.uscs.movies.MovieService.entity.Ratings;

public interface RatingsService {
	Ratings getRatings(int movieId);
	void addRating(int userId,int movieId,int rating);
}
