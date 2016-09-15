package com.uscs.movies.MovieService.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.uscs.movies.MovieService.entity.Movie;

@NamedQueries({
		@NamedQuery(name = "listMovieByType", query = "SELECT re FROM MovieImpl re WHERE re.movieType = :movieType") })
@Entity
@Table(name = "movies")
public class MovieImpl implements Movie {

	@Id
	@Column(name = "movieId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;

	@Column(name = "movieName", nullable = false, unique = true)
	private String movieName;

	@Column(name = "movieType")
	private String movieType;

	@Column(name = "movieDesc")
	private String movieDesc;

	public MovieImpl() {

	}

	@Override
	public void setMovieName(String moviename) {

		this.movieName = moviename;
	}

	@Override
	public void setMovieType(String movieType) {

		this.movieType = movieType;
	}

	@Override
	public void setMovieDesc(String movieDesc) {

		this.movieDesc = movieDesc;
	}

	@Override
	public String getMovieName() {

		return movieName;
	}

	@Override
	public String getMovieType() {

		return movieType;
	}

	@Override
	public String getMovieDesc() {

		return movieDesc;
	}

	@Override
	public int getId() {
		return movieId;
	}

	@Override
	public String toString() {
		return "MovieImpl [id=" + movieId + ", Movie Name=" + movieName + ", Movie Type=" + movieType + ", Movie info="
				+ movieDesc + "]";
	}

}
