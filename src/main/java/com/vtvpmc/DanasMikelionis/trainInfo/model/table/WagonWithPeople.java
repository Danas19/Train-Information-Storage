package com.vtvpmc.DanasMikelionis.trainInfo.model.table;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
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
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Train train;
	
	public WagonWithPeople() { }

	public WagonWithPeople(String creator, int quantityOfSameInTrain, BigDecimal price, double volumeM3,
			int classNumber) {
		super();
		this.creator = creator;
		this.quantityOfSameInTrain = quantityOfSameInTrain;
		this.price = price;
		this.volumeM3 = volumeM3;
		this.classNumber = classNumber;
	}

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

	public int getClassNumber() {
		return classNumber;
	}

	public Train getTrain() {
		return train;
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

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public void setTrain(Train train) {
		this.train = train;
	}
	
	
}
