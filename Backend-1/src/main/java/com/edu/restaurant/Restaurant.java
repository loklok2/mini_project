package com.edu.restaurant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Restaurant {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "rt_id")
	private Long id;
	
	private String address;
	
	private String menu;
	
	@Column(name="main_img", columnDefinition = "TEXT")
	private String img1;
	
	@Column(name="thumbnail_img", columnDefinition = "TEXT")
	private String img2;
	
	private String usage_day;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String point;
	
	@Column(name = "rt_name")
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String content;
}
