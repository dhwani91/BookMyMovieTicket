package com.uscs.movies.MovieService.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Provider
@Component
public class MovieServiceExceptionMapper implements ExceptionMapper<MovieServiceException> {

	@Override
	public Response toResponse(MovieServiceException ex) {
		return Response.status(Status.CONFLICT).entity(new HttpError(ex)).build();
	}
}
