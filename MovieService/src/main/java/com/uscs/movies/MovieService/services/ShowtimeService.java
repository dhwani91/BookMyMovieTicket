package com.uscs.movies.MovieService.services;

import java.util.List;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.Showtime;
import com.uscs.movies.MovieService.entity.Theater;

public interface ShowtimeService {

	Showtime addShowTime(Showtime showtime);

	void deleteShowtime(Showtime showtime);

	List<Showtime> getShowtimeByMovie(int movieId);

	void updateShowtime(Showtime showtime);

	List<Showtime> getShowtimeByTheater(int theaterId);
//	List<Showtime> getTheaterByMovie(int movieId);
}
