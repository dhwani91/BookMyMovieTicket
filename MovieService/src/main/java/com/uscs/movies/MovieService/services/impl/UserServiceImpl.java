package com.uscs.movies.MovieService.services.impl;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.services.UserService;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {

	@Override
	public User getUser(long userId) {
		// TODO Auto-generated method stub
		return new UserImpl(userId);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		
	}

}
