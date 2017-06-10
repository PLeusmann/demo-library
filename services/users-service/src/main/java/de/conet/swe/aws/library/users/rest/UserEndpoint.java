package de.conet.swe.aws.library.users.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import de.conet.swe.aws.library.users.model.jpa.User;
import de.conet.swe.aws.library.users.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@Path("user")
public class UserEndpoint {

	@Inject
	private UsersService libraryService;

	@ApiOperation(value = "Laod all users", response = User.class, responseContainer = "List")
	@GET
	public List<User> getUsers() {
		return libraryService.getUsers();
	}

	@ApiOperation(value = "Add a new user")
	@POST
	public void addUser(@ApiParam(required = true) User user) {
		this.libraryService.addUser(user);
	}

}
