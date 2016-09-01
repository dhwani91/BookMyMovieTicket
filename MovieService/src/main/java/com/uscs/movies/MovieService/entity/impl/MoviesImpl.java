package com.uscs.movies.MovieService.entity.impl;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.uscs.movies.MovieService.entity.Movies;
import com.uscs.movies.MovieService.entity.Ratings;
import com.uscs.movies.MovieService.entity.Reviews;
import com.uscs.movies.MovieService.entity.Theaters;

@Entity
@Table(name="movies")
public class MoviesImpl implements Movies {
	
@Id
@Column(name="movieId")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int movieId;

@Column(name="movieName")
private String movieName;

@Column(name="movieType")
private String movieType;

@Column(name="movieDesc")
private String movieDesc;
//
//@OneToMany(targetEntity=ReviewImpl.class, cascade=CascadeType.ALL, mappedBy="movies")
//private Reviews review;
//
//@OneToMany(targetEntity=RatingsImpl.class, cascade=CascadeType.ALL, mappedBy="movies")
//private Ratings ratings;
//
//@ManyToMany(targetEntity=TheatersImpl.class, cascade=CascadeType.ALL, mappedBy="movies")
//private Theaters theater;

public MoviesImpl(int movieId) {
	this.movieId = movieId;
}
@Override
public void setMovieName(String moviename) {
	// TODO Auto-generated method stub
this.movieName=moviename;	
}
@Override
public void setMovieType(String movieType) {
	// TODO Auto-generated method stub
	this.movieType=movieType;
}
@Override
public void setMovieDesc(String movieDesc) {
	// TODO Auto-generated method stub
	this.movieDesc=movieDesc;
}
@Override
public String getMovieName() {
	// TODO Auto-generated method stub
	return movieName;
}
@Override
public String getMovieType() {
	// TODO Auto-generated method stub
	return movieType;
}
@Override
public String getMovieDesc() {
	// TODO Auto-generated method stub
	return movieDesc;
}
@Override
public String toString() {
	return "MovieImpl [id=" + movieId + ", Movie Name=" + movieName
			+ ", Movie Type=" + movieType + ", Movie info=" + movieDesc+ "]";
}
}
