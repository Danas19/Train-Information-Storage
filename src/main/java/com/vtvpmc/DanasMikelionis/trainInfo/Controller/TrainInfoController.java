package com.vtvpmc.DanasMikelionis.trainInfo.Controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vtvpmc.DanasMikelionis.trainInfo.CreateTrainCommand;
import com.vtvpmc.DanasMikelionis.trainInfo.Service.TrainService;
import com.vtvpmc.DanasMikelionis.trainInfo.model.table.Train;
import com.vtvpmc.DanasMikelionis.trainInfo.model.table.WagonCargo;

@RestController
@CrossOrigin
public class TrainInfoController {
	@Autowired
	private TrainService trainService;
	
	@GetMapping("/trains")
	public ResponseEntity<Collection<Train>> getTrains() {
		return this.trainService.getTrains();
	}
	
	@GetMapping("/trains/{id}")
	public ResponseEntity<Train> getTrain(@PathVariable Long id) {
		return this.trainService.getTrain(id);
	}
	
	@PostMapping("/trains")
	public ResponseEntity<Train> addTrain(@RequestBody @Valid CreateTrainCommand createTrainCommand) {
		return this.trainService.addTrain(createTrainCommand);
	}
	
	@PutMapping("/trains/{id}")
	public ResponseEntity<Train> modifyTrain(@PathVariable Long id, @RequestBody @Valid CreateTrainCommand createTrainCommand) {
		try {
			return this.trainService.modifyTrain(id, createTrainCommand);
		} catch (NullPointerException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/trains/{id}")
	public ResponseEntity<Train> removeTrain(@PathVariable Long id) {
		try {
			return this.trainService.removeTrain(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
//	@PostMapping("/trains/{id}/wagonsCargo")
//	public ResponseEntity<WagonCargo> addWagonCargo(@PathVariable Long id, @RequestBody String tikNeString) {
//		
//	}
}
