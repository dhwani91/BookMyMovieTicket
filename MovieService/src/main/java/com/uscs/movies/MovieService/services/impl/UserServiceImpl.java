package com.uscs.movies.MovieService.services.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.UserRepository;
import com.uscs.movies.MovieService.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final int MAX_NAME_LENGTH = 45;
	private static final int MAX_PIN_LENGTH = 10;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional // at method level
	public User getUser() {
		// TODO Auto-generated method stub
		return new UserImpl();
	}

	@Transactional // at method level
	@Override
	public void addUser(User user) {

		if (StringUtils.isEmpty(user.getFirstName()) || user.getFirstName().length() > MAX_NAME_LENGTH) {
			try {
				throw new Exception("firstName is required");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (StringUtils.isEmpty(user.getLastName()) || user.getLastName().length() > MAX_NAME_LENGTH) {
			try {
				throw new Exception("lastName is required");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
	}

	@Transactional // at method level
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Transactional // at method level
	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
