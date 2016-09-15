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
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.RatingImpl;
import com.uscs.movies.MovieService.entity.impl.TheaterImpl;
import com.uscs.movies.MovieService.repository.RatingRepository;

@Repository
public class RatingsRepositoryImpl implements RatingRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Rating getRatings(int movieId) {
		return null;
	}

	@Override
	public int addRatings(Rating rating) {
		return (int) this.sessionFactory.getCurrentSession().save(rating);
	}

	@Override
	public void updateRatings(Rating rating) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(rating);

	}

	

	@Override
	public void deleteRatingsByUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("deleteRatingByUser").setEntity("user", user);
		query.executeUpdate();

	}

	@Override
	public void deleteRating(Rating rating) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(rating);

	}



	@Override
	public List<Rating> listRatingsByMovie(Movie movie) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("getRatingByMovie").setEntity("movie", movie);
		List<Rating> searchResult = query.list();
		return searchResult;

	}

	@Override
	public List<Rating> listRatingsByUser(User user) {

		
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("getRatingByUser").setEntity("user", user);
		List<Rating> searchResult = query.list();
		return searchResult;
	}

	@Override
	public Rating getRatingById(int ratingId) {
		return (Rating) this.sessionFactory.getCurrentSession().get(RatingImpl.class, ratingId);
		
	}

}
