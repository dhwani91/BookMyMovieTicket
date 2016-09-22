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
import com.uscs.movies.MovieService.exception.ErrorCode;
import com.uscs.movies.MovieService.exception.MovieServiceException;
import com.uscs.movies.MovieService.http.entity.HttpMovie;
import com.uscs.movies.MovieService.http.entity.HttpTheater;
import com.uscs.movies.MovieService.services.MovieService;

@Path("/movies")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MovieService movieService;

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("/")
	public Response createMovie(HttpMovie newMovie) throws Exception {
		Movie MovieToCreate = convert(newMovie);
		Movie addedMovie = movieService.addMovies(MovieToCreate);
		if (addedMovie.getMovieName() == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "MovieName is missiong");
		}
		if (addedMovie.getMovieType() == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "Movie type is missiong");
		}
		if (addedMovie.getMovieDesc() == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "Movie Description is missiong");
		}

		return Response.status(Status.CREATED).header("Location", "/movie/" + MovieToCreate.getMovieId())
				.entity(new HttpMovie(addedMovie)).build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{movieId}")
	public HttpMovie getMovieById(@PathParam("movieId") int movieId) throws MovieServiceException {
		logger.info("getting movie by id:" + movieId);
		Movie movie = movieService.getMovies(movieId);
		if (movie == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "Movie not found");
		}
		return new HttpMovie(movie);
	}

	@Produces({ MediaType.APPLICATION_JSON })
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

	@DELETE
	@Path("/{movieId}")
	public void deleteMovieById(@PathParam("movieId") int movieId) throws MovieServiceException {
		Movie movie = movieService.getMovies(movieId);
		logger.info("getting movie by id:" + movieId);
		if (movie == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "Movie is not Exist");
		}
		movieService.deleteMovie(movie);

	}

	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	@Path("/{movieId}")
	public void updateMovie(@PathParam("movieId") int movieId, HttpMovie httpMovie) {
		Movie movie = convert(httpMovie);
		movie.setMovieId(movieId);
		movieService.updateMovie(movie);

	}

	private Movie convert(HttpMovie httpMovie) {
		MovieImpl movie = new MovieImpl();
		movie.setMovieId(httpMovie.movieId);
		movie.setMovieName(httpMovie.movieName);
		movie.setMovieType(httpMovie.movieType);
		movie.setMovieDesc(httpMovie.movieDesc);
		return movie;
	}
}
