package com.qa.parkingapi.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="cars")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long carID;
	
	@NotNull
	@Size(min=0, max=30)
	@Column(name="Car_Make")
	private String carMake; 
	
	@NotNull
	@Size(min=0, max=30)
	@Column(name ="Car_Model")
	private String carModel; 
	
	@NotNull
	@Column(name= "Car_Registration")
	private String carRegNum;
	
//	@NotNull
//	@Column(name= "Bay_Location")
//	private String location;
	
	
	//default constructor
	
	//@Autowired
	public Car() {
		super();
	}
	
	//@Autowired
	//For pushing into the DB ID wont be needed it is auto generated 
	public Car(String carMake, String carModel, String carRegNum) {
		super();		
		this.carMake = carMake;
		this.carModel = carModel;
		this.carRegNum = carRegNum;
	}
	
	//@Autowired
	//For pulling from the DB, this constructor will have the ID
	public Car(Long carID, String carMake, String carModel, String carRegNum) {
		super();
		this.carID = carID;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carRegNum = carRegNum;
	}

	public Long getCarID() {
		return carID;
	}

	public void setCarID(Long carID) {
		this.carID = carID;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarRegNum() {
		return carRegNum;
	}
	
	public void setCarRegNum(String carRegNum) {
		this.carRegNum = carRegNum; 
	}

	

	@Override
	public String toString() {
		return "Car [carID=" + carID + ", carMake=" + carMake + ", carModel=" + carModel + ", carRegNum=" + carRegNum+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carMake, carModel, carRegNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(carMake, other.carMake) && Objects.equals(carModel, other.carModel)
				&& Objects.equals(carRegNum, other.carRegNum);
	}

	

	
	
	
	
	
	
	
	
	
	
	
	

}
