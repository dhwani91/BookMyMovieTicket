package com.uscs.movies.MovieService.entity;

public interface Reviews {
	void setReview(int movieId,String review);
	String getReview(int movieId);
}
