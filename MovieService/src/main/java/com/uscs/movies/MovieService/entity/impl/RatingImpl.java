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
import com.uscs.movies.MovieService.entity.Rating;
import com.uscs.movies.MovieService.entity.User;

@NamedQueries({ @NamedQuery(name = "deleteRatingByUser", query = "DELETE FROM RatingImpl re WHERE re.user = :user"),
		@NamedQuery(name = "getRatingByUser", query = "SELECT re FROM RatingImpl re WHERE re.user= :user"),
		@NamedQuery(name = "getRatingByMovie", query = "SELECT re FROM RatingImpl re WHERE re.movie= :movie") })
@Entity
@Table(name = "ratings")
public class RatingImpl implements Rating {

	@Id
	@Column(name = "ratingsId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingId;

	@ManyToOne(targetEntity = MovieImpl.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "movieId", nullable = false)
	Movie movie;

	@ManyToOne(targetEntity = UserImpl.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", nullable = false)
	User user;

	@Column(name = "ratings")
	private int ratings;

	public String toString() {
		return "rating [id=" + movie.getMovieId() + ", Ratings=" + ratings + "]";
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public Movie getMovie() {
		return movie;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void setRatings(Movie movie, User user, int ratings) {

		this.movie = movie;
		this.user = user;
		this.ratings = ratings;

	}

	@Override
	public List<Rating> getRatingByUser(User user) {

		return null;
	}

	@Override
	public List<Rating> getRatingsByMovie(Movie movie) {

		return null;
	}

	@Override
	public Rating getRating(int rating) {
		
		return null;
	}

	public void setStar(int star) {
		this.ratings = star;

	}

	@Override
	public int getStar() {

		return ratings;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	@Override
	public int getRatingId() {

		return ratingId;
	}
}
