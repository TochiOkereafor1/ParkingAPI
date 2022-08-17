package com.qa.parkingapi.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.parkingapi.models.Car;
import com.qa.parkingapi.service.CarService;

@WebMvcTest(CarController.class)

public class CarControllerUnitTest {
	
	@Autowired
	private CarController carController;
	
	
	@MockBean
	private CarService carService; 
	
	
	@Test
	public void readAllCarsTest(){
		Car car1 = new Car(1L, "Ford", "GT", "xyz123"); 
		Car car2 = new Car(2L, "VW", "Golf", "123xyz"); 
		Car car3 = new Car(3L, "BMW", "sport", "zzz123"); 
		
		
		List<Car> Cars_List = List.of(car1,car2,  car3);
		Mockito.when(this.carService.getAllCars()).thenReturn(Cars_List);
		ResponseEntity<List<Car>> result = this.carController.getCars();

		assertThat(result).isEqualTo(ResponseEntity.ok(Cars_List));
	}
	
	@Test
	public void creteCarTest() {
		Car car1 = new Car(1L, "Ford", "GT", "xyz123");
		Car carMethod = new Car(car1.getCarID(), car1.getCarMake(), car1.getCarModel(), car1.getCarRegNum());
		Mockito.when(this.carService.addCar(car1)).thenReturn(carMethod); 
		ResponseEntity<Car> result = this.carController.createCar(carMethod);
		assertThat(result).isEqualTo(new ResponseEntity<Car>(car1, HttpStatus.CREATED));;
	}
	
	
	
	public void updateCar() {
		Long CarID = 1L; 
		Car car1 = new Car(CarID,"Ford", "GT", "xyz123");
		Car carTest = new Car(CarID, car1.getCarMake(), car1.getCarModel(), car1.getCarRegNum()); 
		
		Mockito.when(this.carService.addCar(car1)).thenReturn(carTest); 
		ResponseEntity<Car> result = this.carController.updateCar(carTest,CarID);
		assertThat(result).isEqualTo(new ResponseEntity<Car>(car1, HttpStatus.OK));
	}
	
	@Test
	public void deleteCar() {
		Long CarID = 1L; 
		Mockito.when(this.carService.deleteCarById(CarID)).thenReturn(true); 
		ResponseEntity<Boolean> result = this.carController.deleteByCarID(CarID); 
		assertThat(result).isEqualTo(new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)); 
	}
	/*

	
	
	 */
	
	
	
	
	
	
	
	

}
