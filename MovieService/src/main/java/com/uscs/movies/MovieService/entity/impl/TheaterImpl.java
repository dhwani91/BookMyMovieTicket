package com.uscs.movies.MovieService.entity.impl;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.uscs.movies.MovieService.entity.Address;
import com.uscs.movies.MovieService.entity.Theater;

@NamedQueries({
		@NamedQuery(name = "listTheaterByZipcode", query = "SELECT u FROM TheaterImpl u WHERE u.thAddress.zipcode = :zipcode"),
		@NamedQuery(name = "listTheaterByCity", query = "SELECT u FROM TheaterImpl u WHERE u.thAddress.city = :city") })

@Entity
@Table(name = "theaters")
public class TheaterImpl implements Theater {
	@Id
	@Column(name = "theaterId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theaterId;

	@Column(name = "theaterName", nullable = false)
	private String theaterName;

	@OneToOne(fetch = FetchType.EAGER, targetEntity = AddressImpl.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "thaddressId")
	private Address thAddress;

	public TheaterImpl() {

	}

	@Override
	public void setTheaterName(String theaterName) {

		this.theaterName = theaterName;
	}

	@Override
	public int getTheaterId() {

		return theaterId;
	}

	@Override
	public String getTheaterName() {

		return theaterName;
	}

	@Override
	public Address getAddress() {
		return thAddress;
	}

	public void setAddress(Address thaddress) {
		this.thAddress = thaddress;
	}

	// void getShowtime(List<Showtime> showtime){
	// this.showtime=showtime;
	//
	// }

	@Override
	public String toString() {
		return "TheaterImpl [id=" + theaterId + ", Theater=" + theaterName;
	}

}
