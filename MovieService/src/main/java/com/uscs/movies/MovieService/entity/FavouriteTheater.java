package com.uscs.movies.MovieService.entity;

import java.util.List;

public interface FavouriteTheater {

	void setFavouriteTheater(User user, Theater theater);

	List<FavouriteTheater> listFavouriteTheater();

	User getUser();

	Theater getTheater();
}
