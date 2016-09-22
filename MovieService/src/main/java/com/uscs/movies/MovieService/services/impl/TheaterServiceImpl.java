package com.uscs.movies.MovieService.services.impl;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.AddressImpl;
import com.uscs.movies.MovieService.entity.impl.TheaterImpl;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.FavouriteTheaterRepository;
import com.uscs.movies.MovieService.repository.TheaterRepository;
import com.uscs.movies.MovieService.services.TheaterService;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service

class TheaterServiceImpl implements TheaterService {
	private static final int MAX_NAME_LENGTH = 45;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TheaterRepository theaterRepository;
	@Autowired
	private FavouriteTheaterRepository favTheaterRepo;

	@Transactional
	@Override
	public Theater getTheater(int theaterId) {
		return theaterRepository.getTheater(theaterId);
	}

	@Transactional
	@Override
	public Theater addTheater(Theater theater) {

		if (StringUtils.isEmpty(theater.getTheaterName()) || theater.getTheaterName().length() > MAX_NAME_LENGTH) {
			try {
				throw new Exception("TheaterName is required");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		TheaterImpl impl = (TheaterImpl) theater;
		int id = (int) theaterRepository.addTheater(theater);
		return getTheater(id);

	}

	@Transactional
	@Override
	public void updateTheater(Theater theater) {
		this.theaterRepository.updateTheater(theater);

	}

	@Transactional
	@Override
	public void deleteTheater(Theater theater) {
		this.favTheaterRepo.deleteFavouriteTheater(theater);
		this.theaterRepository.deleteTheater(theater);
		// favMovieRepo.deleteFavouriteMovie(movie);

	}

	@Transactional
	@Override
	public List<Theater> getTheaterByZipcode(int zipcode) {
		List<Theater> listTheatersByzip = this.theaterRepository.getTheaterByZipcode(zipcode);
		return listTheatersByzip;
	}

	@Transactional
	@Override
	public List<Theater> getTheaterByCity(String city) {
		List<Theater> listTheatersByCity = this.theaterRepository.getTheaterByCity(city);
		return listTheatersByCity;
	}
//	@Transactional
//	@Override
//	public List<Theater> getTheaterByMovie(int movieId) {
//		List<Theater> showtimeByTheater=this.theaterRepository.getTheaterByMovie(movieId);
//		return showtimeByTheater;
//
//	}

}
