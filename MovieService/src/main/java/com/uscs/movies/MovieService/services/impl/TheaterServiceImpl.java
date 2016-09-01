package com.uscs.movies.MovieService.services.impl;
import com.uscs.movies.MovieService.entity.Theaters;
import com.uscs.movies.MovieService.entity.impl.TheatersImpl;
import com.uscs.movies.MovieService.services.TheaterService;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Service
public class TheaterServiceImpl implements TheaterService {
	private static final int MAX_NAME_LENGTH = 45;
	private static final int MAX_ADD_LENGTH=255;
	@Override
	public Theaters getTheater(int theaterId) {
		// TODO Auto-generated method stub
		return new TheatersImpl(theaterId);
	}

	@Transactional
	@Override
	public void addTheater(Theaters theater) {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(theater.getTheaterName()) || theater.getTheaterName().length() > MAX_NAME_LENGTH) {
			try {
				throw new Exception("TheaterName is required");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (StringUtils.isEmpty(theater.getTheaterAddress()) || theater.getTheaterAddress().length() > MAX_ADD_LENGTH) {
			try {
				throw new Exception("TheaterAddress is required");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
