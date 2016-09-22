package repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Showtime;
import com.uscs.movies.MovieService.entity.impl.AddressImpl;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.ShowtimeImpl;
import com.uscs.movies.MovieService.entity.impl.TheaterImpl;
import com.uscs.movies.MovieService.repository.MovieRepository;
import com.uscs.movies.MovieService.repository.ShowtimeRepository;
import com.uscs.movies.MovieService.repository.TheaterRepository;

@ContextConfiguration(locations = { "classpath:spring-context.xml" })

public class TestShowtimeRepository extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private ShowtimeRepository showtimeRepository;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private TheaterRepository theaterRepository ;

	@Test
	@Rollback(false)
	public void showtimeTest() {
		//add movie
		MovieImpl newMovie=new MovieImpl();
		newMovie.setMovieName("The wild life");
		newMovie.setMovieType("animation and adventure");
		newMovie.setMovieDesc("Stranded sailor Robinson Crusoe unites with a group of quirky animals to foil two conniving cats");
		movieRepository.addMovies(newMovie);
		
		// add theater
		TheaterImpl newTheater =new TheaterImpl();
		newTheater.setTheaterName("red carpet");
		
		//add theater address
		
		AddressImpl newAddress=new AddressImpl();
		newAddress.setStreet("100 snatera");
		newAddress.setCity("south san jose");
		newAddress.setState("california");
		newAddress.setZip(97878);
		
		newTheater.setAddress(newAddress);
		theaterRepository.addTheater(newTheater);
		
		
		// add showtime
		ShowtimeImpl newShowtime =new ShowtimeImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "16-09-2016 10:00:00";
		Date date;
		try {
			date = sdf.parse(dateInString);
			System.out.println(date);
			newShowtime.setShowtiming(newMovie,newTheater,date);
			showtimeRepository.addShowtime(newShowtime);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//get Theaters and showtime 
		
		Movie movie=movieRepository.getMovie(newMovie.getMovieId());
		List<Showtime> showtimeByMovie = showtimeRepository.getShowtimeByMovie(movie);
		System.out.println("Movie Name:"+movie.getMovieName());
		for (int i = 0; i < showtimeByMovie.size(); i++) {
			
			System.out.println(showtimeByMovie.get(i).getTheater().getTheaterName());
			System.out.println(showtimeByMovie.get(i).getShowtiming());

		}

	}

}
