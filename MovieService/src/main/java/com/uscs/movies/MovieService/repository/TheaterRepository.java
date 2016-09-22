package com.uscs.movies.MovieService.repository;

import java.util.List;

import com.uscs.movies.MovieService.entity.Showtime;
import com.uscs.movies.MovieService.entity.Theater;

public interface TheaterRepository {

	Theater getTheater(int theaterId);

	List<Theater> getTheaterByZipcode(int zipcode);

	List<Theater> getTheaterByCity(String city);
	// List<Theater> getTheaterByMovie(int movieId);

	int addTheater(Theater theater);

	void updateTheater(Theater theater);

	void deleteTheater(Theater theater);

}
