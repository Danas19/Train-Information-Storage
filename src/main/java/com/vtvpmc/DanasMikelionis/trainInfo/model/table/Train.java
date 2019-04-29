package com.vtvpmc.DanasMikelionis.trainInfo.model.table;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Train {
	@Id
	@GeneratedValue
	private Long id;
	
	private int number;
	private Date creationDate;
	private String createdBy;
	private String city;
	
	@OneToMany(mappedBy="train")
	private Set<WagonCargo> wagonsCargo;
	
	@OneToMany(mappedBy="train")
	private Set<WagonLocomotive> wagonsLocomotive;
	
	@OneToMany(mappedBy="train")
	private Set<WagonWithPeople> wagonsWithPeople;
	
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
	
	

	public Collection<WagonCargo> getWagonsCargo() {
		return wagonsCargo;
	}

	public Collection<WagonLocomotive> getWagonsLocomotive() {
		return wagonsLocomotive;
	}

	public Set<WagonWithPeople> getWagonsWithPeople() {
		return wagonsWithPeople;
	}

	public void setWagonsCargo(Set<WagonCargo> wagonsCargo) {
		this.wagonsCargo = wagonsCargo;
	}

	public void setWagonsLocomotive(Set<WagonLocomotive> wagonsLocomotive) {
		this.wagonsLocomotive = wagonsLocomotive;
	}

	public void setWagonsWithPeople(Set<WagonWithPeople> wagonsWithPeople) {
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
		BigDecimal totalPriceEuros = BigDecimal.ZERO;
		if (this.wagonsCargo != null && this.wagonsCargo.size() > 0) {
			this.wagonsCargo.stream().forEach(w -> totalPriceEuros.add(w.getPrice()));
		}
		
		if (this.wagonsLocomotive != null && this.wagonsLocomotive.size() > 0) {
			this.wagonsLocomotive.stream().forEach(w -> totalPriceEuros.add(w.getPrice()));
		}
		
		if (this.wagonsWithPeople!= null && this.wagonsWithPeople.size() > 0) {
			this.wagonsWithPeople.stream().forEach(w -> totalPriceEuros.add(w.getPrice()));
		}
		
		return totalPriceEuros;
	}
}
