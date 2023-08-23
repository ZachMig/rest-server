package com.zachmig.rest;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
	
	List<Review> findAll();
	
	long count();
	
}
