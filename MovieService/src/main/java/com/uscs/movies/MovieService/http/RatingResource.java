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

import com.uscs.movies.MovieService.entity.Rating;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.impl.AddressImpl;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.RatingImpl;
import com.uscs.movies.MovieService.entity.impl.TheaterImpl;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.http.entity.HttpRating;
import com.uscs.movies.MovieService.http.entity.HttpTheater;
import com.uscs.movies.MovieService.services.RatingsService;
import com.uscs.movies.MovieService.services.TheaterService;
import com.uscs.movies.MovieService.services.impl.RatingServiceImpl;

@Path("/ratings")
@Component
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class RatingResource {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RatingsService ratingService;

	@POST
	@Path("/")
	public Response createRating(HttpRating newRating) throws Exception {
		Rating RatingToCreate = convert(newRating);
		Rating addedRating = ratingService.addRating(RatingToCreate);
		return Response.status(Status.CREATED).header("Location", "/ratings/" + RatingToCreate.getRatingId())
				.entity(new HttpRating(addedRating)).build();
	}

	@GET
	@Path("/{ratingId}")
	public HttpRating getRatingById(@PathParam("ratingId") int ratingId) {
		logger.info("getting rating by id:" + ratingId);
		Rating rating=ratingService.getRatings(ratingId);
		return new HttpRating(rating);
	}

	
//	@GET
//	@Path("/")
//	@Wrapped(element = "theaters")
//	public List<HttpTheater> listTheaterByCity(@QueryParam("city") String city) {
//		logger.info("theater search city=" + city);
//		List<Theater> found = theaterService.getTheaterByCity(city);
//		List<HttpTheater> returnList = new ArrayList<>(found.size());
//		for (Theater th : found) {
//			returnList.add(new HttpTheater(th));
//		}
//		return returnList;
//	}

	@DELETE
	@Path("/{ratingId}")
	public void deleteRatingById(@PathParam("ratingId") int ratingId) {
		logger.info("getting rating by id:" + ratingId);
		ratingService.deleteRating(ratingId);
		

	}

	@PUT
	@Path("/{ratingId}")
	public void updateratingById(@PathParam("ratingId") int ratingId) {
		logger.info("getting rating by id:" + ratingId);
		Rating rating = ratingService.getRatings(ratingId);
		ratingService.updateRating(rating);
		

	}

	/**
	 * Not pushing this into business layer. Could be a util as well
	 * 
	 * @param newUser
	 * @return
	 */
	private Rating convert(HttpRating httpRating) {
		RatingImpl ratings = new RatingImpl();
		UserImpl user = new UserImpl();
		MovieImpl movie=new MovieImpl();
		movie.setMovieName(httpRating.movieName);
		movie.setMovieType(httpRating.movieType);
		movie.setMovieDesc(httpRating.movieDesc);
		user.setFirstName(httpRating.userName);
		ratings.setRatingId(httpRating.ratingId);
		ratings.setRatings(movie, user, httpRating.ratings);
		return ratings;
	}
}
