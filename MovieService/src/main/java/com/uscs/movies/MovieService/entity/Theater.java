package com.uscs.movies.MovieService.entity;

import java.util.List;

public interface Theater {

	void setTheaterName(String theaterName);

	int getTheaterId();

	String getTheaterName();

	Address getAddress();
	
	void setTheaterId(int theaterId);
	
//	List<Showtime> getShowtime();

}
