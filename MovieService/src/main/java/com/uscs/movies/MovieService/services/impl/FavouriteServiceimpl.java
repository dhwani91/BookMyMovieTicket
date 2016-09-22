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
import com.uscs.movies.MovieService.repository.MovieRepository;
import com.uscs.movies.MovieService.repository.TheaterRepository;
import com.uscs.movies.MovieService.repository.UserRepository;
import com.uscs.movies.MovieService.services.FavouriteService;

@Service
public class FavouriteServiceimpl implements FavouriteService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private FavouriteMovieRepository favMovieRepo;
	@Autowired
	private FavouriteTheaterRepository favTheaterRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private TheaterRepository theaterRepo;
	@Autowired
	private MovieRepository movieRepo;

	@Transactional
	@Override
	public int addFavTheater(FavouriteTheater theater) {
		int addedFavTheaterId = favTheaterRepo.addFavouriteTheater(theater);
		return addedFavTheaterId;

	}

	@Transactional
	@Override
	public int addFavMovie(FavouriteMovie movie) {

		int addedFavMovieId = favMovieRepo.addFavouriteMovie(movie);
		return addedFavMovieId;

	}

	@Transactional
	@Override
	public List<FavouriteTheater> listFavTheater(int userId) {
		User user = userRepo.getUser(userId);
		List<FavouriteTheater> listFavTheatres = favTheaterRepo.listFavouriteTheater(user);
		return listFavTheatres;
	}

	@Transactional
	@Override
	public List<FavouriteMovie> listFavMovie(int userId) {
		User user = userRepo.getUser(userId);
		List<FavouriteMovie> listFavMovies = favMovieRepo.listFavouriteMovie(user);
		return listFavMovies;
	}

	@Transactional
	@Override
	public void deleteTheater(int theaterId) {
		Theater theater = theaterRepo.getTheater(theaterId);
		favTheaterRepo.deleteFavouriteTheater(theater);
	}

	@Transactional
	@Override
	public void deleteMovie(int movieId) {

		Movie movie = movieRepo.getMovie(movieId);
		favMovieRepo.deleteFavouriteMovie(movie);
	}

}
