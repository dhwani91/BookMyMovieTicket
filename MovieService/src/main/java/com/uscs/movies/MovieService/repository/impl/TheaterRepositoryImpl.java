package com.uscs.movies.MovieService.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uscs.movies.MovieService.entity.Theaters;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.TheatersImpl;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.TheaterRepository;

@Repository
public class TheaterRepositoryImpl implements TheaterRepository {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Theaters getTheater(int theaterId) {
		// TODO Auto-generated method stub
		return (Theaters) this.sessionFactory.getCurrentSession().get(TheatersImpl.class, theaterId);
	}

	@Override
	public long addTheater(Theaters theater) {
		// TODO Auto-generated method stub
		return (Long) this.sessionFactory.getCurrentSession().save(theater);
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
