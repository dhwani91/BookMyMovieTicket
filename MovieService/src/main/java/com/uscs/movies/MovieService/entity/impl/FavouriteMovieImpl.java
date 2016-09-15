package com.uscs.movies.MovieService.entity.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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

import com.uscs.movies.MovieService.entity.FavouriteMovie;
import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.User;

@NamedQueries({
		@NamedQuery(name = "deleteFavouriteMovie", query = "DELETE  FROM FavouriteMovieImpl re WHERE re.movie = :movie"),
		@NamedQuery(name = "listFavouriteMovies", query = "SELECT re FROM FavouriteMovieImpl re WHERE re.user = :user") })
@Entity
@Table(name = "favourite_movies")
public class FavouriteMovieImpl implements FavouriteMovie {

	@Id
	@Column(name = "favMovieId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int favMovieId;
	
	@ManyToOne(targetEntity = UserImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@ManyToOne(targetEntity = MovieImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "movieId", nullable = false)
	private Movie movie;

	@Override
	public void setFavouriteMovie(User user, Movie movie) {
		this.user = user;
		this.movie = movie;
	}

	@Override
	public List<FavouriteMovie> listFavouriteMovie() {
		return (List<FavouriteMovie>) movie;
	}
	
	public void setUser(){
		this.user=user;
	}

	@Override
	public User getUser() {
		return user;
	}

	public void setMovie(){
		this.movie=movie;
	}	
	
	@Override
	public Movie getMovie() {
		return movie;
	}

}
