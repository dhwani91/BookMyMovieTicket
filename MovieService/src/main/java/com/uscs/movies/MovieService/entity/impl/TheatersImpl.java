package com.uscs.movies.MovieService.entity.impl;

import com.uscs.movies.MovieService.entity.Theaters;

public class TheatersImpl implements Theaters {
private int theaterId;
private String theaterName;
private String theaterAddress;

public TheatersImpl(int id) {
	this.theaterId=id;
	// TODO Auto-generated constructor stub
}
	@Override
	public void setTheaterName(String theaterName) {
		// TODO Auto-generated method stub
		this.theaterName=theaterName;
	}

	@Override
	public void setTheaterAddress(String theaterAddress) {
		// TODO Auto-generated method stub
		this.theaterAddress=theaterAddress;
	}

	@Override
	public int getTheaterId() {
		// TODO Auto-generated method stub
		return theaterId;
	}

	@Override
	public String getTheaterName() {
		// TODO Auto-generated method stub
		return theaterName;
	}
	@Override
	public String getTheaterAddress() {
		// TODO Auto-generated method stub
		return theaterAddress;
	}
	@Override
	public String toString() {
		return "TheaterImpl [id=" + theaterId + ", Theater=" + theaterName
				+ ", Theater_address=" + theaterAddress + "]";
	}

}
