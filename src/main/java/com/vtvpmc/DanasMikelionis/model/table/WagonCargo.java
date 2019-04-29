package com.vtvpmc.DanasMikelionis.model.table;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class WagonCargo {
	@Id
	@GeneratedValue
	private Long id;
	
	private String creator;
	private int quantityOfSameInTrain;
	private BigDecimal price;
	private double volumeM3;
	private double maxLiftWeightInTons;
	
	public WagonCargo() { }

	public Long getId() {
		return id;
	}

	public BigDecimal getTotalPrice() {
		return this.price.multiply(new BigDecimal(quantityOfSameInTrain));
	}

	public String getCreator() {
		return creator;
	}

	public int getQuantityOfSameInTrain() {
		return quantityOfSameInTrain;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public double getVolumeM3() {
		return volumeM3;
	}

	public double getMaxLiftWeightInTons() {
		return maxLiftWeightInTons;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void setQuantityOfSameInTrain(int quantityOfSameInTrain) {
		this.quantityOfSameInTrain = quantityOfSameInTrain;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setVolumeM3(double volumeM3) {
		this.volumeM3 = volumeM3;
	}

	public void setMaxLiftWeightInTons(double maxLiftWeightInTons) {
		this.maxLiftWeightInTons = maxLiftWeightInTons;
	}
	
	
}
