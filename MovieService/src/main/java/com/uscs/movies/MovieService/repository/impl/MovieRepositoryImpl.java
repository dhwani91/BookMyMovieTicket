package com.uscs.movies.MovieService.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(MovieRepositoryImpl.class);

	@Override
	public int addMovies(Movie movie) {
		Session session = this.sessionFactory.getCurrentSession();
		int id = (Integer) session.save(movie);
		logger.info("Movie added Successfully" + movie);
		return id;
//		return (Integer) this.sessionFactory.getCurrentSession().save(movie);
	}

	@Override
	public Movie getMovies(int movieId) {
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class, movieId);
	}

	@Override
	public void updateMovie(Movie movie) {
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(movie);

	}

	@Override
	public void deleteMovie(int movieId) {

		Session s = sessionFactory.getCurrentSession();
		Movie m1 = (Movie) s.load(MovieImpl.class, movieId);
		s.delete(m1);
	}

	@Override
	public List<Movie> search(String movieName) {
		
		return null;
	}

	@Override
	public List<Movie> listMovieByTheater(Theater theater) {
	
		return null;
	}

	@Override
	public List<Movie> listMovieByType(String movieType) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("listMovieByType").setString("movieType", movieType);
		List<Movie> searchResult = query.list();
		return searchResult;
	}

}
