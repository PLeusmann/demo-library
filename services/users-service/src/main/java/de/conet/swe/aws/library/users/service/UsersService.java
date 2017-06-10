package de.conet.swe.aws.library.users.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.conet.swe.aws.library.users.model.jpa.User;

@Stateless
public class UsersService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public List<User> getPersons() {
		return em.createNamedQuery("person.all", User.class).getResultList();
	}

	public List<User> getUsers() {
		return em.createNamedQuery("user.all", User.class).getResultList();
	}

	public void addUser(User user) {
		em.persist(user);
	}

	public User getUser(String userId) {
		return em.find(User.class, userId);
	}
}
