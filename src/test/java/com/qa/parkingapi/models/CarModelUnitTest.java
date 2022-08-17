package com.qa.parkingapi.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;

public class CarModelUnitTest {
	
	private static Car testCar; 
	
	
	@Test
	void createCar() {
		testCar = new Car(); 
		assertThat(testCar).isNotNull().isInstanceOf(Car.class); 	
	}
	
	@Test
	public void emptyCarConstructorTest() {
		testCar = new Car();
		assertThat(testCar).isNotNull(); 
		
		
	}
	
	@Test 
	public void CarConstructorNoIdTest() {
		testCar = new Car("BMW", "M5", "ZFX6PX");
		assertThat(testCar).isNotNull().isInstanceOf(Car.class); 
	}
	
	@Test 
	public void CarConstructorIdTest() {
		testCar = new Car(1L ,"BMW", "M5", "ZFX6PX");
		assertThat(testCar).isNotNull().isInstanceOf(Car.class); 
		assertThat(testCar.getCarID()).isEqualTo(1L); 
		assertThat(testCar.getCarMake()).isEqualTo("BMW"); 
		assertThat(testCar.getCarModel()).isEqualTo("M5");  
		assertThat(testCar.getCarRegNum()).isEqualTo("ZFX6PX");  
	}
	
	/*
	@Test
	public void CarSetterTest() {
		testCar.setCarID(null);
		testCar.setCarMake(null);
	}
	*/
	
	
	@Test
	public void toStringTest() {
		testCar = new Car(1L ,"Range Rover", "Sport", "HXv8PQ");
		String expecting =  "Car [carID=" + testCar.getCarID() + ", carMake=" + testCar.getCarMake() + ", carModel=" + testCar.getCarModel() + ", carRegNum=" + testCar.getCarRegNum()+ "]";
		assertEquals(expecting, testCar.toString()); 
	
	}
	

	

}
