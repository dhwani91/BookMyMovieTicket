package com.uscs.movies.MovieService.repository;

import java.util.List;

import com.uscs.movies.MovieService.entity.FavouriteTheater;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;

public interface FavouriteTheaterRepository {
	 int addFavouriteTheater(FavouriteTheater favTheater);
	 List<FavouriteTheater>listFavouriteTheater(User user);
	 void deleteFavouriteTheater(Theater theater);

}
