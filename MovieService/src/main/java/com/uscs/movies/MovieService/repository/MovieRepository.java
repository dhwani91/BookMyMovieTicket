package com.uscs.movies.MovieService.repository;

import java.util.List;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Theater;

public interface MovieRepository {

	Movie getMovie(int movieId);

	int addMovies(Movie movie);

	void updateMovie(Movie movie);

	void deleteMovie(Movie movie);

	List<Movie> listMovieByTheater(Theater theater);

	List<Movie> listMovieByType(String movieType);
}
