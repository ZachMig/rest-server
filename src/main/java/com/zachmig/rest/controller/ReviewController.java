package com.zachmig.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zachmig.rest.entity.Review;
import com.zachmig.rest.repository.ReviewRepository;

@RestController
public class ReviewController {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@GetMapping(value = "/count")
	@CrossOrigin
	public long getReviewCount() {
		return reviewRepository.count();
	}
	
	@GetMapping(value="/all")
	@CrossOrigin
	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}
	
	
}
