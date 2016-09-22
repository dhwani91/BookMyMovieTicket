package com.uscs.movies.MovieService.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uscs.movies.MovieService.entity.FavouriteMovie;
import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.repository.FavouriteMovieRepository;
import com.uscs.movies.MovieService.repository.MovieRepository;
import com.uscs.movies.MovieService.services.FavouriteMovieService;
import com.uscs.movies.MovieService.services.MovieService;

@Service
public class FavouriteMovieServiceImpl implements FavouriteMovieService {
	@Autowired
	MovieRepository movieRepo;
	@Autowired
	FavouriteMovieRepository favMovieRepo;
	@Override
	public int addFavMovie(FavouriteMovie movie) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<FavouriteMovie> listFavMovie(int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteMovie(int movieId) {
		// TODO Auto-generated method stub
		
	}

	
}
