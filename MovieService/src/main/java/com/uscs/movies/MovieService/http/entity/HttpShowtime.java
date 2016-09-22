package com.uscs.movies.MovieService.http.entity;

import java.util.Date;

import com.uscs.movies.MovieService.entity.Showtime;

public class HttpShowtime {
	private int showtimeId;

	public int movieId;
	private int theaterId;
	private Date showTime;

	protected  HttpShowtime() {}
	

	public HttpShowtime(Showtime showtime){
		this.showtimeId=showtime.getshowtimeId();
		this.movieId=showtime.getMovie().getMovieId();
		this.theaterId=showtime.getTheater().getTheaterId();
		this.showTime=showtime.getShowtiming();
	}
	public int getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(int showtimeId) {
		this.showtimeId = showtimeId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public Date getShowTime() {
		return showTime;
	}

	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}

}
