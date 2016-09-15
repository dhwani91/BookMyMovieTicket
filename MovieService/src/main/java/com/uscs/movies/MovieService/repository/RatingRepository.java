package com.uscs.movies.MovieService.repository;

import java.util.List;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Rating;
import com.uscs.movies.MovieService.entity.User;

public interface RatingRepository {
	Rating getRatings(int movieId);
Rating getRatingById(int ratingId);

	int addRatings(Rating rating);

	void updateRatings(Rating rating);

	void deleteRating(Rating rating);

	void deleteRatingsByUser(User user);

	List<Rating> listRatingsByMovie(Movie movie);

	List<Rating> listRatingsByUser(User user);
}
