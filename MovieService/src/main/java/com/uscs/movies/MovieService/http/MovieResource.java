package com.uscs.movies.MovieService.http;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uscs.movies.MovieService.entity.Movie;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.http.entity.HttpMovie;
import com.uscs.movies.MovieService.http.entity.HttpTheater;
import com.uscs.movies.MovieService.services.MovieService;

@Path("/movies")
@Component
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class MovieResource {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MovieService movieService;
	


	@POST
	@Path("/")
	public Response createMovie(HttpMovie newMovie) throws Exception {
		Movie MovieToCreate = convert(newMovie);
		Movie addedMovie = movieService.addMovies(MovieToCreate);
		return Response.status(Status.CREATED).header("Location", "/movie/" + MovieToCreate.getId())
				.entity(new HttpMovie(addedMovie)).build();
	}

	@GET
	@Path("/{movieId}")
	public HttpMovie getMovieById(@PathParam("movieId") int movieId) {
		logger.info("getting movie by id:" + movieId);
		Movie movie = movieService.getMovies(movieId);
		return new HttpMovie(movie);
	}
	@GET
	@Path("/")
	@Wrapped(element = "movies")
	public List<HttpMovie> listMoviesByTye(@QueryParam("movieType") String movieType) {
		logger.info("movie search movieType=" + movieType);
		List<Movie> found = movieService.listMovieByType(movieType);
		List<HttpMovie> returnList = new ArrayList<>(found.size());
		for (Movie th : found) {
			returnList.add(new HttpMovie(th));
		}
		return returnList;
	}

	//
	// @GET
	// @Path("/")
	// @Wrapped(element="users")
	// public List<HttpUser> getUserSearch(@QueryParam("firstName") String
	// firstName, @QueryParam("lastName") String lastName) throws TBTFException{
	// logger.info("user search firstName="+firstName+" lastName="+lastName);
	// List<User> found = userService.getUsers(firstName, lastName);
	// List<HttpUser> returnList = new ArrayList<>(found.size());
	// for(User user:found){
	// returnList.add(new HttpUser(user));
	// }
	// return returnList;
	// }
	@DELETE
	@Path("/{movieId}")
	public void deleteMovieById(@PathParam("movieId") int movieId) {
		logger.info("getting movie by id:" + movieId);
		movieService.deleteMovie(movieId);

	}

	@PUT
	@Path("/{movieId}")
	public void updateUserById(@PathParam("movieId") int movieId) {
		logger.info("getting movie by id:" + movieId);
		Movie movie = movieService.getMovies(movieId);
		System.out.println(movie.getMovieName());
		movieService.updateMovie(movie);

	}

	private Movie convert(HttpMovie httpMovie) {
		MovieImpl movie = new MovieImpl();
		movie.setMovieName(httpMovie.movieName);
		movie.setMovieType(httpMovie.movieType);
		movie.setMovieDesc(httpMovie.movieDesc);
		return movie;
	}
}
