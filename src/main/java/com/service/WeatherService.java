package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.APIResponse;
import com.entity.Weather;
import com.repository.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository repository;

	public List<Weather> getAllWeather() {
		return repository.findAll();
	}

	public List<APIResponse> getWeatherByZipcode(Integer zipcode) {
		return getWeatherResponse(null,zipcode);
	}

	public List<APIResponse> getWeatherByCity(String city) {
		return getWeatherResponse(city,null);
	}

	private List<APIResponse> getWeatherResponse(String city,Integer zipCode) {
		List<Weather> weatherData = new ArrayList<>();
		weatherData = getAllWeather();
		if (zipCode != null) {

			weatherData = weatherData.stream().filter(e -> e.getZipCode().equals(zipCode))
					.collect(Collectors.toList());

		} else if (city!=null) {
			weatherData = weatherData.stream().filter(e -> e.getCity().equals(city))
					.collect(Collectors.toList());
		}
		
		List<APIResponse> apiResponseList = new ArrayList<APIResponse>();
		for (int i=0; i<weatherData.size();i++) {
			Weather weather = weatherData.get(i);
			APIResponse apiResponse = new APIResponse(weather.getCity(),weather.getZipCode(),weather.getMinTemp(),weather.getMaxTemp(),weather.getDate());
			apiResponseList.add(apiResponse);
		}
		return apiResponseList;
	}
}
