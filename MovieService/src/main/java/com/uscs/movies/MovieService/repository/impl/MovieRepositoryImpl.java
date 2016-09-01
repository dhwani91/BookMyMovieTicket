package com.uscs.movies.MovieService.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uscs.movies.MovieService.entity.Movies;
import com.uscs.movies.MovieService.entity.Theaters;
import com.uscs.movies.MovieService.entity.impl.MoviesImpl;
import com.uscs.movies.MovieService.entity.impl.TheatersImpl;
import com.uscs.movies.MovieService.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository  {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Movies getMovies(int movieId) {
		return (Movies) this.sessionFactory.getCurrentSession().get(MoviesImpl.class, movieId);
		// TODO Auto-generated method stub
	
	}

	@Override
	public long addMovies(Movies movie) {
		// TODO Auto-generated method stub
		return (Long) this.sessionFactory.getCurrentSession().save(movie);
	}

	@Override
	public void updateMovie(Movies movie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMovie(int movieId) {
		// TODO Auto-generated method stub
		
	}
}
