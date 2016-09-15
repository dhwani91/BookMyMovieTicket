package com.uscs.movies.MovieService.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.uscs.movies.MovieService.entity.Address;
import com.uscs.movies.MovieService.entity.Theater;

@XmlRootElement(name = "theater")
public class HttpTheater {
	@XmlElement
	public int theaterId;

	@XmlElement
	public String theaterName;
//
//	@XmlElement
//	public Address thAddress;
	
	@XmlElement
	public String city;
	@XmlElement
	public String state;
	@XmlElement
	public String street;
	@XmlElement
	public int zipcode;
	

	// required by framework
	protected HttpTheater() {
	}

	public HttpTheater(Theater theater) {
		this.theaterId = theater.getTheaterId();
		this.theaterName = theater.getTheaterName();
//		this.thAddress = theater.getAddress();
		this.city=theater.getAddress().getCity();
		this.state=theater.getAddress().getState();
		this.street=theater.getAddress().getStreet();
		this.zipcode=theater.getAddress().getZip();
	}
}
