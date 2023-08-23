package com.zachmig.rest;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="review")
public class Review {

	public Review() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="coffee_id")
	private Coffee coffee;
	
	@NotNull
	@Column(name="review_content")
	private String reviewContent;
	
	@Column(name="date_of")
	private LocalDate dateOf;
	
	@Column(name="recommend")
	private boolean recommend;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Coffee getCoffee() {
		return coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public LocalDate getDateOf() {
		return dateOf;
	}

	public void setDateOf(LocalDate dateOf) {
		this.dateOf = dateOf;
	}

	public boolean isRecommend() {
		return recommend;
	}

	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}
	
	
}
