package com.uscs.movies.MovieService.http;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uscs.movies.MovieService.entity.Rating;
import com.uscs.movies.MovieService.entity.Review;
import com.uscs.movies.MovieService.entity.impl.MovieImpl;
import com.uscs.movies.MovieService.entity.impl.RatingImpl;
import com.uscs.movies.MovieService.entity.impl.ReviewImpl;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.http.entity.HttpRating;
import com.uscs.movies.MovieService.http.entity.HttpReview;
import com.uscs.movies.MovieService.services.RatingsService;
import com.uscs.movies.MovieService.services.ReviewService;

@Path("/reviews")
@Component
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class ReviewResource {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ReviewService reviewService;

	@POST
	@Path("/")
	public Response createReview(HttpReview newReview) throws Exception {
		Review reviewToconvert = convert(newReview);
		Review addedReview = reviewService.addReview(reviewToconvert);
		return Response.status(Status.CREATED).header("Location", "/reviews/" + reviewToconvert.getReviewId())
				.entity(new HttpReview(addedReview)).build();
	}

	@GET
	@Path("/{reviewId}")
	public HttpReview getReviewById(@PathParam("reviewId") int reviewId) {
		logger.info("getting review by id:" + reviewId);
		Review review = reviewService.getReviewById(reviewId);
		return new HttpReview(review);
	}

	@DELETE
	@Path("/{reviewId}")
	public void deleteReviewById(@PathParam("reviewId") int reviewId) {
		logger.info("getting rating by id:" + reviewId);
		reviewService.deleteReview(reviewId);

	}

	@PUT
	@Path("/{reviewId}")
	public void updateReviewById(@PathParam("reviewId") int reviewId) {
		logger.info("getting review by id:" + reviewId);
		Review review = reviewService.getReviewById(reviewId);
		reviewService.updateReview(review);

	}

	private Review convert(HttpReview httpReview) {
		ReviewImpl review = new ReviewImpl();
		UserImpl user = new UserImpl();
		MovieImpl movie = new MovieImpl();
		movie.setMovieName(httpReview.movieName);
		movie.setMovieType(httpReview.movieType);
		movie.setMovieDesc(httpReview.movieDesc);
		user.setFirstName(httpReview.userName);
		review.setReview(movie, user, httpReview.reviews);

		return review;
	}
}
