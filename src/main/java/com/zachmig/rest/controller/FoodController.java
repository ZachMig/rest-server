package com.zachmig.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zachmig.rest.repository.FoodRepository;

/**
 * Rest Controller which will handle get requests containing a food name
 * 	and respond with a JSON containing its neighbors
 * Requests should be formatted as in this example: localhost:8080/food?name=Apple
 * @author zmigliorini@gmail.com
 *
 */
@RestController
public class FoodController {
	@Autowired
	private FoodRepository foodRepo;
	
	@GetMapping(
			value = "/food"
	)
	@CrossOrigin
	public List<String> getNeighborsByName(@RequestParam(value="name") String name) { 
		
		return foodRepo.findByName(name.replace("_", " ").trim());
				
	}
	
	@GetMapping(
			value = "/foods"
	)
	@CrossOrigin
	public List<String> getAllFoods() { 
		return foodRepo.findAllFoods();
	}
	
	
	@GetMapping(
			value = "/health"
	)
	@CrossOrigin
	public String getHealthy() { 
		
		return "Healthy";
				
	}
	
	
}
