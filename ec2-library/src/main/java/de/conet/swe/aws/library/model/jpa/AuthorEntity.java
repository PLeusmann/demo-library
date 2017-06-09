package de.conet.swe.aws.ec2library.model.jpa;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@DiscriminatorValue("AUTH")
@NamedQueries({ @NamedQuery(name = "author.all", query = "select a from AuthorEntity a") })
@XmlRootElement
public class AuthorEntity extends PersonEntity {

	@OneToMany
	@XmlElementWrapper(name = "book")
	@XmlElement(name = "written-books")
	private Collection<BookEntity> writtenBooks;

	public Collection<BookEntity> getWrittenBooks() {
		return writtenBooks;
	}

	public void setWrittenBooks(Collection<BookEntity> writtenBooks) {
		this.writtenBooks = writtenBooks;
	}

}
