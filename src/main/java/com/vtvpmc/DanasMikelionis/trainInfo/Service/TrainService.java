package com.vtvpmc.DanasMikelionis.trainInfo.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vtvpmc.DanasMikelionis.trainInfo.CreateTrainCommand;
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
	
	public ResponseEntity<Train> addTrain(CreateTrainCommand createTrainCommand) {
		Train newTrain = new Train(createTrainCommand.getNumber(), createTrainCommand.getCreationDate(),
				createTrainCommand.getCreatedBy(), createTrainCommand.getCity());
		
		this.trainRepository.save(newTrain);
		
		return new ResponseEntity<Train>(newTrain, HttpStatus.CREATED);
	}
	
	public ResponseEntity<Train> modifyTrain(Long id, CreateTrainCommand createTrainCommand) throws NullPointerException {
		Train oldTrain = this.trainRepository.findById(id).orElse(null);
		oldTrain.setCity(createTrainCommand.getCity());
		oldTrain.setCreatedBy(createTrainCommand.getCreatedBy());
		oldTrain.setCreationDate(createTrainCommand.getCreationDate());
		oldTrain.setNumber(createTrainCommand.getNumber());
		
		this.trainRepository.save(oldTrain);
		
		return new ResponseEntity<Train>(oldTrain, HttpStatus.OK);
	}
	
	public ResponseEntity<Train> removeTrain(Long id) throws NullPointerException {
		Train trainBeforeRemoval = this.trainRepository.findById(id).orElse(null);
		this.trainRepository.deleteById(id);
		return new ResponseEntity<Train>(trainBeforeRemoval, HttpStatus.OK);
	}
}
