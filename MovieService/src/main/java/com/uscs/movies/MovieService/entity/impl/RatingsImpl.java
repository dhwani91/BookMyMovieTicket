package com.uscs.movies.MovieService.entity.impl;

import com.uscs.movies.MovieService.entity.Ratings;

public class RatingsImpl implements Ratings {
	private int movieId;
	private int ratings;
	public RatingsImpl(int id) {
		this.movieId=id;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void setRatings(int movieId, int stars) {
		// TODO Auto-generated method stub
		this.movieId=movieId;
		this.ratings=stars;
	}
	@Override
	public int getRatings(int movieId) {
		// TODO Auto-generated method stub
		return ratings;
	}
	public String toString() {
		return "ReviewImpl [id=" + movieId + ", Ratings=" + ratings+"]";
	}
}
