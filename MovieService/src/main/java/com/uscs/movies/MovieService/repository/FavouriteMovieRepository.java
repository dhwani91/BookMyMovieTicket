package com.uscs.movies.MovieService.repository;

import java.util.List;

import com.uscs.movies.MovieService.entity.FavouriteMovie;
import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.User;

public interface FavouriteMovieRepository {
	 int addFavouriteMovie(FavouriteMovie movie);
	 List<FavouriteMovie>listFavouriteMovie(User user);
	 void deleteFavouriteMovie(Movie movie);
}
