package com.zachmig.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
