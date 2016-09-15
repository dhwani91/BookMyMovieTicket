package com.uscs.movies.MovieService;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.services.MovieService;
import com.uscs.movies.MovieService.services.ReviewService;
import com.uscs.movies.MovieService.services.UserService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestReviewService extends AbstractJUnit4SpringContextTests{
@Autowired
private ReviewService reviewService;
@Autowired
private MovieService movieService;
@Autowired
private UserService userService;

@Test
public void testGetReview(){
	Review reviewget = reviewService.getReview(11);
//	reviewget.setReview(11, "good");
//	Assert.assertEquals("good", reviewget.getReview(11));
	System.out.println(reviewget);
}

}
