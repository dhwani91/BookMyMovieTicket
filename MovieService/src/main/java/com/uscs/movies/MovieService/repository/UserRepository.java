package com.uscs.movies.MovieService.repository;

import java.util.List;

import com.uscs.movies.MovieService.entity.User;

public interface UserRepository {

	/**
	 * 
	 * @param user
	 * @return the id of the newly added user
	 */
	int addUser(User user);

	User getUser(int userId);

	List<User> search(String firstName, String lastName);

	List<User> searchByFn(String firstName);

	void update(User user);

	void delete(int userId);

}
