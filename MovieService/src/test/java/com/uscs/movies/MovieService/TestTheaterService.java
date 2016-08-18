package com.uscs.movies.MovieService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


import com.uscs.movies.MovieService.entity.Theaters;
import com.uscs.movies.MovieService.services.TheaterService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestTheaterService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private TheaterService thservice;
	
	
	@Test
	public void testGetUser(){
		Theaters thget = thservice.getTheater(11);
		
		thget.setTheaterName("AMC");
		thget.setTheaterAddress("great mall,Milpitas");
		
		
		Assert.assertEquals("AMC", thget.getTheaterName());
	
		Assert.assertEquals(11, thget.getTheaterId());
		// will implement update user and delete user after database implementation
		System.out.println(thget);
	}
	
}

