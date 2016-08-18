package com.uscs.movies.MovieService.entity.impl;
import com.uscs.movies.MovieService.entity.Movies;
public class MoviesImpl implements Movies {
private int movieId;
private String movieName;
private String movieType;
private String movieDesc;

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
