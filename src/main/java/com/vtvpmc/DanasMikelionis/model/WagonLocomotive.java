package com.vtvpmc.DanasMikelionis.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class WagonLocomotive {
	@Id
	@GeneratedValue
	private Long id;
	
	private String creator;
	private int quantityOfSameInTrain;
	private BigDecimal price;
	private double volumeM3;
	
	public WagonLocomotive() { }

	public Long getId() {
		return id;
	}
	
	public BigDecimal getTotalPrice() {
		return this.price.multiply(new BigDecimal(quantityOfSameInTrain));
	}
}
