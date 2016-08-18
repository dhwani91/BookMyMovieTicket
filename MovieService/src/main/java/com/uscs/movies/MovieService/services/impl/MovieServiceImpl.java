package com.uscs.movies.MovieService.services.impl;
import org.springframework.stereotype.Service;

import com.uscs.movies.MovieService.entity.Movies;
import com.uscs.movies.MovieService.entity.impl.MoviesImpl;
import com.uscs.movies.MovieService.services.MovieService;
@Service
public class MovieServiceImpl implements MovieService {

	@Override
	public Movies getMovies(int movieId) {
		// TODO Auto-generated method stub
		return new MoviesImpl(movieId) ;
	}

	@Override
	public void addMovies(Movies movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMovie(Movies movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMovie(int movieId) {
		// TODO Auto-generated method stub
		
	}

}
