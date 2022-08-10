package com.qa.parkingapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.parkingapi.models.Car;

@Repository
public interface CarRepo extends JpaRepository <Car, Long>  {

}
