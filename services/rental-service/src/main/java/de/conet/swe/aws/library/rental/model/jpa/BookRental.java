package de.conet.swe.aws.library.rental.model.jpa;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import de.conet.swe.aws.library.rental.model.rest.NewRent;

@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "bookrental.all", query = "select r from BookRental r") })
public class BookRental {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private LocalDateTime rentalDate;

	@NotNull
	private long bookId;

	@NotNull
	private String user;

	protected BookRental() {
	}

	public BookRental(LocalDateTime rentalDate, long bookId, String user) {
		super();
		this.rentalDate = rentalDate;
		this.bookId = bookId;
		this.user = user;
	}

	public BookRental(NewRent newRent) {
		super();
		this.rentalDate = LocalDateTime.now();
		this.bookId = newRent.getBookId();
		this.user = newRent.getUser();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalDateTime rentalDate) {
		this.rentalDate = rentalDate;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
