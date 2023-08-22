package com.zachmig.rest;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface FoodRepository extends Neo4jRepository<Food, Long> {
	
	@Query("MATCH (f1:Food {name: $name})<-[:PAIRS_WITH]->(fTarget:Food) return fTarget.name")
	List<String> findByName(String name);
	
	@Query("MATCH (f:Food) return DISTINCT f.name")
	List<String> findAllFoods();
	
}

