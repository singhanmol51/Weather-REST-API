package com.cognizant.usecase2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.usecase2.entities.Weather;
import com.cognizant.usecase2.exceptions.InvalidInputException;
import com.cognizant.usecase2.exceptions.IdNotFoundException;
import com.cognizant.usecase2.repository.WeatherRepository;
import com.cognizant.usecase2.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService  {

	@Autowired
	WeatherRepository weatherRepo;
	
	

	@Override
	public List<Weather> getAllWeather() {
		// TODO Auto-generated method stub
		return this.weatherRepo.findAll();
	}

	@Override
	public Weather getWeatherById(int id) {
		// TODO Auto-generated method stub
		return this.weatherRepo.findById(id).orElseThrow(()->new IdNotFoundException("Weather Data Not Found with  ID: "+id));
	}

	@Override
	public Weather saveWeather(Weather weather) {
		// TODO Auto-generated method stub
		if(weather.getLon()==null || weather.getCity()==null || weather.getLat()==null || weather.getState()==null || weather.getTemperature()==null)
		{
			throw new InvalidInputException("No Field Can Be Null");
		}
		else
		{
			weather.setLat((double) (Math.round(weather.getLat()*10000)/10000.0));
			weather.setLon((double) (Math.round(weather.getLon()*10000)/10000.0));
			weather.setTemperature((double) (Math.round(weather.getTemperature()*10)/10.0));
			return this.weatherRepo.save(weather);
		}
	}

	@Override
	public Weather deleteWeather(int id) {
		// TODO Auto-generated method stub
		this.weatherRepo.findById(id).orElseThrow(()->new IdNotFoundException("Weather Data Not Found with ID: "+id));
		this.weatherRepo.deleteById(id);
		return null;
	}

	@Override
	public Weather updateWeather(int id, Weather weather) {
		// TODO Auto-generated method stub
		Weather old=this.weatherRepo.findById(id).orElseThrow(()->new IdNotFoundException("Weather Data Not Found with User ID: "+id));
		
		if(weather.getLon()==null || weather.getCity()==null || weather.getLat()==null || weather.getState()==null || weather.getTemperature()==null)
		{
			throw new InvalidInputException("No Field Can Be Null");
		}
		else 
		{
			old.setLat((double)(Math.round(weather.getLat()*10000)/10000.0));
			old.setLon((double)(Math.round(weather.getLon()*10000)/10000.0));
			old.setTemperature((double) (Math.round(weather.getTemperature()*10)/10.0));
			old.setCity(weather.getCity());
			old.setState(weather.getState());
			return this.weatherRepo.save(old);
		}
	}

	@Override
	public List<Weather> getWeatherByCity(String city) {
		// TODO Auto-generated method stub
		return this.weatherRepo.findByCity(city);
	}

	@Override
	public List<Weather> getWeatherByState(String state) {
		// TODO Auto-generated method stub
		return this.weatherRepo.findByState(state);
	}
	

	
}
