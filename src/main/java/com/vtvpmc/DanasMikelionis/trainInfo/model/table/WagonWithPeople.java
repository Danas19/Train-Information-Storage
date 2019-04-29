package com.vtvpmc.DanasMikelionis.trainInfo.model.table;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class WagonWithPeople {
	@Id
	@GeneratedValue
	private Long id;
	
	private String creator;
	private int quantityOfSameInTrain;
	private BigDecimal price;
	private double volumeM3;
	private int classNumber;
	
	public WagonWithPeople() { }

	public Long getId() {
		return id;
	}
	
	public BigDecimal getTotalPrice() {
		return this.price.multiply(new BigDecimal(quantityOfSameInTrain));
	}
}
