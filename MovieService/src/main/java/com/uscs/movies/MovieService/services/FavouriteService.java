package com.uscs.movies.MovieService.services;

import java.util.List;

import com.uscs.movies.MovieService.entity.FavouriteMovie;
import com.uscs.movies.MovieService.entity.FavouriteTheater;
import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;

public interface FavouriteService {
	
	void addFavTheater(FavouriteTheater theater);
	void addFavMovie(FavouriteMovie movie);
	List<FavouriteTheater> listFavTheater(User user);
	List<FavouriteMovie> listFavMovie(User user);
	void deleteTheater(Theater theater);
	void deleteMovie(Movie movie);
	
	

}
