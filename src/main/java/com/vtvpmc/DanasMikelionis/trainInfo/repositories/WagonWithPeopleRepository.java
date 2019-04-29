package com.vtvpmc.DanasMikelionis.trainInfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtvpmc.DanasMikelionis.trainInfo.model.table.WagonWithPeople;

public interface WagonWithPeopleRepository
		extends JpaRepository<WagonWithPeople, Long> {

}
