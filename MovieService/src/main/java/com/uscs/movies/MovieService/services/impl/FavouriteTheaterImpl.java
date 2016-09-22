package com.uscs.movies.MovieService.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uscs.movies.MovieService.entity.FavouriteTheater;
import com.uscs.movies.MovieService.repository.FavouriteTheaterRepository;
import com.uscs.movies.MovieService.repository.TheaterRepository;
import com.uscs.movies.MovieService.services.FavouriTheaterService;

public class FavouriteTheaterImpl implements FavouriTheaterService {
@Autowired
TheaterRepository theaterRepo;

@Autowired
FavouriteTheaterRepository  favTheaterRepo;
	@Override
	public int addFavTheater(FavouriteTheater theater) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FavouriteTheater> listFavTheater(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTheater(int theaterId) {
		// TODO Auto-generated method stub
		
	}

	
}
