package de.conet.swe.aws.ec2library.model.rest;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import de.conet.swe.aws.ec2library.model.jpa.UserEntity;

public class Authors {

	@XmlElementWrapper(name = "author")
	@XmlElement(name = "authors")
	private Collection<UserEntity> authors;

	public Authors() {
	}

	public Authors(Collection<UserEntity> authors) {
		super();
		this.authors = authors;
	}

	public Collection<UserEntity> getAuthors() {
		return authors;
	}

	public void setAuthors(Collection<UserEntity> users) {
		this.authors = users;
	}

}
