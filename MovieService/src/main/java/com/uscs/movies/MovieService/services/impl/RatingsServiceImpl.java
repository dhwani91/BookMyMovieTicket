package com.uscs.movies.MovieService.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uscs.movies.MovieService.entity.Ratings;
import com.uscs.movies.MovieService.entity.impl.RatingsImpl;
import com.uscs.movies.MovieService.services.MovieService;
import com.uscs.movies.MovieService.services.RatingsService;
import com.uscs.movies.MovieService.services.UserService;

@Service
public class RatingsServiceImpl implements RatingsService {
@Autowired
 MovieService movieService;


	@Override
	public Ratings getRatings(int movieId) {
		// TODO Auto-generated method stub
		
		return new RatingsImpl(movieId);
	}


	@Override
	public void addRating(int userId, int movieId, int rating) {
		// TODO Auto-generated method stub
		
	}

}
