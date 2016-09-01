package com.uscs.movies.MovieService.entity.impl;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.uscs.movies.MovieService.entity.Movies;
import com.uscs.movies.MovieService.entity.Theaters;
@Entity
@Table(name="theater")
public class TheatersImpl implements Theaters {
@Id
@Column(name="theaterId")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int theaterId;

@Column(name="theaterName")
private String theaterName;

@Column(name="theaterAdd")
private String theaterAddress;

//@ManyToMany(targetEntity=MoviesImpl.class, cascade=CascadeType.ALL, mappedBy="theater")
//private Movies movie;

public TheatersImpl(int id) {
	this.theaterId=id;
	// TODO Auto-generated constructor stub
}
	@Override
	public void setTheaterName(String theaterName) {
		// TODO Auto-generated method stub
		this.theaterName=theaterName;
	}

	@Override
	public void setTheaterAddress(String theaterAddress) {
		// TODO Auto-generated method stub
		this.theaterAddress=theaterAddress;
	}

	@Override
	public int getTheaterId() {
		// TODO Auto-generated method stub
		return theaterId;
	}

	@Override
	public String getTheaterName() {
		// TODO Auto-generated method stub
		return theaterName;
	}
	@Override
	public String getTheaterAddress() {
		// TODO Auto-generated method stub
		return theaterAddress;
	}
	@Override
	public String toString() {
		return "TheaterImpl [id=" + theaterId + ", Theater=" + theaterName
				+ ", Theater_address=" + theaterAddress + "]";
	}

}
