package com.uscs.movies.MovieService.services;

import java.util.List;

import com.uscs.movies.MovieService.entity.FavouriteTheater;

public interface FavouriTheaterService {
	int addFavTheater(FavouriteTheater theater);
	
	List<FavouriteTheater> listFavTheater(int  userId);
	
	void deleteTheater(int theaterId);
	
}
