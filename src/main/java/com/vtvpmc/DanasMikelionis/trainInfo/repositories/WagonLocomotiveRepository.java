package com.vtvpmc.DanasMikelionis.trainInfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtvpmc.DanasMikelionis.trainInfo.model.table.WagonLocomotive;

public interface WagonLocomotiveRepository
		extends JpaRepository<WagonLocomotive, Long> {

}
