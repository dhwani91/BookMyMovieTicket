package com.uscs.movies.MovieService.entity.impl;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
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
import com.uscs.movies.MovieService.entity.Showtime;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;
@NamedQueries({@NamedQuery(name = "listShowtimeByMovie1",query="SELECT re FROM ShowtimeImpl re WHERE re.movie = :movie")})
@Entity
@Table(name = "showtime")

public class ShowtimeImpl implements Showtime {
	@Id
	@Column(name = "showtimeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showtimeId;

	@Column(name = "showtimings")
	private Date showtiming;

	@ManyToOne(targetEntity = MovieImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "movieId", nullable = false)
	Movie movie;

	@ManyToOne(targetEntity = TheaterImpl.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "theaterId", nullable = false)
	Theater theater;

	void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public Movie getMovie() {
		return movie;
	}

	void setTheater(Theater theater) {
		this.theater = theater;
	}

	@Override
	public Theater getTheater() {

		return theater;
	}

	@Override
	public void setShowtiming(Movie movie,Theater theater,Date showtiming) {
		this.movie=movie;
		this.theater=theater;
		this.showtiming = showtiming;
	}

	@Override
	public Date getShowtiming() {
		return showtiming;
	}

	@Override
	public int getshowtimeId() {

		return showtimeId;
	}

}
