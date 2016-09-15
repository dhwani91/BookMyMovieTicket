package com.uscs.movies.MovieService.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.uscs.movies.MovieService.entity.FavouriteMovie;
import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.FavouriteMovieRepository;
import com.uscs.movies.MovieService.repository.MovieRepository;
import com.uscs.movies.MovieService.repository.RatingRepository;
import com.uscs.movies.MovieService.repository.ReviewRepository;
import com.uscs.movies.MovieService.repository.TheaterRepository;
import com.uscs.movies.MovieService.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	private static final int MAX_NAME_LENGTH = 45;
	private static final int MAX_DESC_LENGTH = 350;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MovieRepository movieRepo;
//	@Autowired
//	private TheaterRepository theaterRepo;
//	@Autowired
//	private FavouriteMovieRepository favMovieRepo;
//	
//	@Autowired
//	private ReviewRepository  reviewRepo;
//	
//	@Autowired
//	private RatingRepository ratingRepo;

	@Transactional
	@Override
	public Movie getMovies(int movieId) {
	return 	movieRepo.getMovies(movieId);
		
		
	}

	@Transactional
	@Override
	public Movie addMovies(Movie movie) {
		if (StringUtils.isEmpty(movie.getMovieName()) || movie.getMovieName().length() > MAX_NAME_LENGTH) {
			try {
				throw new Exception("MovieName is required");
			} catch (Exception e) {
				logger.error("add movieName", e);
			}
		}

		else if (StringUtils.isEmpty(movie.getMovieType()) || movie.getMovieType().length() > MAX_NAME_LENGTH) {
			try {
				throw new Exception("MovieType  is required");
			} catch (Exception e) {
				logger.error("add movie type", e);
			}
		}

		else if (StringUtils.isEmpty(movie.getMovieDesc()) || movie.getMovieDesc().length() > MAX_DESC_LENGTH) {
			try {
				throw new Exception("MovieType  is required");
			} catch (Exception e) {
				logger.error("add movie description", e);
			}
		}
		MovieImpl impl = (MovieImpl)movie;		
		int id =  (int) movieRepo.addMovies(movie);
		return getMovies(id);
	}

	@Transactional
	@Override
	public void updateMovie(Movie movie) {
		movieRepo.updateMovie(movie);

	}

	@Transactional
	@Override
	public void deleteMovie(int movieId) {
		Movie movie = getMovies(movieId);
//		favMovieRepo.deleteFavouriteMovie(movie);
		
		this.movieRepo.deleteMovie(movieId);

	}
	
	@Override
	public List<Movie> listMoviesByCity(String city) {
		return null;
	}

	@Override
	public List<Movie> listMoviesByTheater(Theater theater) {
		return null;
	}
	
	@Transactional
	@Override
	public List<Movie> listMovieByType(String movieType) {
		List<Movie> listMovieByType=this.movieRepo.listMovieByType(movieType);
		return listMovieByType;
	}

}
