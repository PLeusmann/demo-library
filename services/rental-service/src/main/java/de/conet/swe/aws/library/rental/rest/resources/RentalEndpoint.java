package de.conet.swe.aws.library.rental.rest.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.conet.swe.aws.library.rental.model.jpa.BookRental;
import de.conet.swe.aws.library.rental.model.rest.NewRent;
import de.conet.swe.aws.library.rental.service.RentalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("rental")
@Path("rental")
@Produces("application/json")
public class RentalEndpoint {

	@Inject
	private RentalService rentalService;

	@ApiOperation(value = "Load all rentals", response = BookRental.class, responseContainer = "List")
	@GET
	public List<BookRental> getRentals() {
		return rentalService.getRentals();
	}

	@ApiOperation(value = "Add a new Rent")
	@POST
	public void addUser(@ApiParam(required = true) NewRent newRent) {
		this.rentalService.addRental(new BookRental(newRent));
	}

}
