package com.qa.parkingapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.parkingapi.models.Location;

@Repository
public interface LocationRepo extends JpaRepository <Location, Long> {
	

}
