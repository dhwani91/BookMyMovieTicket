package com.uscs.movies.MovieService.services;

import com.uscs.movies.MovieService.entity.Theaters;

public interface TheaterService {
	Theaters getTheater(int theaterId);
	void addTheater(Theaters theater);
	void updateTheater(Theaters theater);
	void deleteTheater(int theaterId);
}
