package com.test.vehicledemo.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.vehicledemo.model.ApiError;
import com.test.vehicledemo.model.Result;
import com.test.vehicledemo.model.Vehicle;

@RestController
public class VehicleController {

	private static Map<String, Vehicle> vehicleRepo = new HashMap<>();

	@ResponseStatus
	@RequestMapping(value="/vehicle-api/v1/vehicles/vehicle", method=RequestMethod.POST)
	public ResponseEntity<Result> createProduct(@RequestBody Vehicle vehicle) {
		if(vehicle!=null && vehicle.getVin()!=null) {
			if(vehicle.getTransmissionType()!=null && (vehicle.getTransmissionType().equals("MANUAL") 
					|| vehicle.getTransmissionType().equals("AUTO")) ){
				//Storing into dummy map
				vehicleRepo.put(vehicle.getVin(), vehicle);

				Result result = new Result();
				result.setUid(UUID.randomUUID());
				result.setVin(vehicle.getVin());
				return new ResponseEntity<Result>(result, HttpStatus.OK);
			} else {
				final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Should be of transmission type MANUAL or AUTO");
		        return new ResponseEntity(apiError.getMessage() , apiError.getStatus());
			}
		}       

		final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        return new ResponseEntity(apiError.getMessage() , apiError.getStatus());
	}

}
