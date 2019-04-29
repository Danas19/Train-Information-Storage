package com.vtvpmc.DanasMikelionis.trainInfo.model.table;

import java.math.BigDecimal;
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
	private WagonCargo wagonsCargo;
	
	@OneToOne(mappedBy="train")
	private WagonLocomotive wagonsLocomotive;
	
	@OneToOne(mappedBy="train")
	private WagonWithPeople wagonsWithPeople;
	
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
	
	

	public WagonCargo getWagonsCargo() {
		return wagonsCargo;
	}

	public WagonLocomotive getWagonsLocomotive() {
		return wagonsLocomotive;
	}

	public WagonWithPeople getWagonsWithPeople() {
		return wagonsWithPeople;
	}

	public void setWagonsCargo(WagonCargo wagonsCargo) {
		this.wagonsCargo = wagonsCargo;
	}

	public void setWagonsLocomotive(WagonLocomotive wagonsLocomotive) {
		this.wagonsLocomotive = wagonsLocomotive;
	}

	public void setWagonsWithPeople(WagonWithPeople wagonsWithPeople) {
		this.wagonsWithPeople = wagonsWithPeople;
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
	
	public BigDecimal getTotalPriceEuros() {
		return this.wagonsCargo.getTotalPrice().add(this.wagonsLocomotive.getTotalPrice()).add(this.wagonsWithPeople.getTotalPrice());
	}
}
