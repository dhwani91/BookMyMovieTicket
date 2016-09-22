package com.uscs.movies.MovieService.entity;

import java.util.List;

public interface Rating {
	void setRatings(Movie movie, User user, int ratings);

	int getStar();

	int getRatingId();

	Movie getMovie();

	User getUser();

	List<Rating> getRatingByUser(User user);

	List<Rating> getRatingsByMovie(Movie movie);

	Rating getRating(int ratingId);

}
