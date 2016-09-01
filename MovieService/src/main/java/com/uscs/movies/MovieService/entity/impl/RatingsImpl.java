package com.uscs.movies.MovieService.entity.impl;

import com.uscs.movies.MovieService.entity.Ratings;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class RatingsImpl implements Ratings {

	@Id
	@Column(name = "ratingsId")
	private int ratingId;
	
	@Column(name = "movieId")
	private int movieId;

	@Column(name = "ratings")	
	private int ratings;

	public RatingsImpl(int id) {
		this.movieId = id;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setRatings(int movieId, int stars) {
		// TODO Auto-generated method stub
		this.movieId = movieId;
		this.ratings = stars;
	}

	@Override
	public int getRatings(int movieId) {
		// TODO Auto-generated method stub
		return ratings;
	}

	public String toString() {
		return "ReviewImpl [id=" + movieId + ", Ratings=" + ratings + "]";
	}
}
