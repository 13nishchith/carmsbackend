package com.carms.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CarsDto {

	@Schema(description = "The unique identifier of the car (auto-generated, not required in POST/PUT)", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
	private long carId;
	@Size(min = 2, max = 50, message = "Car make size must be between 2 and 50 characters")
	@Schema(example = "Toyota", description = "Make of the car", defaultValue = "Toyota")
	private String carMake;
	@Size(min = 1, max = 50, message = "Car model size must be between 1 and 50 characters")
	@Schema(example = "Corolla", description = "Model of the car", defaultValue = "Corolla")
	private String carModel;
	@Schema(example = "2020", description = "Manufacture year of the car", defaultValue = "2020")
	@Pattern(regexp = "^(19|20)\\d{2}$", message = "Manufacture year must be a valid year (e.g., 2020)")
	private String manufactureYear;
	@Schema(example = "Blue", description = "Color of the car", defaultValue = "Blue")
	@Size(max = 30, message = "Color size should not exceed 30 characters")
	private String color;
	@Schema(example = "Gasoline", description = "Fuel type of the car", defaultValue = "Gasoline")
	@Pattern(regexp = "^(Petrol|Diesel|Electric|Hybrid|Gasoline)$", message = "Fuel type must be valid (e.g., Petrol, Diesel, Electric, Hybrid, Gasoline etc.)")
	private String fuleType;
	@Schema(example = "Automatic", description = "Transmission type of the car", defaultValue = "Automatic")
	@Pattern(regexp = "^(Automatic|Manual)$", message = "Transmission must be 'Automatic' or 'Manual'")
	private String transmission;
	@Schema(example = "15000km", description = "Mileage of the car", defaultValue = "15,000 km")
	@Pattern(regexp = "^[0-9]+(km|miles)?$", message = "Mileage must be a number followed by 'km' or 'miles'")
	private String mileage;
	@Schema(example = "2000000.00", description = "Price of the car", defaultValue = "2000000.00")
	@Digits(integer = 7, fraction = 2, message = "Price must be a valid monetary value (up to 2 decimal places)")
	private double price;
	@Schema(example = "Sedan", description = "Type of the car", defaultValue = "Sedan")
	@Pattern(regexp = "^(Sedan|SUV|Hatchback|Truck|Van|Other)$", message = "Car type must be valid")
	private String carType;

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

	public CarsDto(long carId, String carMake, String carModel, String manufactureYear, String color, String fuleType,
			String transmission, String mileage, double price, String carType) {
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

	public CarsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CarsDto [carId=" + carId + ", carMake=" + carMake + ", carModel=" + carModel + ", manufactureYear="
				+ manufactureYear + ", color=" + color + ", fuleType=" + fuleType + ", transmission=" + transmission
				+ ", mileage=" + mileage + ", price=" + price + ", carType=" + carType + "]";
	}

}
