package repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.UserRepository;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestUserRepository extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private UserRepository userRepository;

	@Test
	public void addAndGetUser() {
		UserImpl newUser = new UserImpl();
		newUser.setFirstName("priya");
		newUser.setLastName("shelat");
		newUser.setEmail("priya.shelat@gmail.com");
		newUser.setPassword("1234");
		long addedUserId = userRepository.addUser(newUser);
		System.out.println("user added id " + addedUserId);
		Assert.assertNotEquals(0, addedUserId);
		List<User> users=userRepository.search("priya", "shelat");
		System.out.println(users);
		User found = userRepository.getUser(addedUserId);
		System.out.println("Email"+found.getEmail());
		Assert.assertEquals(found.getId(), addedUserId);
		Assert.assertEquals(found.getFirstName(), newUser.getFirstName());
		Assert.assertEquals(found.getLastName(), newUser.getLastName());
	}
}
