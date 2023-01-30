package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.APIResponse;
import com.entity.Weather;
import com.service.WeatherService;

@RestController
@RequestMapping("/api")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping("/weather/city/{city}")
	public List<APIResponse> getWeatherByCity(@PathVariable String city) {
		return weatherService.getWeatherByCity(city);
	}
	
	@GetMapping("/weather/zipcode/{zipcode}")
	public List<APIResponse> getWeatherByZipcode(@PathVariable Integer zipcode) {
		return weatherService.getWeatherByZipcode(zipcode);
	}

	@GetMapping("/weather")
	public List<Weather> getAllWeather() {
		return weatherService.getAllWeather();
	}
}
