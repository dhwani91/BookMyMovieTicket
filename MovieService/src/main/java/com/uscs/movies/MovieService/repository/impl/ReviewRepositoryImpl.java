package com.uscs.movies.MovieService.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Rating;
import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.ReviewImpl;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.ReviewRepository;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addReview(Review review) {
		return (int) this.sessionFactory.getCurrentSession().save(review);
	}

	@Override
	public void updateReview(Review review) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(review);
	}

	@Override
	public Review getReview(int reviewId) {
		return (Review) this.sessionFactory.getCurrentSession().get(ReviewImpl.class, reviewId);
	}

	@Override
	public void deleteReviewByUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("deleteReviewByUser").setEntity("user", user);
		query.executeUpdate();
	}

	@Override
	public void deleteReview(Review review) {
		Session s = sessionFactory.getCurrentSession();
//		Review m1 = (Review) s.load(ReviewImpl.class, reviewid);
		s.delete(review);
	}

	@Override
	public List<Review> listReviewByMovies(Movie movie) {
		// int movieId=movie.getId();

		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("getReviewByMovie").setEntity("movie",movie);
		List<Review> searchResult = query.list();
		return searchResult;
	}

	@Override
	public List<Review> listReviewByUser(User user) {
		// int userId=user.getId();
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("getReviewByUser").setEntity("user", user);
		List<Review> searchResult = query.list();
		return searchResult;

	}

}
