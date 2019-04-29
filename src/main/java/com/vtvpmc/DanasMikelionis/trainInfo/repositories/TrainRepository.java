package com.vtvpmc.DanasMikelionis.trainInfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtvpmc.DanasMikelionis.trainInfo.model.table.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {
	
}
