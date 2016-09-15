package com.uscs.movies.MovieService.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.uscs.movies.MovieService.entity.FavouriteMovie;
import com.uscs.movies.MovieService.entity.FavouriteTheater;
import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.repository.FavouriteMovieRepository;

@Repository
public class FavouriteMovieRepositoryImpl implements FavouriteMovieRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addFavouriteMovie(FavouriteMovie movie) {
		return (Integer) this.sessionFactory.getCurrentSession().save(movie);
	}

	@Override
	public List<FavouriteMovie> listFavouriteMovie(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("listFavouriteMovies").setEntity("user", user);
		List<FavouriteMovie> searchResult = query.list();
		return searchResult;
	}

	@Override
	public void deleteFavouriteMovie(Movie movie) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("deleteFavouriteMovie").setEntity("movie", movie);
		query.executeUpdate();
	}

}
