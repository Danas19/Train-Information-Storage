package com.vtvpmc.DanasMikelionis.trainInfo.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vtvpmc.DanasMikelionis.trainInfo.model.table.Train;
import com.vtvpmc.DanasMikelionis.trainInfo.repositories.TrainRepository;

@Service
public class TrainService {
	private TrainRepository trainRepository;
	
	@Autowired
	public TrainService(TrainRepository trainRepository) {
		this.trainRepository = trainRepository;
	}
	
	public ResponseEntity<Collection<Train>> getTrains() {
		return new ResponseEntity<Collection<Train>>(this.trainRepository.findAll(), HttpStatus.OK);
	}
}
