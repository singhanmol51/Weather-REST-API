package com.cognizant.usecase2.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//try it using auto and joins also and mapping one to many
	private int id;
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int id2;
	@CreationTimestamp
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(updatable=false, nullable=false)
	private LocalDate date;
	@Column(nullable = false)
	private Double lon;
	@Column(nullable = false)
	private Double lat;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String state;
	@Column(nullable = false)
	private Double temperature;	
}
