package com.carms.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CarTable")
public class CarsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Car_Id")
	private long carId;

	@Column(name = "Car_Make")
	private String carMake;

	@Column(name = "Car_Model")
	private String carModel;

	@Column(name = "ManufactureYear")
	private String manufactureYear;

	@Column(name = "Color")
	private String color;

	@Column(name = "FuleType")
	private String fuleType;

	@Column(name = "Transmission")
	private String transmission;

	@Column(name = "Mileage")
	private String mileage;

	@Column(name = "Price")
	private double price;

	@Column(name = "CarType")
	private String carType;

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(String manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuleType() {
		return fuleType;
	}

	public void setFuleType(String fuleType) {
		this.fuleType = fuleType;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public CarsEntity(long carId, String carMake, String carModel, String manufactureYear, String color,
			String fuleType, String transmission, String mileage, double price, String carType) {
		super();
		this.carId = carId;
		this.carMake = carMake;
		this.carModel = carModel;
		this.manufactureYear = manufactureYear;
		this.color = color;
		this.fuleType = fuleType;
		this.transmission = transmission;
		this.mileage = mileage;
		this.price = price;
		this.carType = carType;
	}

	public CarsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CarsEntity [carId=" + carId + ", carMake=" + carMake + ", carModel=" + carModel + ", manufactureYear="
				+ manufactureYear + ", color=" + color + ", fuleType=" + fuleType + ", transmission=" + transmission
				+ ", mileage=" + mileage + ", price=" + price + ", carType=" + carType + "]";
	}
	
	

}
