package com.uscs.movies.MovieService.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uscs.movies.MovieService.entity.Movie;
@XmlRootElement(name = "movie")
public class HttpMovie {
	@XmlElement
	public long id;
	
	@XmlElement
	public String movieName;
	
	@XmlElement
	public String movieType;
	
	@XmlElement
	public String movieDesc;
	
	//required by framework
	protected HttpMovie() {}

	public HttpMovie(Movie movie) {
		this.id=movie.getId();
		this.movieName=movie.getMovieName();
		this.movieType=movie.getMovieType();
		this.movieDesc=movie.getMovieDesc();
	}
}
