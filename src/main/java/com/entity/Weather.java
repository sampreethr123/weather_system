package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weather")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Weather {
	@Id
	private long weatherId;
	private String City;
	private Integer zipCode;
	private Integer maxTemp;
	private Integer minTemp;
	private LocalDate date;
}
