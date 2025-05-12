package com.carms.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carms.data.dto.CarsDto;
import com.carms.data.exception.ResourceNotFoundException;
import com.carms.data.service.Cars;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin("*")
public class CarsController {

	@Autowired
	private Cars cars;

	@Operation(summary = "Create a new car")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Car created successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid car data") })
	@PostMapping
	public ResponseEntity<CarsDto> createCars(@Valid @RequestBody CarsDto carsDto) {
		CarsDto saveCars = cars.createCars(carsDto);
		return new ResponseEntity<>(saveCars, HttpStatus.CREATED);
	}

	@Operation(summary = "Update an existing car")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Car updated successfully"),
			@ApiResponse(responseCode = "404", description = "Car not found") })
	@PutMapping("{carId}")
	public ResponseEntity<CarsDto> updateCars(@PathVariable("carId") long carId, @Valid @RequestBody CarsDto carsDto) {
		CarsDto updateCars = cars.updateCars(carId, carsDto);
		return ResponseEntity.ok(updateCars);
	}
	
	@Operation(summary = "Get details of a specific car")
	@ApiResponses(value = { 
	    @ApiResponse(responseCode = "200", description = "Car found"),
	    @ApiResponse(responseCode = "404", description = "Car not found")
	})
	@GetMapping("{carId}")
	public ResponseEntity<?> getCars(@PathVariable("carId") long carId) {
	    CarsDto getCars = new CarsDto();
	    try {
	        getCars = cars.getCarsById(carId);
	    } catch (ResourceNotFoundException ex) {
	        System.out.println(ex.getMessage());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Error Response: Cars details not exists with given id : " + carId);
	    }
	    return ResponseEntity.ok(getCars);
	}


	@Operation(summary = "Get a list of all cars")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "List of cars retrieved successfully") })
	@GetMapping
	public ResponseEntity<List<CarsDto>> getAllCars() {
		List<CarsDto> getAllCars = cars.getAllCars();
		return ResponseEntity.ok(getAllCars);
	}

	@Operation(summary = "Delete a car by ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Car deleted successfully"),
			@ApiResponse(responseCode = "404", description = "Car not found") })
	@DeleteMapping("{carId}")
	public ResponseEntity<String> deleteCars(@PathVariable("carId") long carId) {
		cars.deleteByCars(carId);
		return ResponseEntity.ok("Cars Data Deleted Successfully");
	}
}
