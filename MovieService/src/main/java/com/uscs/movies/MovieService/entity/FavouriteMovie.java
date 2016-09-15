package com.uscs.movies.MovieService.entity;

import java.util.List;

public interface FavouriteMovie {

	void setFavouriteMovie(User user, Movie movie);

	List<FavouriteMovie> listFavouriteMovie();

	User getUser();

	Movie getMovie();

}
