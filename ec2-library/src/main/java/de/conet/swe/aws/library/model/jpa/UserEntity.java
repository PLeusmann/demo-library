package de.conet.swe.aws.ec2library.model.jpa;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@DiscriminatorValue("USER")
@NamedQueries({ @NamedQuery(name = "user.all", query = "select u from UserEntity u") })
@XmlRootElement
public class UserEntity extends PersonEntity {

	@XmlElementWrapper(name = "book")
	@XmlElement(name = "rented-books")
	@OneToMany(fetch = FetchType.EAGER)
	private Collection<BookEntity> currentlyRentedBooks;

	public Collection<BookEntity> getCurrentlyRentedBooks() {
		return currentlyRentedBooks;
	}

	public void setCurrentlyRentedBooks(Collection<BookEntity> currentlyRentedBooks) {
		this.currentlyRentedBooks = currentlyRentedBooks;
	}
}
