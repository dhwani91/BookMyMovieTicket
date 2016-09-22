package com.uscs.movies.MovieService.services;

import java.util.List;

import com.uscs.movies.MovieService.entity.Rating;
import com.uscs.movies.MovieService.entity.User;

public interface RatingsService {

	Rating getRatingbyId(int ratingId);

	Rating addRating(Rating rating);

	void updateRating(Rating rating);

	List<Rating> listRatingByUser(int userId);

	List<Rating> listRatingByMovie(int movieId);

	void deleteRating(Rating rating);
}
