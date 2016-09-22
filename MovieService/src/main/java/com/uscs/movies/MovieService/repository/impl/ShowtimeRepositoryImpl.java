package com.uscs.movies.MovieService.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Showtime;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.repository.ShowtimeRepository;

@Repository
public class ShowtimeRepositoryImpl implements ShowtimeRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Showtime> getShowtimeByMovie(Movie movie) {
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("listShowtimeByMovie1").setEntity("movie",movie);
		List<Showtime> searchResult = query.list();
		return searchResult;
	}
	@Override
	public int addShowtime(Showtime showTime) {
		return (int) this.sessionFactory.getCurrentSession().save(showTime);
		
	}
	@Override
	public List<Showtime> getShowtimeByTheater(Theater theater) {
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("listShowtimeByTheater").setEntity("theater",theater);
		List<Showtime> searchResult = query.list();
		return searchResult;
	}
	@Override
	public void deleteShowtime(Showtime showtime) {
		this.sessionFactory.getCurrentSession().delete(showtime);
		
	}
	@Override
	public void updateShowtime(Showtime showtime) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(showtime);
		
	}

	



}
