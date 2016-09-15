package com.uscs.movies.MovieService.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.uscs.movies.MovieService.entity.Address;
import com.uscs.movies.MovieService.entity.Theater;

@Entity
@Table(name = "theater_address")
public class AddressImpl implements Address {
	@Id
	@Column(name = "thaddressId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int thAddressId;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zipcode")
	private int zipcode;
	
	public void setStreet(String street){
		this.street=street;
	}
	@Override
	public String getStreet() {
		return street;
	}

	public void setCity(String city){
		this.city=city;
	}
	@Override
	public String getCity() {
		return city;
	}

	public void setState(String state){
		this.state=state;
	}
	@Override
	public String getState() {
		return state;
	}
	public void setZip(int zipcode){
		this.zipcode=zipcode;
	}

	@Override
	public int getZip() {
		return zipcode;
	}


}
