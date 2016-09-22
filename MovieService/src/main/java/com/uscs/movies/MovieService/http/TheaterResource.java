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
import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.impl.AddressImpl;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.TheaterImpl;
import com.uscs.movies.MovieService.exception.ErrorCode;
import com.uscs.movies.MovieService.exception.MovieServiceException;
import com.uscs.movies.MovieService.http.entity.HttpMovie;
import com.uscs.movies.MovieService.http.entity.HttpReview;
import com.uscs.movies.MovieService.http.entity.HttpTheater;
import com.uscs.movies.MovieService.services.MovieService;
import com.uscs.movies.MovieService.services.TheaterService;

@Path("/theaters")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TheaterResource {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TheaterService theaterService;

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("/")
	public Response createMovie(HttpTheater newTheater) throws Exception {
		Theater TheaterToCreate = convert(newTheater);
		Theater addedTheater = theaterService.addTheater(TheaterToCreate);
		if (addedTheater.getTheaterName() == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "TheaterName is missiong");
		}
		if (addedTheater.getAddress().getCity() == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "city is missiong");
		}
		if (addedTheater.getAddress().getState() == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "state is missiong");
		}
		if (addedTheater.getAddress().getZip() == 0) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "zipcode is missiong");
		}
		return Response.status(Status.CREATED).header("Location", "/theaters/" + TheaterToCreate.getTheaterId())
				.entity(new HttpTheater(addedTheater)).build();
	}

	@GET
	@Path("/{theaterId}")
	public HttpTheater getTheaterById(@PathParam("theaterId") int theaterId) throws MovieServiceException {
		logger.info("getting theater by id:" + theaterId);
		Theater theater = theaterService.getTheater(theaterId);
		if (theater == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "Theater not found");
		}
		return new HttpTheater(theater);
	}

	@GET
	@Path("/")
	@Wrapped(element = "theaters")
	public Response listTheaterByCity(@QueryParam("city") String city, @QueryParam("zipcode") int zipcode)
			throws MovieServiceException {
		if (city != null) {
			logger.info("Theater serach by city" + city);

			List<Theater> found = theaterService.getTheaterByCity(city);
			List<HttpTheater> returnList = new ArrayList<>(found.size());
			for (Theater re : found) {
				returnList.add(new HttpTheater(re));
			}
			return Response.status(200).entity(returnList).type(MediaType.APPLICATION_JSON).build();
		} else if (zipcode != 0) {
			// continue with a normal flow
			logger.info("Theater search  by zipcode=" + zipcode);
			List<Theater> found = theaterService.getTheaterByZipcode(zipcode);
			List<HttpTheater> returnList = new ArrayList<>(found.size());
			for (Theater re : found) {
				returnList.add(new HttpTheater(re));
			}
			return Response.status(200).entity(returnList).type(MediaType.APPLICATION_JSON).build();
		}

		else if (city == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "city not found");
		} else if (zipcode == 0) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "zipcode not found");
		}

		throw new WebApplicationException(Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
				.entity("city OR zipcode parameters are mandatory").build());
	}

	@DELETE
	@Path("/{theaterId}")
	public void deletetheaterById(@PathParam("theaterId") int theaterId) throws MovieServiceException {
		Theater theater = theaterService.getTheater(theaterId);
		logger.info("getting theater by id:" + theaterId);
		if (theater == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "Theater is not Exist");
		}
		theaterService.deleteTheater(theater);

	}

	@PUT
	@Path("/{theaterId}")
	public void updateTheaterById(@PathParam("theaterId") int theaterId, HttpTheater httpTheater)
			throws MovieServiceException {
		logger.info("getting theater by id:" + theaterId);
		Theater theater = convert(httpTheater);
		if (theater == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "Theater not found");
		}
		System.out.println(theater.getTheaterName());
		theater.setTheaterId(theaterId);
		theaterService.updateTheater(theater);

	}

	private Theater convert(HttpTheater httpTheater) {
		TheaterImpl theater = new TheaterImpl();
		AddressImpl add = new AddressImpl();
		add.setStreet(httpTheater.street);
		add.setCity(httpTheater.city);
		add.setState(httpTheater.state);
		add.setZip(httpTheater.zipcode);
		theater.setTheaterName(httpTheater.theaterName);
		theater.setAddress(add);
		return theater;
	}
}
