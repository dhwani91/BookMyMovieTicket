package com.uscs.movies.MovieService.repository;

import java.util.List;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Showtime;
import com.uscs.movies.MovieService.entity.Theater;

public interface ShowtimeRepository {

	int addShowtime(Showtime showTime);

	List<Showtime> getShowtimeByMovie(Movie movie);

	 List<Showtime> getShowtimeByTheater(Theater theater);
	 void deleteShowtime(Showtime showtime);
	 void updateShowtime(Showtime showtime);

}
