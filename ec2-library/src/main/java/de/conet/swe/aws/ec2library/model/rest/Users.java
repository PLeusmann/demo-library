package de.conet.swe.aws.ec2library.model.rest;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import de.conet.swe.aws.ec2library.model.jpa.UserEntity;

public class Users {

	@XmlElementWrapper(name = "user")
	@XmlElement(name = "users")
	private Collection<UserEntity> users;

	public Users() {
	}

	public Users(Collection<UserEntity> users) {
		super();
		this.users = users;
	}

	public Collection<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserEntity> users) {
		this.users = users;
	}

}
