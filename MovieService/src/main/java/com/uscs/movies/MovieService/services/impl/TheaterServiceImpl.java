package com.uscs.movies.MovieService.services.impl;
import com.uscs.movies.MovieService.entity.Theaters;
import com.uscs.movies.MovieService.entity.impl.TheatersImpl;
import com.uscs.movies.MovieService.services.TheaterService;

import org.springframework.stereotype.Service;
@Service
public class TheaterServiceImpl implements TheaterService {

	@Override
	public Theaters getTheater(int theaterId) {
		// TODO Auto-generated method stub
		return new TheatersImpl(theaterId);
	}

	@Override
	public void addTheater(Theaters theater) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTheater(Theaters theater) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTheater(int theaterId) {
		// TODO Auto-generated method stub
		
	}

}
