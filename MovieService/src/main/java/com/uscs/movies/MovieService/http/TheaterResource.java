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
import com.uscs.movies.MovieService.entity.impl.AddressImpl;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.TheaterImpl;
import com.uscs.movies.MovieService.http.entity.HttpMovie;
import com.uscs.movies.MovieService.http.entity.HttpTheater;
import com.uscs.movies.MovieService.services.MovieService;
import com.uscs.movies.MovieService.services.TheaterService;

@Path("/theaters")
@Component
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class TheaterResource {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TheaterService theaterService;

	@POST
	@Path("/")
	public Response createMovie(HttpTheater newTheater) throws Exception {
		Theater TheaterToCreate = convert(newTheater);
		Theater addedTheater = theaterService.addTheater(TheaterToCreate);
		return Response.status(Status.CREATED).header("Location", "/theater/" + TheaterToCreate.getTheaterId())
				.entity(new HttpTheater(addedTheater)).build();
	}

	@GET
	@Path("/{theaterId}")
	public HttpTheater getTheaterById(@PathParam("theaterId") int theaterId) {
		logger.info("getting theater by id:" + theaterId);
		Theater theater = theaterService.getTheater(theaterId);
		return new HttpTheater(theater);
	}

	@GET
	@Path("/")
	@Wrapped(element = "theaters")
	public List<HttpTheater> listTheaterByZipcode(@QueryParam("zipcode") int zipcode) {
		logger.info("theater search zipcode=" + zipcode);
		List<Theater> found = theaterService.getTheaterByZipcode(zipcode);
		List<HttpTheater> returnList = new ArrayList<>(found.size());
		for (Theater th : found) {
			returnList.add(new HttpTheater(th));
		}
		return returnList;
	}
	
	@GET
	@Path("/")
	@Wrapped(element = "theaters")
	public List<HttpTheater> listTheaterByCity(@QueryParam("city") String city) {
		logger.info("theater search city=" + city);
		List<Theater> found = theaterService.getTheaterByCity(city);
		List<HttpTheater> returnList = new ArrayList<>(found.size());
		for (Theater th : found) {
			returnList.add(new HttpTheater(th));
		}
		return returnList;
	}

	@DELETE
	@Path("/{theaterId}")
	public void deletetheaterById(@PathParam("theaterId") int theaterId) {
		logger.info("getting theater by id:" + theaterId);

		theaterService.deleteTheater(theaterId);

	}

	@PUT
	@Path("/{theaterId}")
	public void updateTheaterById(@PathParam("theaterId") int theaterId) {
		logger.info("getting theater by id:" + theaterId);
		Theater theater = theaterService.getTheater(theaterId);
		System.out.println(theater.getTheaterName());
		theaterService.updateTheater(theater);

	}

	/**
	 * Not pushing this into business layer. Could be a util as well
	 * 
	 * @param newUser
	 * @return
	 */
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
