package de.conet.swe.aws.ec2library.service;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.conet.swe.aws.ec2library.model.jpa.BookEntity;
import de.conet.swe.aws.ec2library.model.jpa.PersonEntity;
import de.conet.swe.aws.ec2library.model.jpa.UserEntity;

@Stateless
public class LibraryService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public Collection<BookEntity> getBooks() {
		return em.createNamedQuery("book.all", BookEntity.class).getResultList();
	}

	public List<PersonEntity> getPersons() {
		return em.createNamedQuery("person.all", PersonEntity.class).getResultList();
	}

	public Collection<UserEntity> getUsers() {
		return em.createNamedQuery("user.all", UserEntity.class).getResultList();
	}

	public void addUser(UserEntity user) {
		em.persist(user);
	}

	public UserEntity getUser(String userId) {
		return em.find(UserEntity.class, userId);
	}

	public void addBook(BookEntity book) {
		em.persist(book);
	}

	public BookEntity getBook(long bookId) {
		return em.find(BookEntity.class, bookId);
	}
}
