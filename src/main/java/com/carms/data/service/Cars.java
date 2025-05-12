package com.carms.data.service;

import java.util.List;

import com.carms.data.dto.CarsDto;

public interface Cars {

	CarsDto createCars(CarsDto carsDto);

	CarsDto getCarsById(long carId);

	List<CarsDto> getAllCars();

	CarsDto updateCars(long carId, CarsDto carsDto);

	void deleteByCars(long carId);
}
