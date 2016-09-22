package repository;
import java.util.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.RatingRepository;
import com.uscs.movies.MovieService.repository.ReviewRepository;
import com.uscs.movies.MovieService.repository.UserRepository;

import antlr.collections.List;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestUserRepository extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RatingRepository ratingRepositoy;

	@Autowired
	private ReviewRepository reviewRepository;

	@Test
	@Rollback(false)
	public void addAndGetUser() {
		UserImpl newUser = new UserImpl();
		newUser.setFirstName("raj");
		newUser.setLastName("sharma");
		newUser.setEmail("raj.rajput@gmail.com");
		newUser.setPassword("1245");

		// create new user
		int addedUserId = userRepository.addUser(newUser);
		System.out.println("user added id " + addedUserId);
		Assert.assertNotEquals(0, addedUserId);

		// get user
		User found = userRepository.getUser(addedUserId);
		System.out.println("Email" + found.getEmail());
		Assert.assertEquals(found.getId(), addedUserId);
		Assert.assertEquals(found.getFirstName(), newUser.getFirstName());
		Assert.assertEquals(found.getLastName(), newUser.getLastName());
		
		// getuser by firstname
		
//		List<User> found = userRepository.searchByFn("dhwani");
//		for (int i = 0; i < foundUsers.size(); i++) {
//			
//			System.out.println(((java.util.List<User>) foundUsers).get(i).getFirstName());
//			
//
//		}
		// update User
		newUser.setLastName("shah");
		newUser.setEmail("sana.shah@gmail.com");
		userRepository.update(found);

		// delete user
		ratingRepositoy.deleteRatingsByUser(found);
		reviewRepository.deleteReviewByUser(found);
		userRepository.delete(found.getId());
	}
}
