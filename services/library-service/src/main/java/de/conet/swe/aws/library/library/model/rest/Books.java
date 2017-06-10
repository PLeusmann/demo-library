package de.conet.swe.aws.library.library.model.rest;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import de.conet.swe.aws.library.library.model.jpa.Book;

@XmlRootElement
public class Books {

	@XmlElementWrapper(name = "book")
	@XmlElement(name = "books")
	private Collection<Book> books;

	public Books() {
	}

	public Books(Collection<Book> books) {
		super();
		this.books = books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

	public Collection<Book> getBooks() {
		return books;
	}
}
