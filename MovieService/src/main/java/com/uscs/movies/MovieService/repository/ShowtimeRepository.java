package com.uscs.movies.MovieService.repository;

import java.util.List;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Showtime;

public interface ShowtimeRepository {

	int addShowtime(Showtime showTime);

	List<Showtime> getShowtimeByMovie(Movie movie);

	// List<Showtime> getShowtimeByTheater(int theaterId);

}
