package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
