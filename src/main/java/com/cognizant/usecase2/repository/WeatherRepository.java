package com.cognizant.usecase2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.usecase2.entities.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer>{

	//@query multiple ways to write the query
	List<Weather> findByCity(String city);
	
	List<Weather> findByState(String state);
}
