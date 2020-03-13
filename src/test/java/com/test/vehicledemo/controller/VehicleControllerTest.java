package com.test.vehicledemo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.vehicledemo.model.Vehicle;

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void createVehicle() throws Exception { 
		String uri = "/vehicle-api/v1/vehicles/vehicle";

		Vehicle vehicle = new Vehicle();
		vehicle.setVin("1A4AABBC5KD501999");
		vehicle.setYear(2019);
		vehicle.setMake("FCA");
		vehicle.setTransmissionType("MANUAL");
		vehicle.setModel("RAM");
				
		String inputJson = mapToJson(vehicle);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus(); 
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString(); 
		assertTrue(content.contains("1A4AABBC5KD501999"));

	}
	
	
	@Test
	public void createVehicleTransmissionError() throws Exception { 
		String uri = "/vehicle-api/v1/vehicles/vehicle";

		Vehicle vehicle = new Vehicle();
		vehicle.setVin("1A4AABBC5KD501999");
		vehicle.setYear(2019);
		vehicle.setMake("FCA");
		vehicle.setTransmissionType("XYZ");
		vehicle.setModel("RAM");
				
		String inputJson = mapToJson(vehicle);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus(); 
		assertEquals(400, status);

		String content = mvcResult.getResponse().getContentAsString(); 
		assertTrue(content.contains("Should be of transmission type MANUAL or AUTO"));

	}
	
	@Test
	public void createVehicleError() throws Exception { 
		String uri = "/vehicle-api/v1/vehicles/vehicle";

		Vehicle vehicle = new Vehicle();
		vehicle.setYear(2019);
		vehicle.setMake("FCA");
		vehicle.setTransmissionType("MANUAL");
		vehicle.setModel("RAM");
				
		String inputJson = mapToJson(vehicle);

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus(); 
		assertEquals(500, status);

		String content = mvcResult.getResponse().getContentAsString(); 
		assertTrue(content.contains("Internal Server Error"));

	}
	
	private String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

}
