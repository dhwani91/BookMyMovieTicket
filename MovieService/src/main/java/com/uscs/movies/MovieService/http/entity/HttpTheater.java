package com.uscs.movies.MovieService.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uscs.movies.MovieService.entity.Address;
import com.uscs.movies.MovieService.entity.Theater;

public class HttpTheater {

	public int theaterId;

	public String theaterName;

	public String city;

	public String state;

	public String street;

	public int zipcode;

	// required by framework
	protected HttpTheater() {
	}

	public HttpTheater(Theater theater) {
		this.theaterId = theater.getTheaterId();
		this.theaterName = theater.getTheaterName();
		this.city = theater.getAddress().getCity();
		this.state = theater.getAddress().getState();
		this.street = theater.getAddress().getStreet();
		this.zipcode = theater.getAddress().getZip();
	}
}
