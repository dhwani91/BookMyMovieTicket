package com.uscs.movies.MovieService.repository;

import java.util.List;

import com.uscs.movies.MovieService.entity.User;

public interface UserRepository {

	/**
	 * 
	 * @param user
	 * @return the id of the newly added user
	 */
	long addUser(User user);

	User getUser(long userId);

	List<User> search(String firstName, String lastName);

	List<User> searchByFn(String firstName);

	void update(User user);

	void delete(long userId);

}
