package com.dto;

import java.time.LocalDate;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIResponse {
    private String city;
    private int zipCode;
    private int minTemp;
    private int maxTemp;
    private LocalDate date;
}
