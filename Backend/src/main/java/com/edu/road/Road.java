package com.edu.road;


import org.locationtech.jts.geom.LineString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Road {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "rd_id")
	private Long id;
	@Column(nullable = false)
	private Integer cty_cd;
	
	@Column(nullable = false, name = "rd_nm")
	private String name;
	
	@Column(nullable = false)
	private Integer grade;
	
	@Column(nullable = false)
	private String geometry;
	
	private float length;
}
