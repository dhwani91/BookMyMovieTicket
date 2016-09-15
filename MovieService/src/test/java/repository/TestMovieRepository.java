package repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.repository.MovieRepository;
import com.uscs.movies.MovieService.repository.RatingRepository;
import com.uscs.movies.MovieService.repository.ReviewRepository;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestMovieRepository extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private RatingRepository ratingRepositoy;

	@Autowired
	private ReviewRepository reviewRepository;

	@Test
	@Rollback(false)
	public void addAndGetMovies() {
		MovieImpl newMovie = new MovieImpl();

		// add movie
		newMovie.setMovieName("tarzan");
		newMovie.setMovieDesc("animation movie");
		newMovie.setMovieType("drama");
		int addedmovieId = (int) movieRepository.addMovies(newMovie);
		System.out.println("movie added id " + addedmovieId);

		// get movie
		Movie found = movieRepository.getMovies(addedmovieId);

		// update movie
		newMovie.setMovieName("The sully");
		newMovie.setMovieType("biography");
		movieRepository.updateMovie(newMovie);

		// delete movie

		movieRepository.deleteMovie(found.getId());

	}
}
