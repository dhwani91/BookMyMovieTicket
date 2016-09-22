package com.uscs.movies.MovieService.http.entity;

import com.uscs.movies.MovieService.entity.User;

public class HttpUser {

	public int userId;

	public String firstName;

	public String lastName;

	public String email;

	public String password;

	// required by framework
	protected HttpUser() {
	}

	public HttpUser(User user) {
		this.userId = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.password=user.getPassword();
	}

	public int getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
