package de.conet.swe.aws.ec2library.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

import de.conet.swe.aws.ec2library.model.jpa.BookEntity;
import de.conet.swe.aws.ec2library.service.LibraryService;

public class BookEndpoint {

	@Inject
	private LibraryService libraryService;

	private long bookId;

	public BookEndpoint withBookId(long bookId) {
		this.bookId = bookId;
		return this;
	}

	@GET
	public Response getBook() {
		BookEntity book = libraryService.getBook(bookId);
		return Response.ok(book).build();
	}
}
