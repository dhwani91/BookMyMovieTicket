package com.uscs.movies.MovieService.services;

import java.util.List;

import com.uscs.movies.MovieService.entity.FavouriteMovie;
import com.uscs.movies.MovieService.entity.FavouriteTheater;
import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;

public interface FavouriteService {
	
	int addFavTheater(FavouriteTheater theater);
	int addFavMovie(FavouriteMovie movie);
	List<FavouriteTheater> listFavTheater(int  userId);
	List<FavouriteMovie> listFavMovie(int userId);
	void deleteTheater(int theaterId);
	void deleteMovie(int movieId);
	
	

}
