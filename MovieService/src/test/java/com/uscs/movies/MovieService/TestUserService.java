package com.uscs.movies.MovieService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.services.UserService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUserService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private UserService userService;
	
	
	@Test
	public void testGetUser(){
		User userGet = userService.getUser(123);
		
		userGet.setEmail("dhwani.sanghvi91@gmail.com");
		userGet.setFirstName("dhwani");
		userGet.setPassword("hello");
		Assert.assertEquals("dhwani.sanghvi91@gmail.com", userGet.getEmail());
		Assert.assertEquals("dhwani", userGet.getFirstName());
		Assert.assertTrue(userGet instanceof User);
		Assert.assertEquals(123, userGet.getId());
		// will implement update user and delete user after database implementation
		System.out.println(userGet);
	}
	
}

