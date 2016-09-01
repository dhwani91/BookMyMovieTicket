package com.uscs.movies.MovieService;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.UserRepository;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUserRepository extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	private UserRepository userRepository;

	@Test
	public void addUser(){
		UserImpl newUser = new UserImpl();
	}
//	public void addAndGetUser(){
//		UserImpl newUser = new UserImpl();
//		newUser.setFirstName("fname");
//		newUser.setLastName("lastName");
//		long  addedUserId = userRepository.addUser(newUser);
//		System.out.println("user added id "+addedUserId);
//		Assert.assertNotEquals(0, addedUserId);		
//		
//		User found = userRepository.getUser(addedUserId);
//		Assert.assertEquals(found.getId(), addedUserId);
//		Assert.assertEquals(found.getFirstName(), newUser.getFirstName());
//		Assert.assertEquals(found.getLastName(), newUser.getLastName());
//	}
}


