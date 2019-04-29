package com.vtvpmc.DanasMikelionis.trainInfo.model.table;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Train {
	@Id
	@GeneratedValue
	private Long id;
	
	private int number;
	private Date creationDate;
	private String createdBy;
	private String city;
	
	@OneToOne(mappedBy="train")
	private WagonCargo wagonCargo;
	
	public Train() { }

	public Train(int number, Date creationDate, String createdBy, String city) {
		super();
		this.number = number;
		this.creationDate = creationDate;
		this.createdBy = createdBy;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getCity() {
		return city;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
