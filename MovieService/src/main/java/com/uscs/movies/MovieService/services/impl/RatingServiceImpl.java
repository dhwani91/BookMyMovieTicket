package com.uscs.movies.MovieService.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Rating;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.RatingImpl;
import com.uscs.movies.MovieService.entity.impl.TheaterImpl;
import com.uscs.movies.MovieService.repository.MovieRepository;
import com.uscs.movies.MovieService.repository.RatingRepository;
import com.uscs.movies.MovieService.repository.UserRepository;
import com.uscs.movies.MovieService.services.RatingsService;

@Service
public class RatingServiceImpl implements RatingsService {

	@Autowired
	private RatingRepository ratingRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MovieRepository movieRepo;

	@Transactional
	@Override
	public Rating getRatings(int movieId) {
		Rating rating = this.ratingRepo.getRatings(movieId);

		return rating;
	}


	
	@Transactional
	@Override
	public Rating addRating(Rating rating) {
		RatingImpl impl = (RatingImpl) rating;
		int id = ratingRepo.addRatings(rating);
		return impl;
		
		
	}

	@Transactional
	@Override
	public void deleteRating(int  ratingId) {
		if (ratingId != 0) {
			Rating th = getRatingbyId(ratingId);
			this.ratingRepo.deleteRating(th);
			
		}
	}

	@Transactional
	@Override
	public void updateRating(Rating rating) {
		this.ratingRepo.updateRatings(rating);

	}

	@Transactional
	@Override
	public List<Rating> listRatingByUser(User user) {
		List<Rating> listRatingByUser = this.ratingRepo.listRatingsByUser(user);
		return listRatingByUser;
	}

	public List<Rating> listRatingByMovie(Movie movie) {
		List<Rating> listRatingByMovie = this.ratingRepo.listRatingsByMovie(movie);
		return listRatingByMovie;
	}

	@Override
	public Rating getRatingbyId(int ratingId) {
		Rating rating = this.ratingRepo.getRatings(ratingId);

		return rating;
	
	}


}
