package com.uscs.movies.MovieService.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uscs.movies.MovieService.entity.FavouriteMovie;
import com.uscs.movies.MovieService.entity.FavouriteTheater;
import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.repository.FavouriteMovieRepository;
import com.uscs.movies.MovieService.repository.FavouriteTheaterRepository;
import com.uscs.movies.MovieService.services.FavouriteService;

@Service
public class FavouriteServiceimpl implements FavouriteService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private FavouriteMovieRepository favMovieRepo;
	@Autowired
	private FavouriteTheaterRepository favTheaterRepo;

	@Transactional
	@Override
	public void addFavTheater(FavouriteTheater theater) {
		if(theater !=null){
			this.addFavTheater(theater);
		}
		
	}

	@Override
	public void addFavMovie(FavouriteMovie movie) {
		this.addFavMovie(movie);

	}

	@Override
	public List<FavouriteTheater> listFavTheater(User user) {
		
		return null;
	}

	@Override
	public List<FavouriteMovie> listFavMovie(User user) {

		return null;
	}

	@Override
	public void deleteTheater(Theater theater) {

	}

	@Override
	public void deleteMovie(Movie movie) {

	}

}
