package com.qa.parkingapi.models;

import org.junit.jupiter.api.Test;

public class CarModelUnitTest {
	
	private Car car; 
	
	
	@Test
	void createCar() {
		Car car = new Car(); 
		assertNull(car.getCarID()); 
		
	}
	

}
