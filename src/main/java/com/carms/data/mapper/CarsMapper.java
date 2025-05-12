package com.carms.data.mapper;

import com.carms.data.dto.CarsDto;
import com.carms.data.entity.CarsEntity;

public class CarsMapper {

	public static CarsEntity mapToEntity(CarsDto carsDto) {
		return new CarsEntity(carsDto.getCarId(), 
				carsDto.getCarMake(), 
				carsDto.getCarModel(),
				carsDto.getManufactureYear(),
				carsDto.getColor(),
				carsDto.getFuleType(), 
				carsDto.getTransmission(),
				carsDto.getMileage(),
				carsDto.getPrice(), 
				carsDto.getCarType()
				);
	}

	public static CarsDto mapToDto(CarsEntity carsEntity) {
		return new CarsDto(carsEntity.getCarId(), 
				carsEntity.getCarMake(), 
				carsEntity.getCarModel(),
				carsEntity.getManufactureYear(), 
				carsEntity.getColor(), 
				carsEntity.getFuleType(),
				carsEntity.getTransmission(),
				carsEntity.getMileage(), 
				carsEntity.getPrice(),
				carsEntity.getCarType()
				);
	}

}
