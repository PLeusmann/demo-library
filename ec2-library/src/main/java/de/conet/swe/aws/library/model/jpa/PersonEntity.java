package de.conet.swe.aws.ec2library.model.jpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Inheritance
@DiscriminatorColumn(name = "PERSON_TYPE")
@Table
@NamedQueries({ @NamedQuery(name = "person.all", query = "select p from PersonEntity p") })
public class PersonEntity {

	@Id
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
