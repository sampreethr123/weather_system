package com;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.entity.Weather;
import com.repository.WeatherRepository;

@Configuration
public class AppConfig {

	@Bean
	CommandLineRunner initDatabase(WeatherRepository repository) {
		return args -> {
			List<Weather> weather_data = new ArrayList<>();
			weather_data.add(new Weather(1L, "Los Angeles",90012, 56, 47, LocalDate.parse("2023-01-29")));
			weather_data.add(new Weather(2L, "Los Angeles",90012, 64, 46, LocalDate.parse("2023-01-28")));
			weather_data.add(new Weather(3L, "Chicago",60603, 30, 20, LocalDate.parse("2023-01-29")));
			weather_data.add(new Weather(4L, "Chicago",60603, 30, 16, LocalDate.parse("2023-01-28")));
			weather_data.add(new Weather(5L, "New York",10002, 49, 34, LocalDate.parse("2023-01-29")));
			weather_data.add(new Weather(6L, "New York",10002, 50, 36, LocalDate.parse("2023-01-28")));
			weather_data.add(new Weather(7L, "Miami",33132, 81, 70, LocalDate.parse("2023-01-29")));
			weather_data.add(new Weather(8L, "Miami",33132, 77, 68, LocalDate.parse("2023-01-28")));
			repository.saveAll(weather_data);

		};
	}
}
