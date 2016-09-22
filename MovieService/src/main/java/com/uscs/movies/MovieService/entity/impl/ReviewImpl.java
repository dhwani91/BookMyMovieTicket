package com.uscs.movies.MovieService.entity.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.User;

@NamedQueries({ @NamedQuery(name = "deleteReviewByUser", query = "DELETE FROM ReviewImpl re WHERE re.user = :user"),
				@NamedQuery(name="getReviewByUser",query="SELECT re FROM ReviewImpl re WHERE re.user = :user"),
				@NamedQuery(name="getReviewByMovie",query="SELECT re FROM ReviewImpl re WHERE re.movie = :movie")})
@Entity
@Table(name = "review")
public class ReviewImpl implements Review {

	@Id
	@Column(name = "reviewId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;

	@ManyToOne(targetEntity = MovieImpl.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "movieId", nullable = false)
	Movie movie;

	@ManyToOne(targetEntity = UserImpl.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	User user;

	@Column(name = "review")
	private String review;

	@Override
	public String getReview() {
		return review;
	}

	public String toString() {
		return "ReviewImpl [id=" + movie.getMovieId() + ", Review=" + review + "]";
	}

	@Override
	public Movie getMovie() {
		return movie;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void setReview(Movie movie, User user, String review) {
		this.movie = movie;
		this.user = user;
		this.review = review;
	}

	@Override
	public List<Review> getReviewByUser(User user) {
		
		return null;
	}

	@Override
	public List<Review> getReviewByMovie(Movie movie) {

		return null;
	}

	@Override
	public Review getReview(int reviewId) {

		return null;
	}
	
	public void setReviewId(int reviewId){
		this.reviewId=reviewId;
	}

	@Override
	public int getReviewId() {

		return reviewId;
	}

}