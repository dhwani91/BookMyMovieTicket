package com.uscs.movies.MovieService.repository;
import com.uscs.movies.MovieService.entity.Movies;
public interface MovieRepository {
	Movies getMovies(int movieId);
	long addMovies(Movies movie);
	void updateMovie(Movies movie);
	void deleteMovie(int movieId);
}
