package com.uscs.movies.MovieService.entity;

public interface User {
	long getId();

	String getFirstName();

	String getLastName();

	String getEmail();

	String getPassword();

	void setEmail(String email);

	void setFirstName(String firstname);

	void setLastName(String lastname);

	void setPassword(String password);
}
