package com.uscs.movies.MovieService.entity.impl;

import com.uscs.movies.MovieService.entity.Reviews;
public class ReviewImpl implements Reviews{
private int movieId;
private String review;
	@Override
	public void setReview(int movieId, String review) {
		// TODO Auto-generated method stub
		this.movieId=movieId;
		this.review=review;
	}

	@Override
	public String getReview(int movieId) {
		// TODO Auto-generated method stub
		return review;
	}
	public String toString() {
		return "ReviewImpl [id=" + movieId + ", Review=" + review+"]";
	}
}