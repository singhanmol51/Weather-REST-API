package com.cognizant.usecase2.service;

import java.util.List;

import com.cognizant.usecase2.entities.Weather;

public interface WeatherService {

	public List<Weather> getAllWeather();
	public Weather getWeatherById(int id);
	public Weather saveWeather(Weather weather);
	public Weather deleteWeather(int id);
	public Weather updateWeather(int id, Weather weather);
	public List<Weather> getWeatherByCity(String city);
	public List<Weather> getWeatherByState(String State);
}
