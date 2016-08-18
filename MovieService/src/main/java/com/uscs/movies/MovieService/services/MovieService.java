package com.uscs.movies.MovieService.services;

import com.uscs.movies.MovieService.entity.Movies;

public interface MovieService {
	Movies getMovies(int movieId);
	void addMovies(Movies movie);
	void updateMovie(Movies movie);
	void deleteMovie(int movieId);
}
