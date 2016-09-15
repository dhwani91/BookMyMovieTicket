package com.uscs.movies.MovieService.services;

import java.util.List;

import com.uscs.movies.MovieService.entity.Theater;

public interface TheaterService {
	Theater getTheater(int theaterId);

	Theater addTheater(Theater theater);

	void updateTheater(Theater theater);

	void deleteTheater(int  theaterId);

	List<Theater> getTheaterByZipcode(int zipcode);

	List<Theater> getTheaterByCity(String city);
}
