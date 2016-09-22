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

import com.uscs.movies.MovieService.entity.Rating;
import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.Theater;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.RatingImpl;
import com.uscs.movies.MovieService.entity.impl.ReviewImpl;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.exception.ErrorCode;
import com.uscs.movies.MovieService.exception.MovieServiceException;
import com.uscs.movies.MovieService.http.entity.HttpRating;
import com.uscs.movies.MovieService.http.entity.HttpReview;
import com.uscs.movies.MovieService.http.entity.HttpTheater;
import com.uscs.movies.MovieService.services.RatingsService;
import com.uscs.movies.MovieService.services.ReviewService;

@Path("/reviews")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReviewResource {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ReviewService reviewService;

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("/")
	public Response createReview(HttpReview newReview) throws Exception {
		if (newReview.getMovieId() <= 0) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "MovieId is missiong");
		}
		if (newReview.getUserId() <= 0) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "UserId is missiong");
		}
		if (newReview.getReviews() == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "Review is missiong");
		}
		Review reviewToconvert = convert(newReview);
		Review addedReview = reviewService.addReview(reviewToconvert);
		return Response.status(Status.CREATED).header("Location", "/reviews/" + reviewToconvert.getReviewId())
				.entity(new HttpReview(addedReview)).build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{reviewId}")
	public HttpReview getReviewById(@PathParam("reviewId") int reviewId) throws MovieServiceException {

		logger.info("getting review by id:" + reviewId);
		Review review = reviewService.getReviewById(reviewId);
		if (review == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "Review not found");
		}
		return new HttpReview(review);
	}

	@DELETE
	@Path("/{reviewId}")
	public void deleteReviewById(@PathParam("reviewId") int reviewId) throws MovieServiceException {
		Review review = reviewService.getReviewById(reviewId);
		logger.info("getting rating by id:" + reviewId);
		if (review == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "Review is not Exist");
		}
		reviewService.deleteReview(review);

	}

	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	@Path("/{reviewId}")
	public void updateReviewById(@PathParam("reviewId") int reviewId, HttpReview httpReview)
			throws MovieServiceException {
		Review review = convert(httpReview);
		Review newReview = reviewService.getReviewById(reviewId);
		if (newReview == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "Review not found");
		}
		logger.info("getting review by id:" + reviewId);
		reviewService.updateReview(review);

	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/")
	@Wrapped(element = "reviews")
	public Response listReviewByUser(@QueryParam("userId") int userId, @QueryParam("movieId") int movieId)
			throws MovieServiceException {
		if (movieId != 0) {
			logger.info("review serach by Movie" + movieId);

			List<Review> found = reviewService.listReviewByMovie(movieId);
			List<HttpReview> returnList = new ArrayList<>(found.size());
			for (Review re : found) {
				returnList.add(new HttpReview(re));
			}
			return Response.status(200).entity(returnList).type(MediaType.APPLICATION_JSON).build();
		} else if (userId != 0) {
			// continue with a normal flow
			logger.info("Review search  by user=" + userId);
			List<Review> found = reviewService.listReviewByUser(userId);
			List<HttpReview> returnList = new ArrayList<>(found.size());
			for (Review re : found) {
				returnList.add(new HttpReview(re));
			}
			return Response.status(200).entity(returnList).type(MediaType.APPLICATION_JSON).build();
		} else if (userId == 0) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "UserId not found");
		} else if (movieId == 0) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "MovieId not found");
		}

		throw new WebApplicationException(Response.status(HttpURLConnection.HTTP_BAD_REQUEST)
				.entity("MovieName OR userId parameters are mandatory").build());
	}

	private Review convert(HttpReview httpReview) {
		ReviewImpl review = new ReviewImpl();
		UserImpl user = new UserImpl();
		MovieImpl movie = new MovieImpl();
		review.setReviewId(httpReview.reviewId);
		user.setId(httpReview.userId);
		movie.setMovieId(httpReview.movieId);
		review.setReview(movie, user, httpReview.reviews);

		return review;
	}
}
