package de.conet.swe.aws.ec2library.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import de.conet.swe.aws.ec2library.model.jpa.BookEntity;
import de.conet.swe.aws.ec2library.model.rest.Books;
import de.conet.swe.aws.ec2library.service.LibraryService;

@Path("/book")
public class BooksEndpoint {

	@Inject
	private LibraryService libraryService;

	@Inject
	private BookEndpoint bookEndpoint;

	@GET
	@Produces("application/json")
	public Response getBooks() {
		return Response.ok(new Books(libraryService.getBooks())).build();
	}

	@POST
	public Response addBook(BookEntity book) {
		this.libraryService.addBook(book);
		return Response.ok().build();
	}

	@GET
	@Path("/{bookId}")
	@Produces("application/json")
	public BookEndpoint getBookEndpoint(@PathParam("bookId") Long bookId) {
		return bookEndpoint.withBookId(bookId);
	}
}
