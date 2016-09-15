package com.uscs.movies.MovieService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.services.TheaterService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestTheaterService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private TheaterService thservice;
	
	
	@Test
	public void testAndGetTheater(){
		
	}
	
}

