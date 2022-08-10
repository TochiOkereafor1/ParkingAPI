package com.qa.parkingapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.parkingapi.models.Car;
import com.qa.parkingapi.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService service;

	@Autowired
	public CarController(CarService service) {
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Car> createCar(@RequestBody Car car) {
		Car createCar = service.addCar(car);
		return new ResponseEntity<Car>(createCar, HttpStatus.CREATED);
	}

	@GetMapping("/getCars")
	public ResponseEntity<List<Car>> getCars() {

		List<Car> carData = service.getAllCars();

		return new ResponseEntity<List<Car>>(carData, HttpStatus.OK);
	}

	@GetMapping("/get/{carID}")
	public ResponseEntity<Car> getCarID(@PathVariable Long carID) {
		Car carInfo = service.readSingleCar(carID);
		return new ResponseEntity<Car>(carInfo, HttpStatus.OK);

	}

	@PutMapping("/updateCar/{carID}")
	public ResponseEntity<Car> updateCar(@RequestBody Car car, @PathVariable Long carID) {
		Car updateCar = service.updateCar(car, carID);

		return new ResponseEntity<Car>(updateCar, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteCar/{carID}")
	public ResponseEntity<Boolean> deleteByCarID(@PathVariable Long carID) {
		boolean deleteCar = service.deleteCarById(carID);
		return new ResponseEntity<Boolean>(deleteCar, HttpStatus.NO_CONTENT);

	}
	
	@PutMapping("/updateLocation/{carID}")
	public ResponseEntity<Car> updateLocation(@RequestBody Car car, @PathVariable Long carID) {
		Car updateCar = service.updateCar(car, carID);

		return new ResponseEntity<Car>(updateCar, HttpStatus.ACCEPTED);
	}

}
