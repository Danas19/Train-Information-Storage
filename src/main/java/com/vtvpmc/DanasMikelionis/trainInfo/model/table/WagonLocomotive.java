package com.vtvpmc.DanasMikelionis.trainInfo.model.table;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.vtvpmc.DanasMikelionis.trainInfo.model.LocomotiveType;

@Entity
public class WagonLocomotive {
	@Id
	@GeneratedValue
	private Long id;
	
	private String creator;
	private int quantityOfSameInTrain;
	private BigDecimal price;
	private double volumeM3;
	private LocomotiveType locomotiveType;
	
	public WagonLocomotive() { }
	
	

	public WagonLocomotive(String creator, int quantityOfSameInTrain, BigDecimal price, double volumeM3,
			LocomotiveType locomotiveType) {
		super();
		this.creator = creator;
		this.quantityOfSameInTrain = quantityOfSameInTrain;
		this.price = price;
		this.volumeM3 = volumeM3;
		this.locomotiveType = locomotiveType;
	}



	public Long getId() {
		return id;
	}
	
	public BigDecimal getTotalPrice() {
		return this.price.multiply(new BigDecimal(quantityOfSameInTrain));
	}
}
