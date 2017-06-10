package de.conet.swe.aws.library.rental.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.conet.swe.aws.library.rental.model.jpa.BookRental;

@Stateless
public class RentalService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public List<BookRental> getRentals() {
		return em.createNamedQuery("bookrental.all", BookRental.class).getResultList();
	}

	public void addRental(BookRental rental) {
		em.persist(rental);
	}

	public BookRental getRental(long rentalId) {
		return em.find(BookRental.class, rentalId);
	}
}
