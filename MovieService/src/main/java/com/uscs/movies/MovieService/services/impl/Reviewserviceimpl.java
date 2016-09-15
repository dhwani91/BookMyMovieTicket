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
import com.uscs.movies.MovieService.entity.impl.RatingImpl;
import com.uscs.movies.MovieService.entity.impl.ReviewImpl;
import com.uscs.movies.MovieService.repository.MovieRepository;
import com.uscs.movies.MovieService.repository.ReviewRepository;
import com.uscs.movies.MovieService.repository.UserRepository;
import com.uscs.movies.MovieService.services.ReviewService;

@Service
public class Reviewserviceimpl implements ReviewService {
	private static final int MAX_REVIEW_LENGTH = 45;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private ReviewRepository reviewRepo;

	@Override
	public Review getReviewById(int reviewId) {
		return reviewRepo.getReview(reviewId);
	}

	@Override
	public Review getReview(int movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review addReview(Review review) {

		ReviewImpl impl = (ReviewImpl) review;
		int id = reviewRepo.addReview(review);
		return impl;
	}

	@Override
	public void deleteReview(int reviewId) {
		this.reviewRepo.deleteReview(reviewId);

	}

	@Override
	public List<Review> listReviewByUser(User user) {

		return null;
	}

	@Override
	public List<Review> listReviewByMovie(Movie movie) {
		return null;
	}

	@Override
	public void updateReview(Review review) {
		this.reviewRepo.updateReview(review);

	}

}
