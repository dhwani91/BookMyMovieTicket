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

import com.uscs.movies.MovieService.entity.FavouriteTheater;
import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;

@NamedQueries({
		@NamedQuery(name = "deleteFavouriteTheater", query = "DELETE  FROM FavouriteTheaterImpl re WHERE re.theater = :theater"),
		@NamedQuery(name = "listFavouriteTheaters", query = "SELECT re FROM FavouriteTheaterImpl re WHERE re.user = :user") })

@Entity
@Table(name = "favourite_theaters")
public class FavouriteTheaterImpl implements FavouriteTheater {

	@Id
	@Column(name = "favTheaterId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favTheaterId;

	@ManyToOne(targetEntity = UserImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	@ManyToOne(targetEntity = TheaterImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "theaterId", nullable = false)
	private Theater theater;

	@Override
	public void setFavouriteTheater(User user, Theater theater) {

		this.user = user;
		this.theater = theater;
	}

	@Override
	public List<FavouriteTheater> listFavouriteTheater() {

		return (List<FavouriteTheater>) theater;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getUser() {
		return user;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	@Override
	public Theater getTheater() {
		return theater;
	}

}
