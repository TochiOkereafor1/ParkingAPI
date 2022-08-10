package com.qa.parkingapi.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Location {
	
	@Id
	private Long id; 
	private String bayName; 
	private boolean occupied; 
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private Car cars;  
	
	public Location() {
		
	}
	
	public Location(String bayName) {
		this.bayName = bayName; 
	}
	
	public Location(String bayName, boolean occupied) {
		this.bayName = bayName; 
		this.occupied = occupied; 
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBayName() {
		return bayName;
	}


	public void setBayName(String bayName) {
		this.bayName = bayName;
	}
	
	public Car getCar() {
		return cars; 
	}
	
	public void setCar(Car cars) {
		this.cars= cars; 
	}
	


	public boolean isOccupied() {
		return occupied;
	}


	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", bayName=" + bayName + ", occupied=" + occupied + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bayName, id, occupied);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(bayName, other.bayName) && Objects.equals(id, other.id) && occupied == other.occupied;
	}


	
	
	
	


}
