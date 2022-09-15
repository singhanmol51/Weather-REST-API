package com.cognizant.usecase2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.usecase2.entities.Weather;
import com.cognizant.usecase2.service.WeatherService;


@RestController
@RequestMapping("/weather")

public class WeatherController {
	
	@Autowired
	WeatherService weatherService;
	
	@PostMapping("/")
	public ResponseEntity<Weather> saveWeather(@RequestBody Weather weather)
	{
		return new ResponseEntity<Weather>(this.weatherService.saveWeather(weather), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public List<Weather> getAll()
	{
		return this.weatherService.getAllWeather();
	}
	
	@GetMapping("/{id}")
	public Weather getWeatherById(@PathVariable int id)
	{
		return this.weatherService.getWeatherById(id);
	}
	
	@PutMapping("/update/{id}")
	public Weather updateById(@PathVariable int id, @RequestBody Weather weather)
	{
		return this.weatherService.updateWeather(id, weather);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Weather> deleteWeather(@PathVariable int id)
	{
		
		return new ResponseEntity<Weather>(this.weatherService.deleteWeather(id),HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/city/{city}")
	public List<Weather> getWeatherByCity(@PathVariable String city)
	{
		return this.weatherService.getWeatherByCity(city);
	}
	
	@GetMapping("/state/{state}")
	public List<Weather> getWeatherByState(@PathVariable String state)
	{
		return this.weatherService.getWeatherByState(state);
	}
	
	
}
