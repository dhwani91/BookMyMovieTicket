package com.uscs.movies.MovieService.services;

import java.util.List;

import com.uscs.movies.MovieService.entity.User;

public interface UserService {

	User getUser(int userId);

	User addUser(User user) throws Exception;

	void updateUser(User  user) ;

	void deleteUser(int userId);

	public List<User> searchByName(String firstName);


}
