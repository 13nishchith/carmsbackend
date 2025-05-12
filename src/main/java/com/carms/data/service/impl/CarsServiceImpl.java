package com.carms.data.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carms.data.dto.CarsDto;
import com.carms.data.entity.CarsEntity;
import com.carms.data.exception.ResourceNotFoundException;
import com.carms.data.mapper.CarsMapper;
import com.carms.data.repository.CarsRepository;
import com.carms.data.service.Cars;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarsServiceImpl implements Cars {

	@Autowired
	private CarsRepository carsRepository;

	private static final Logger logger = LoggerFactory.getLogger(CarsServiceImpl.class);

	@Override
	public CarsDto createCars(CarsDto carsDto) {
		CarsEntity cars = CarsMapper.mapToEntity(carsDto);
		CarsEntity saveCars = carsRepository.save(cars);
		logger.info("Car data saved successfully: {}", saveCars.toString());
		return CarsMapper.mapToDto(saveCars);
	}

	@Override
	public CarsDto getCarsById(long carId) {
		CarsEntity getEmployee = carsRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("Cars details not exists with given id : " + carId));
		logger.info("Car data fetched successfully: for carId {}: {}",carId, getEmployee.toString());
		return CarsMapper.mapToDto(getEmployee);
	}

	@Override
	public List<CarsDto> getAllCars() {
		List<CarsEntity> listofCars = carsRepository.findAll();
		logger.info("All Car data fetched successfully: {}", listofCars.toString());
		return listofCars.stream().map((car) -> CarsMapper.mapToDto(car)).collect(Collectors.toList());
	}

	@Override
	public CarsDto updateCars(long carId, CarsDto carsDto) {
		CarsEntity updateCars = carsRepository.findById(carId)
				.orElseThrow(() -> new ResourceNotFoundException("Cars details not exists with given id :" + carId));
		updateCars.setCarMake(carsDto.getCarMake());
		updateCars.setCarModel(carsDto.getCarModel());
		updateCars.setCarType(carsDto.getCarType());
		updateCars.setColor(carsDto.getColor());
		updateCars.setFuleType(carsDto.getFuleType());
		updateCars.setManufactureYear(carsDto.getManufactureYear());
		updateCars.setMileage(carsDto.getMileage());
		updateCars.setPrice(carsDto.getPrice());
		updateCars.setTransmission(carsDto.getTransmission());
		CarsEntity updateSaveCars = carsRepository.save(updateCars);
		logger.info("Car data updated successfully: {}", updateSaveCars.toString());
		return CarsMapper.mapToDto(updateSaveCars);
	}

	@Override
	public void deleteByCars(long carId) {
		carsRepository.deleteById(carId);
		logger.info("Car data delete successfully: for record {}", carId);
	}

}
