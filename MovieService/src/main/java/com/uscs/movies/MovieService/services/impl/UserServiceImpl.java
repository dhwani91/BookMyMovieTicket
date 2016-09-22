package com.uscs.movies.MovieService.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.RatingRepository;
import com.uscs.movies.MovieService.repository.ReviewRepository;
import com.uscs.movies.MovieService.repository.UserRepository;
import com.uscs.movies.MovieService.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static final int MAX_NAME_LENGTH = 45;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReviewRepository reviewrepository;

	@Autowired
	private RatingRepository ratingsRepository;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional // at method level
	@Override
	public User addUser(User user) throws Exception {
		if (StringUtils.isEmpty(user.getFirstName()) || user.getFirstName().length() > MAX_NAME_LENGTH) {
			try {
				throw new Exception("firstName is required");
			} catch (Exception e) {
				logger.error("addUser", e);
			}
		}

		if (StringUtils.isEmpty(user.getLastName()) || user.getLastName().length() > MAX_NAME_LENGTH) {
			try {
				throw new Exception("Lastanme is required");
			} catch (Exception e) {
				logger.error("addUser", e);
			}
		}
		UserImpl impl = (UserImpl)user;		
		int id =  (int) userRepository.addUser(user);
		return getUser(id);
//		userRepository.addUser(user);
	}
	

	@Transactional // at method level
	@Override
	public void updateUser(User user) {
		userRepository.update(user);
		

	}

	@Transactional // at method level
	@Override
	public void deleteUser(int userId) {
		User user = getUser(userId);
		reviewrepository.deleteReviewByUser(user);
		ratingsRepository.deleteRatingsByUser(user);
		userRepository.delete(userId);

	}

	@Transactional
	@Override
	public User getUser(int userId) {
		return userRepository.getUser(userId);
	}

	@Transactional
	@Override
	public List<User> searchByName(String firstName) {
		List <User> searchUser=userRepository.searchByFn(firstName);
		return searchUser;
	}

}
