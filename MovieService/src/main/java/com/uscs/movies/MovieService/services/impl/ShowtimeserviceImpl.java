package com.uscs.movies.MovieService.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.Showtime;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.impl.ShowtimeImpl;
import com.uscs.movies.MovieService.repository.MovieRepository;
import com.uscs.movies.MovieService.repository.ShowtimeRepository;
import com.uscs.movies.MovieService.repository.TheaterRepository;
import com.uscs.movies.MovieService.repository.UserRepository;
import com.uscs.movies.MovieService.services.ShowtimeService;

@Service
public class ShowtimeserviceImpl implements ShowtimeService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TheaterRepository theaterRepo;
	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private ShowtimeRepository showTimeRepo;

	@Transactional
	@Override
	public Showtime addShowTime(Showtime showtime) {
		ShowtimeImpl impl=(ShowtimeImpl)showtime;
		int addedShowtimeId=this.showTimeRepo.addShowtime(showtime);
		return impl;
	}




	@Transactional
	@Override
	public List<Showtime> getShowtimeByMovie(int movieId) {
		Movie m=this.movieRepo.getMovie(movieId);
		List<Showtime> showtimeByMovie=this.showTimeRepo.getShowtimeByMovie(m);
		return showtimeByMovie;
	}

	
	@Transactional
	@Override
	public List<Showtime> getShowtimeByTheater(int theaterId) {
		Theater theater=this.theaterRepo.getTheater(theaterId);
		List<Showtime> showtimeByTheater=this.showTimeRepo.getShowtimeByTheater(theater);
		return showtimeByTheater;
	}

	@Transactional
	@Override
	public void deleteShowtime(Showtime showtime) {
		this.showTimeRepo.deleteShowtime(showtime);
		
	}

	@Transactional
	@Override
	public void updateShowtime(Showtime showtime) {
		this.showTimeRepo.updateShowtime(showtime);
		
	}

}
