package com.uscs.movies.MovieService.services;

import java.util.List;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Theater;

public interface MovieService {
	Movie getMovies(int movieId);

	Movie addMovies(Movie movie);

	void updateMovie(Movie movie);

	void deleteMovie(Movie movie);

	List<Movie> listMoviesByCity(String city);

	List<Movie> listMoviesByTheater(Theater theater);
	List<Movie> listMovieByType(String movieType);
}
