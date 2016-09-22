package repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.ReviewImpl;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.MovieRepository;
import com.uscs.movies.MovieService.repository.ReviewRepository;
import com.uscs.movies.MovieService.repository.UserRepository;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestReviewRepository extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	ReviewRepository reviewRepo;

	@Autowired
	MovieRepository movieRepo;

	@Autowired
	UserRepository userRepo;

	@Test
	@Rollback(false)
	public void addAndGetReview() {
		ReviewImpl newReview = new ReviewImpl();
		UserImpl newUser = new UserImpl();
		MovieImpl newMovie = new MovieImpl();

		// add movie

		newMovie.setMovieName("civil war");
		newMovie.setMovieDesc("animation  3-d movie");
		newMovie.setMovieType("action");

		// add user

		newUser.setFirstName("sunny");
		newUser.setLastName("deol");
		newUser.setEmail("sunny.deol@gmail.com");
		newUser.setPassword("hell90");

		long moId = movieRepo.addMovies(newMovie);
		System.out.println("added movie" + moId);
		long longId = userRepo.addUser(newUser);
		System.out.println("added user:" + longId);
		
		// add movie review
		newReview.setReview(newMovie, newUser, "boring movie till intermission");
		int  reId = reviewRepo.addReview(newReview);
		System.out.println("added revie:" + reId);
		

		// get review by user
		reviewRepo.listReviewByUser(newUser);
		
		//list review by movies
		reviewRepo.listReviewByMovies(newMovie);

		// update review
		newMovie.setMovieName("shandar");
		newReview.setReview(newMovie, newUser, "awful");
		reviewRepo.updateReview(newReview);

		// get review by user after update
		reviewRepo.listReviewByUser(newUser);

		// delete review
		reviewRepo.deleteReview(newReview);
	}

}
