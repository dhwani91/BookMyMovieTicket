package com.uscs.movies.MovieService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;





import com.uscs.movies.MovieService.entity.Movies;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.services.MovieService;


@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMovieService extends AbstractJUnit4SpringContextTests  {
	@Autowired
	private MovieService movieservice;
	
	
	@Test
	public void testGetUser(){
		Movies moviesget = movieservice.getMovies(122);		
		moviesget.setMovieName("American snipperS");
		moviesget.setMovieType("action");	
		movieservice.addMovies(moviesget);
//		Assert.assertEquals("hello", moviesget.getMovieType());
		Assert.assertTrue(moviesget instanceof Movies);
		// will implement update movies and delete movies after database implementation
		System.out.println(moviesget);
	}
	
}


