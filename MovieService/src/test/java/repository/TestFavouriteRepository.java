package repository;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.uscs.movies.MovieService.entity.FavouriteMovie;
import com.uscs.movies.MovieService.entity.FavouriteTheater;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.impl.AddressImpl;
import com.uscs.movies.MovieService.entity.impl.FavouriteMovieImpl;
import com.uscs.movies.MovieService.entity.impl.FavouriteTheaterImpl;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.TheaterImpl;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.repository.FavouriteMovieRepository;
import com.uscs.movies.MovieService.repository.FavouriteTheaterRepository;
import com.uscs.movies.MovieService.repository.MovieRepository;
import com.uscs.movies.MovieService.repository.TheaterRepository;
import com.uscs.movies.MovieService.repository.UserRepository;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class TestFavouriteRepository extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private FavouriteMovieRepository favMovieRepository;

	@Autowired
	private FavouriteTheaterRepository favTheaterRepository;

	@Autowired
	MovieRepository movieRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	TheaterRepository theaterRepo;

	@Test
	@Rollback(false)
	public void addAndGetFavourite() {
		// add user
		UserImpl user = new UserImpl();
		user.setFirstName("sharvil ");
		user.setLastName("mehta");
		user.setEmail("shavu@shah.gmail.com");
		user.setPassword("shavu890");
		userRepo.addUser(user);

		// add theater
		TheaterImpl theater = new TheaterImpl();
		theater.setTheaterName("PVR ");
		// theater address
		AddressImpl address = new AddressImpl();
		address.setCity("sunnyvale");
		address.setState("california");
		address.setStreet("100 el camino real ");
		address.setZip(96000);
		theater.setAddress(address);
		theaterRepo.addTheater(theater);

		// add movie
		MovieImpl movie = new MovieImpl();
		movie.setMovieName("Anna");
		movie.setMovieType("action/adventure");
		movie.setMovieDesc(
				"Pali leaves his village with Ekum, a journalist he has fallen for. But on hearing the news of the cold blooded murder of his friend Bittu and alliance Angrez, he and Ekum come back to confront Dilbagh, a drug lord");
		movieRepo.addMovies(movie);

		movie.setMovieName("Dil chahta hai");
		movie.setMovieType("love and comedy");
		movie.setMovieDesc("Thriller and mysterious");
		movieRepo.addMovies(movie);

		// add favourite Movies
		FavouriteMovieImpl favmovie = new FavouriteMovieImpl();
		favmovie.setFavouriteMovie(user, movie);
		favMovieRepository.addFavouriteMovie(favmovie);

		// add favourite theaters
		FavouriteTheaterImpl favTheater = new FavouriteTheaterImpl();
		favTheater.setFavouriteTheater(user, theater);
		favTheaterRepository.addFavouriteTheater(favTheater);

		// list favourite movies of particular user
		List<FavouriteTheater> favTheatersByUser = favTheaterRepository.listFavouriteTheater(user);
		for (int i = 0; i < favTheatersByUser.size(); i++) {
			System.out.println(favTheatersByUser.get(i).getTheater());
		}

		// list favourite theaters of user

		List<FavouriteMovie> favMovieByUser = favMovieRepository.listFavouriteMovie(user);
		for (int i = 0; i < favMovieByUser.size(); i++) {
			System.out.println(favMovieByUser.get(i).getMovie());
		}
		
		// delete movie from favourite list
		favMovieRepository.deleteFavouriteMovie(movie);
		
		// delete theater from favourite list
		favTheaterRepository.deleteFavouriteTheater(theater);

	}

}
