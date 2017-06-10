package de.conet.swe.aws.library.library.rest.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import de.conet.swe.aws.library.library.model.jpa.Book;
import de.conet.swe.aws.library.library.service.LibraryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "/book")
@Path("/book")
@Produces("application/json")
public class BooksEndpoint {

	@Inject
	private LibraryService libraryService;

	@ApiOperation(value = "Get all books", response = Book.class, responseContainer = "List")
	@GET
	public List<Book> getBooks() {
		return libraryService.getBooks();
	}

	@ApiOperation("Add a book")
	@POST
	public Response addBook(@ApiParam(required = true) Book book) {
		this.libraryService.addBook(book);
		return Response.ok().build();
	}

	@ApiOperation("Load specific book")
	@GET
	@Path("/{bookId}")
	public Book getBookEndpoint(@PathParam("bookId") Long bookId) {
		return libraryService.getBook(bookId);
	}
}
