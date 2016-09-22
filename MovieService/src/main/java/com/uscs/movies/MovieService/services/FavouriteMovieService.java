package com.uscs.movies.MovieService.services;

import java.util.List;

import com.uscs.movies.MovieService.entity.FavouriteMovie;

public interface FavouriteMovieService {

	int addFavMovie(FavouriteMovie movie);

	List<FavouriteMovie> listFavMovie(int userId);

	void deleteMovie(int movieId);
}
