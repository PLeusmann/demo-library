package de.conet.swe.aws.library.users.model.rest;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import de.conet.swe.aws.library.users.model.jpa.User;

public class Users {

	@XmlElementWrapper(name = "user")
	@XmlElement(name = "users")
	private Collection<User> users;

	public Users() {
	}

	public Users(Collection<User> users) {
		super();
		this.users = users;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

}
