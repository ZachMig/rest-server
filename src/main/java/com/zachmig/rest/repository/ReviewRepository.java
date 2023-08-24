package com.zachmig.rest.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zachmig.rest.entity.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
	
	List<Review> findAll();
	
	long count();
	
}
