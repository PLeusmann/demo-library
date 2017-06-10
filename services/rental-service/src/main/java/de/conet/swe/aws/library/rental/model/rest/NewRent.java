package de.conet.swe.aws.library.rental.model.rest;

import javax.validation.constraints.NotNull;

public class NewRent {

	@NotNull
	private long bookId;

	@NotNull
	private String user;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
