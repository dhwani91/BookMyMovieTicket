package com.uscs.movies.MovieService.repository;

import com.uscs.movies.MovieService.entity.Theaters;

public interface TheaterRepository {

	Theaters getTheater(int theaterId);
	long addTheater(Theaters theater);
	void updateTheater(Theaters theater);
	void deleteTheater(int theaterId);
}
