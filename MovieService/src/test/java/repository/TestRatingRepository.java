package repository;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.uscs.movies.MovieService.entity.Rating;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.RatingImpl;
import com.uscs.movies.MovieService.entity.impl.ReviewImpl;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.MovieRepository;
import com.uscs.movies.MovieService.repository.RatingRepository;
import com.uscs.movies.MovieService.repository.UserRepository;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestRatingRepository extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	RatingRepository ratingsRepo;

	@Autowired
	MovieRepository movieRepo;

	@Autowired
	UserRepository userRepo;

	@Test
	@Rollback(false)
	public void addAndGetReview() {
		RatingImpl newRatings = new RatingImpl();
		UserImpl newUser = new UserImpl();
		MovieImpl newMovie = new MovieImpl();
		
		// add new movie
		newMovie.setMovieName("bar bar dekho");
		newMovie.setMovieDesc("drama and comedy ");
		newMovie.setMovieType("romentic");
		
		// add new user
		newUser.setFirstName("shan");
		newUser.setLastName("mehta");
		newUser.setEmail("shan.mehta@gmail.com");
		newUser.setPassword("123456");

		long moId = movieRepo.addMovies(newMovie);
		System.out.println("added movie"+ moId);
		long longId = userRepo.addUser(newUser);
		System.out.println("added user:" + longId);
		
		// add movie ratings
		newRatings.setRatings(newMovie, newUser, 2);
		int reId = ratingsRepo.addRatings(newRatings);
		System.out.println("added revie:" + reId);
		
		//get ratings by user
		
		List<Rating> ratingListByUser=ratingsRepo.listRatingsByUser(newUser);
		System.out.println(ratingListByUser);

		// get ratings by movie
		List<Rating> ratingListByMovie=ratingsRepo.listRatingsByMovie(newMovie);
		System.out.println(ratingListByMovie);
		
		//update ratings
		newRatings.setRatings(newMovie, newUser, 5);
		ratingsRepo.updateRatings(newRatings);
		
		
		//delete rating
		ratingsRepo.deleteRating(newRatings);
	
	}
}
