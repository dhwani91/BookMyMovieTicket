package com.uscs.movies.MovieService.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.uscs.movies.MovieService.entity.User;

@NamedQueries({ @NamedQuery(name = "findUserByFn", query = "SELECT u FROM UserImpl u WHERE u.firstName = :firstName") })
@Entity
@Table(name = "user")
public class UserImpl implements User {
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "fName")
	private String firstName;

	@Column(name = "lName")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;

	}

	@Override
	public void setFirstName(String firstname) {
		// TODO Auto-generated method stub
		this.firstName = firstname;

	}

	@Override
	public void setLastName(String lastname) {
		// TODO Auto-generated method stub
		this.lastName = lastname;

	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserImpl [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Email=" + email
				+ ",password=" + password + "]";
	}
}
