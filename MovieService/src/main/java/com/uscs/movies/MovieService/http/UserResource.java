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

import com.uscs.movies.MovieService.entity.User;
import com.uscs.movies.MovieService.entity.impl.UserImpl;
import com.uscs.movies.MovieService.http.entity.HttpUser;
import com.uscs.movies.MovieService.services.UserService;

@Path("/users")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class UserResource {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@POST
	@Path("/")
	public Response createUser(HttpUser newUser) throws Exception{
		User userToCreate = convert(newUser);
		User addedUser=userService.addUser(userToCreate);
		return Response.status(Status.CREATED).header("Location", "/users/"+userToCreate.getId()).entity(new HttpUser(addedUser)).build();
	}	

	@GET
	@Path("/{userId}")	
	public HttpUser getUserById(@PathParam("userId") int userId){
		logger.info("getting user by id:"+userId);
		User user = userService.getUser(userId);	
		return new HttpUser(user);
	}
//	
	@GET
	@Path("/")
	@Wrapped(element="users")
	public List<HttpUser> getUserSearch(@QueryParam("firstName") String firstName) {
		logger.info("user search firstName="+firstName);
		List<User> found = userService.searchByName(firstName);
		List<HttpUser> returnList = new ArrayList<>(found.size());
		for(User user:found){
			returnList.add(new HttpUser(user));
		}
		return returnList;
	}
	@DELETE
	@Path("/{userId}")	
	public void deleteUserById(@PathParam("userId") int userId){
		logger.info("getting user by id:"+userId);
		userService.deleteUser(userId);
	
	}
	
	@PUT
	@Path("/{userId}")	
	public void updateUserById(@PathParam("userId") int userId){
		logger.info("getting user by id:"+userId);
		userService.updateUser(userId);
		User user=userService.getUser(userId);
		System.out.println(user.getEmail());
		userService.updateUser(userId);
		
	}
	
	/**
	 * Not pushing this into business layer. Could be a util as well
	 * @param newUser
	 * @return
	 */
	private User convert(HttpUser httpUser) {
		UserImpl user = new UserImpl();
		user.setFirstName(httpUser.firstName);
		user.setLastName(httpUser.lastName);
		user.setEmail(httpUser.email);
		user.setPassword(httpUser.password);
		
		return user;
	}	
}

