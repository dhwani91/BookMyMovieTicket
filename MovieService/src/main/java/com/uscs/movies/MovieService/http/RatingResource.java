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
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.AddressImpl;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.RatingImpl;
import com.uscs.movies.MovieService.entity.impl.TheaterImpl;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.exception.ErrorCode;
import com.uscs.movies.MovieService.exception.MovieServiceException;
import com.uscs.movies.MovieService.http.entity.HttpRating;
import com.uscs.movies.MovieService.http.entity.HttpReview;
import com.uscs.movies.MovieService.http.entity.HttpTheater;
import com.uscs.movies.MovieService.services.MovieService;
import com.uscs.movies.MovieService.services.RatingsService;
import com.uscs.movies.MovieService.services.TheaterService;
import com.uscs.movies.MovieService.services.UserService;
import com.uscs.movies.MovieService.services.impl.RatingServiceImpl;

@Path("/ratings")
@Component
@Consumes(MediaType.APPLICATION_JSON )
@Produces(MediaType.APPLICATION_JSON )
public class RatingResource {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RatingsService ratingService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private UserService userService;
	
	@Consumes(MediaType.APPLICATION_JSON )
	@POST
	@Path("/")
	public Response createRating(HttpRating newRating) throws Exception {
		Rating RatingToCreate = convert(newRating);
		Rating addedRating = ratingService.addRating(RatingToCreate);
		if(addedRating.getMovie().getMovieId()==0){
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "MovieId is missiong");
		}
		if(addedRating.getUser().getId()== 0){
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "UserId is missiong");
		}
		if(addedRating.getStar()==0){
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "Rating is missiong");
		}
		return Response.status(Status.CREATED).header("Location", "/ratings/" + RatingToCreate.getRatingId())
				.entity(new HttpRating(addedRating)).build();
	}

	@Produces(MediaType.APPLICATION_JSON )
	@GET
	@Path("/{ratingId}")
	public HttpRating getRatingById(@PathParam("ratingId") int ratingId) throws MovieServiceException {
		logger.info("getting rating by id:" + ratingId);
		Rating rating = ratingService.getRatingbyId(ratingId);
		if (rating == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "Rating not found");
		}
		return new HttpRating(rating);
	}

	@DELETE
	@Path("/{ratingId}")
	public void deleteRatingById(@PathParam("ratingId") int ratingId) throws MovieServiceException {
		Rating rating=ratingService.getRatingbyId(ratingId);
		if (rating == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "Rating is not Exist");
		}
		logger.info("getting rating by id:" + ratingId);
		ratingService.deleteRating(rating);
	}
	
	@Consumes(MediaType.APPLICATION_JSON )
	@PUT
	@Path("/{ratingId}")
	public void updateRatingById(@PathParam("ratingId") int ratingId,HttpRating httpRating) throws MovieServiceException {
		Rating rating=convert(httpRating);
		Rating newRating=ratingService.getRatingbyId(ratingId);
		logger.info("getting rating by id:" + ratingId);
		
		if (newRating == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "Rating not found");
		}
		ratingService.updateRating(rating);

	}

	@Produces(MediaType.APPLICATION_JSON )
	@GET
	@Path("/")
	@Wrapped(element = "ratings")
	public Response listRatingsByUser(@QueryParam("userId") int userId, @QueryParam("movieId") int movieId) throws MovieServiceException {
		if (movieId != 0) {
			logger.info("ratings serach by Movie" + movieId);

			List<Rating> found = ratingService.listRatingByMovie(movieId);
			List<HttpRating> returnList = new ArrayList<>(found.size());
			for (Rating re : found) {
				returnList.add(new HttpRating(re));
			}
			return Response.status(200).entity(returnList).type(MediaType.APPLICATION_JSON).build();
		} else if (userId != 0) {
			// continue with a normal flow
			logger.info("Review search  by user=" + userId);
			List<Rating> found = ratingService.listRatingByUser(userId);
			List<HttpRating> returnList = new ArrayList<>(found.size());
			for (Rating re : found) {
				returnList.add(new HttpRating(re));
			}
			return Response.status(200).entity(returnList).type(MediaType.APPLICATION_JSON).build();
		}
		else if (userId == 0) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "UserId not found");
		} else if (movieId == 0) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "MovieId not found");
		}
		throw new WebApplicationException(Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
				.entity("MovieName OR userId parameters are mandatory").build());
	}


	private Rating convert(HttpRating httpRating) {
		RatingImpl ratings = new RatingImpl();
		UserImpl user = new UserImpl();
		MovieImpl movie = new MovieImpl();
		user.setId(httpRating.userId);
		movie.setMovieId(httpRating.movieId);
		ratings.setRatingId(httpRating.ratingId);
		ratings.setRatings(movie, user, httpRating.rating);
		return ratings;
	}
}
