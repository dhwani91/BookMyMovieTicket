package com.uscs.movies.MovieService.http;


import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Rating;
import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.Showtime;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.ShowtimeImpl;
import com.uscs.movies.MovieService.entity.impl.TheaterImpl;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.exception.ErrorCode;
import com.uscs.movies.MovieService.exception.MovieServiceException;
import com.uscs.movies.MovieService.http.entity.HttpRating;
import com.uscs.movies.MovieService.http.entity.HttpReview;
import com.uscs.movies.MovieService.http.entity.HttpShowtime;
import com.uscs.movies.MovieService.http.entity.HttpUser;
import com.uscs.movies.MovieService.services.MovieService;
import com.uscs.movies.MovieService.services.ShowtimeService;
import com.uscs.movies.MovieService.services.TheaterService;

@Path("/showtime")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ShowtimeResource {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	ShowtimeService showtimeService;
	@Autowired
	MovieService movieService;
	@Autowired
	TheaterService theaterService;

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("/")
	public Response createShowtime(HttpShowtime showtime) throws Exception {
		if (showtime.getMovieId() == 0) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "Movie is missiong");
		}
		if (showtime.getTheaterId() == 0) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "Theater is missiong");
		}
		if (showtime.getShowTime() == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "Showtiming is missing");
		}

		Movie movie=movieService.getMovies(showtime.getMovieId());
		
		Showtime showtimeToCreate = convert(showtime);
		Showtime addedShowtime = showtimeService.addShowTime(showtimeToCreate);

		return Response.status(Status.CREATED).header("Location", "/showtime/" + addedShowtime.getshowtimeId())
				.entity(new HttpShowtime(addedShowtime)).build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/")
	@Wrapped(element = "showtime")
	public Response listShowtime(@QueryParam("movieId") int movieId, @QueryParam("theaterId") int theaterId) {
		if (movieId != 0) {
			logger.info("ratings serach by Movie" + movieId);

			List<Showtime> found = showtimeService.getShowtimeByMovie(movieId);
			List<HttpShowtime> returnList = new ArrayList<>(found.size());
			for (Showtime re : found) {
				returnList.add(new HttpShowtime(re));
			}
			return Response.status(200).entity(returnList).type(MediaType.APPLICATION_JSON).build();
		} else if (theaterId != 0) {
			// continue with a normal flow
			logger.info("showtime search  by theater=" + theaterId);
			List<Showtime> found = showtimeService.getShowtimeByTheater(theaterId);
			List<HttpShowtime> returnList = new ArrayList<>(found.size());
			for (Showtime re : found) {
				returnList.add(new HttpShowtime(re));
			}
			return Response.status(200).entity(returnList).type(MediaType.APPLICATION_JSON).build();
		}
		throw new WebApplicationException(Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
				.entity("movie OR theatre parameters are mandatory").build());
	}
	



	private Showtime convert(HttpShowtime httpShowtime) {
		ShowtimeImpl showtime = new ShowtimeImpl();
		MovieImpl movie = new MovieImpl();
		TheaterImpl theater = new TheaterImpl();
		
		Theater theaters=theaterService.getTheater(httpShowtime.getTheaterId());
		Movie movies =movieService.getMovies(httpShowtime.getMovieId());
//		theater.setTheaterId(httpShowtime.getTheaterId());
		showtime.setShowtimeId(httpShowtime.getShowtimeId());
		showtime.setShowtiming(movies, theaters, httpShowtime.getShowTime());

		return showtime;
	}
}