package com.uscs.movies.MovieService.services;

import com.uscs.movies.MovieService.entity.*;


	public interface UserService {

		User getUser(long userId);
		void addUser(User user);
		void updateUser(User user);
		void deleteUser(long userId);
	}


