package com.qa.parkingapi.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.parkingapi.models.Car;
import com.qa.parkingapi.repo.CarRepo;

@SpringBootTest

public class CarServiceUnitTest {

	@Autowired
	private CarService service;

	@MockBean
	private CarRepo repo;

	@Test
	public void create_save_function() {
		Car saveCar = new Car("Ford", "GT", "xyz123");
		Car repoSave = new Car(1L, "Ford", "GT", "xyz123");
		Mockito.when(this.service.addCar(saveCar)).thenReturn(repoSave);
		assertEquals(repoSave, this.repo.save(saveCar));
		Mockito.verify(this.repo, Mockito.times(1)).save(saveCar); 
	}

	@Test
	public void updateCar() {
		Long testCarId = 1L;
		Car updateCar = new Car("Golf", "Polo", "123abc");
		Optional<Car> mockValid = Optional.ofNullable(new Car("Ford", "GT", "xyz123"));
		Car expectedOutput = new Car("Ford", "GT", "xyz123");

		Mockito.when(this.repo.findById(testCarId)).thenReturn(mockValid);
		Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);
		assertEquals(expectedOutput, this.service.updateCar(updateCar, testCarId));
		assertEquals(expectedOutput, updateCar);
		Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
		Mockito.verify(this.repo, Mockito.times(1)).findById(testCarId);

	}

//	@Test
//	public void deleteCar() {
//
//	}
}
