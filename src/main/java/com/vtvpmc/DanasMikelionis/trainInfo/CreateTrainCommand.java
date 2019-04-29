package com.vtvpmc.DanasMikelionis.trainInfo;

import java.sql.Date;

import javax.validation.constraints.NotNull;

public class CreateTrainCommand {
	@NotNull
	private int number;
	@NotNull
	private Date creationDate;
	@NotNull
	private String createdBy;
	@NotNull
	private String city;
	
	public CreateTrainCommand() { }

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
	
	
}
