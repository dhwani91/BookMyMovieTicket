package com.uscs.movies.MovieService.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.ReviewImpl;
import com.uscs.movies.MovieService.repository.MovieRepository;
import com.uscs.movies.MovieService.repository.ReviewRepository;
import com.uscs.movies.MovieService.repository.UserRepository;
import com.uscs.movies.MovieService.services.ReviewService;

@Service
public class Reviewserviceimpl implements ReviewService {
	private static final int MAX_REVIEW_LENGTH = 350;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private ReviewRepository reviewRepo;

	@Transactional
	@Override
	public Review getReviewById(int reviewId) {
		return reviewRepo.getReview(reviewId);
	}

	@Transactional
	@Override
	public Review addReview(Review review) {

		ReviewImpl impl = (ReviewImpl) review;
		int id = reviewRepo.addReview(review);
		
		return impl;
	}

	@Transactional
	@Override
	public void deleteReview(Review review) {
		this.reviewRepo.deleteReview(review);

	}

	@Transactional
	@Override
	public List<Review> listReviewByUser(int userId) {
		User user = this.userRepo.getUser(userId);
		List<Review> reviewListByUser = this.reviewRepo.listReviewByUser(user);

		return reviewListByUser;
	}

	@Transactional
	@Override
	public List<Review> listReviewByMovie(int  movieId) {
		Movie movie = this.movieRepo.getMovie(movieId);
		List<Review> reviewListByMovie = this.reviewRepo.listReviewByMovies(movie);
		return reviewListByMovie;
	}
	@Transactional
	@Override
	public void updateReview(Review review) {
		this.reviewRepo.updateReview(review);

	}

}
