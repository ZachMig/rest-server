package com.zachmig.rest.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.neo4j.core.schema.GeneratedValue;

@Node("Food")
public class Food {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	public Food(String name) {
		this.name = name;
	}
	
	@Relationship(type = "PAIRS_WITH", direction = Direction.OUTGOING)
	public Set<Food> neighbors;
	
	
	public void pairsWith(Food neighborFood) {
		if (neighbors == null) {
			neighbors = new HashSet<>();
		}
		neighbors.add(neighborFood);
	}
	
	
	public String toString() {
		return this.name + "'s pairings => "
			      + Optional.ofNullable(this.neighbors).orElse(
			          Collections.emptySet()).stream()
			            .map(Food::getName)
			            .collect(Collectors.toList());
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
