package de.conet.swe.aws.ec2library.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import de.conet.swe.aws.ec2library.model.jpa.UserEntity;
import de.conet.swe.aws.ec2library.model.rest.Books;
import de.conet.swe.aws.ec2library.model.rest.Users;
import de.conet.swe.aws.ec2library.service.LibraryService;

@Path("/user")
public class UserEndpoint {

	@Inject
	private LibraryService libraryService;

	@GET
	@Produces("application/json")
	public Response getUsers() {
		return Response.ok(new Users(libraryService.getUsers())).build();
	}

	@POST
	public Response addUser(UserEntity user) {
		this.libraryService.addUser(user);
		return Response.ok().build();
	}

	@GET
	@Path("/{userId}/books")
	public Response getRentedBooks(@PathParam("userId") String userId) {
		return Response.ok(new Books(libraryService.getUser(userId).getCurrentlyRentedBooks())).build();
	}
}
