package com.uscs.movies.MovieService.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.uscs.movies.MovieService.entity.Reviews;
@Entity
@Table(name="review")
public class ReviewImpl implements Reviews{
	
@Id
@Column(name="reviewId")
private int reviewId;

@Column(name="movieId")
private int movieId;

@Column(name="review")
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