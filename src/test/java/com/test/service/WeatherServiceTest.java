package com.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.dto.APIResponse;
import com.entity.Weather;
import com.repository.WeatherRepository;
import com.service.WeatherService;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest {

	@Mock
	private WeatherRepository repository;

	@InjectMocks
	private WeatherService service;

	@Test
	public void testGetWeatherByZipcode() {
		List<Weather> weatherData = new ArrayList<>();
		weatherData.add(new Weather(1L, "Los Angeles",90012, 56, 47, LocalDate.parse("2023-01-29")));
		weatherData.add(new Weather(3L, "Chicago",60603, 30, 20, LocalDate.parse("2023-01-29")));
		weatherData.add(new Weather(6L, "New York",10002, 50, 36, LocalDate.parse("2023-01-28")));
		weatherData.add(new Weather(8L, "Miami",33132, 77, 68, LocalDate.parse("2023-01-28")));

		when(repository.findAll()).thenReturn(weatherData);

		List<APIResponse> response = service.getWeatherByZipcode(90012);

		assertEquals("Los Angeles", response.get(0).getCity());
	}

	@Test
	public void testGetWeatherByCity() {
		List<Weather> weatherData = new ArrayList<>();
		weatherData.add(new Weather(1L, "Los Angeles",90012, 56, 47, LocalDate.parse("2023-01-29")));
		weatherData.add(new Weather(3L, "Chicago",60603, 30, 20, LocalDate.parse("2023-01-29")));
		weatherData.add(new Weather(6L, "New York",10002, 50, 36, LocalDate.parse("2023-01-28")));
		weatherData.add(new Weather(8L, "Miami",33132, 77, 68, LocalDate.parse("2023-01-28")));

		when(repository.findAll()).thenReturn(weatherData);

		List<APIResponse> response = service.getWeatherByCity("Miami");

		assertEquals(33132, response.get(0).getZipCode());
	}
}
