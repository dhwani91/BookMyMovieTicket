package com.uscs.movies.MovieService.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uscs.movies.MovieService.entity.FavouriteTheater;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.repository.FavouriteTheaterRepository;

@Repository
public class FavouriteTheaterRepositoryImpl implements FavouriteTheaterRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addFavouriteTheater(FavouriteTheater favTheater) {
		return (Integer) this.sessionFactory.getCurrentSession().save(favTheater);
	}

	@Override
	public List<FavouriteTheater> listFavouriteTheater(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("listFavouriteTheaters").setEntity("user", user);
		List<FavouriteTheater> searchResult = query.list();
		return searchResult;
	}

	@Override
	public void deleteFavouriteTheater(Theater theater) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("deleteFavouriteTheater").setEntity("theater", theater);
		query.executeUpdate();
	}

}
