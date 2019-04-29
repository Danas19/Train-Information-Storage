package com.vtvpmc.DanasMikelionis.trainInfo.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtvpmc.DanasMikelionis.trainInfo.Service.TrainService;
import com.vtvpmc.DanasMikelionis.trainInfo.model.table.Train;

@RestController
@CrossOrigin
public class TrainInfoController {
	@Autowired
	private TrainService trainService;
	
	@GetMapping(path = "/trains")
	public ResponseEntity<Collection<Train>> getTrains() {
		return this.trainService.getTrains();
	}
}
