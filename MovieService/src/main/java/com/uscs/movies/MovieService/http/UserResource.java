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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.exception.ErrorCode;
import com.uscs.movies.MovieService.exception.MovieServiceException;
import com.uscs.movies.MovieService.http.entity.HttpUser;
import com.uscs.movies.MovieService.services.UserService;

@Path("/users")
@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("/")
	public Response createUser(HttpUser newUser) throws Exception {
		if (newUser.getFirstName() == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "Firstname is missiong");
		}
		if (newUser.getLastName() == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "LastName is missiong");
		}
		if (newUser.getEmail() == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "Email is missing");
		}
		if (newUser.getPassword() == null) {
			throw new MovieServiceException(ErrorCode.INVALID_FIELD, "Password is missiong");
		}
		User userToCreate = convert(newUser);
		User addedUser = userService.addUser(userToCreate);
		return Response.status(Status.CREATED).header("Location", "/users/" + addedUser.getId())
				.entity(new HttpUser(addedUser)).build();
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/{userId}")
	public HttpUser getUserById(@PathParam("userId") int userId) throws MovieServiceException {
		logger.info("getting user by id:" + userId);
		User user = userService.getUser(userId);
		if (user == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "User not found");
		}
		return new HttpUser(user);
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/")
	@Wrapped(element = "users")
	public List<HttpUser> getUserSearch(@QueryParam("firstName") String firstName) {
		logger.info("user search firstName=" + firstName);
		List<User> found = userService.searchByName(firstName);
		List<HttpUser> returnList = new ArrayList<>(found.size());
		for (User user : found) {
			returnList.add(new HttpUser(user));
		}
		return returnList;
	}

	@DELETE
	@Path("/{userId}")
	public void deleteUserById(@PathParam("userId") int userId) throws MovieServiceException {
		User user = userService.getUser(userId);
		if (user == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "User is not Exist");
		}

		logger.info("getting user by id:" + userId);
		userService.deleteUser(userId);

	}

	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	@Path("/{userId}")
	public void updateUserById(@PathParam("userId") int userId, HttpUser httpUser) throws MovieServiceException {
		User newUser = userService.getUser(userId);
		if (newUser == null) {
			throw new MovieServiceException(ErrorCode.MISSING_DATA, "User not found");
		}
		User user = convert(httpUser);
		logger.info("getting user by id:" + userId);
		user.setId(userId);
		userService.updateUser(user);

	}

	private User convert(HttpUser httpUser) {
		UserImpl user = new UserImpl();
		user.setFirstName(httpUser.firstName);
		user.setLastName(httpUser.lastName);
		user.setEmail(httpUser.email);
		user.setPassword(httpUser.password);
		return user;
	}
}
