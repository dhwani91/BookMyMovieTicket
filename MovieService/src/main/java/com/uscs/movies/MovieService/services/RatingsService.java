package com.uscs.movies.MovieService.services;

import java.util.List;

import com.uscs.movies.MovieService.entity.Rating;
import com.uscs.movies.MovieService.entity.User;

public interface RatingsService {
	Rating getRatings(int movieId);
	Rating getRatingbyId(int ratingId);

	Rating addRating(Rating rating);

	void deleteRating(int ratingId);

	void updateRating(Rating rating);
	
	List<Rating> listRatingByUser(User user);
//	List<Rating> listRatingByMovie(int movieId);
}
