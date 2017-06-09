package de.conet.swe.aws.ec2library.model.rest;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import de.conet.swe.aws.ec2library.model.jpa.BookEntity;

@XmlRootElement
public class Books {

	@XmlElementWrapper(name = "book")
	@XmlElement(name = "books")
	private Collection<BookEntity> books;

	public Books() {
	}

	public Books(Collection<BookEntity> books) {
		super();
		this.books = books;
	}

	public void setBooks(Collection<BookEntity> books) {
		this.books = books;
	}

	public Collection<BookEntity> getBooks() {
		return books;
	}
}
