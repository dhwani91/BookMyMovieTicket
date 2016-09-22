package com.uscs.movies.MovieService.repository.impl;

import java.util.List;

import javax.persistence.PreRemove;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.TheaterImpl;
import com.uscs.movies.MovieService.repository.TheaterRepository;

@Repository
public class TheaterRepositoryImpl implements TheaterRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Theater getTheater(int theaterId) {
		return (Theater) this.sessionFactory.getCurrentSession().get(TheaterImpl.class, theaterId);
	}

	@Override
	public int addTheater(Theater theater) {

		return (Integer) this.sessionFactory.getCurrentSession().save(theater);
	}

	@Override
	public void updateTheater(Theater theater) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(theater);
	}

	@Override
	@PreRemove
	public void deleteTheater(Theater theater) {

		Session session = this.sessionFactory.getCurrentSession();

		if (theater != null) {
			session.delete(theater);
		}

	}

	@Override
	public List<Theater> getTheaterByZipcode(int zipcode) {
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("listTheaterByZipcode")
				.setInteger("zipcode", zipcode);
		List<Theater> searchResult = query.list();
		return searchResult;
	}

	@Override
	public List<Theater> getTheaterByCity(String city) {
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("listTheaterByCity").setString("city",
				city);
		List<Theater> searchResult = query.list();
		return searchResult;
	}

//	@Override
//	public List<Theater> getTheaterByMovie(int movieId) {
//		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("listTheaterByMovie").setInteger("movieId",movieId);
//		List<Theater> searchResult = query.list();
//		return searchResult;
//	
//	}


}
