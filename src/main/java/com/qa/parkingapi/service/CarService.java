package com.qa.parkingapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.qa.parkingapi.models.Car;
import com.qa.parkingapi.repo.CarRepo;

@Component
public class CarService {
	
	private Car car; 
	private CarRepo repo; 
	
	public CarService() {
		car = new Car(); 
	}
	
	
	
	//CRUD
	
	//Add a single car 
	public Car addCar(Car car) {
		return this.repo.save(car); 
	}
	
	//Add multiple cars 
	public List<Car> addManyCars(List<Car> cars) {
		return repo.saveAll(cars); 
	}
	
	
	//Read a single car 
	public Car readSingleCar (Long carID) {
		return this.repo.findById(carID).get(); 		
	}
	
	//Read multiple cars
	public List<Car> getAllCars(){
		return this.repo.findAll(); 
	}
	
	//Update a car 
	public Car updateCar(Car car, Long carID) {
		Optional<Car> recentCar = this.repo.findById(carID); 
		Car updateCar = car; 
		
		if(recentCar.get() instanceof Car) {
			Car previousCar = recentCar.get(); 
			
			previousCar.setCarMake(updateCar.getCarMake());
			previousCar.setCarModel(updateCar.getCarModel());
			previousCar.setCarRegNum(updateCar.getCarRegNum());
			
			return previousCar; 
		}
		
		return null; 
	}
	
	
	//Remove Car 
	public boolean deleteCarById(Long carID) {
		this.repo.deleteById(carID);
		boolean exists = this.repo.existsById(carID); 
		return !exists; 
	}
	

}
