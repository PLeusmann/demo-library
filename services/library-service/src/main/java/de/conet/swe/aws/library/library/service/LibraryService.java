package de.conet.swe.aws.library.library.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.conet.swe.aws.library.library.model.jpa.Book;

@Stateless
public class LibraryService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public List<Book> getBooks() {
		return em.createNamedQuery("book.all", Book.class).getResultList();
	}

	public void addBook(Book book) {
		em.persist(book);
	}

	public Book getBook(long bookId) {
		return em.find(Book.class, bookId);
	}
}
