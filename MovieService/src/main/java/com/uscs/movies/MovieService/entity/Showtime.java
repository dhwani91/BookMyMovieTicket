package com.uscs.movies.MovieService.entity;

import java.util.Date;

public interface Showtime {

	Movie getMovie();

	Theater getTheater();

	void setShowtiming(Movie movie,Theater theater,Date showtiming);

	Date getShowtiming();

	int getshowtimeId();

}
