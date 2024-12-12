package com.zachholt.WeatherAPI.controllers;

import com.zachholt.WeatherAPI.models.Weather;
import com.zachholt.WeatherAPI.services.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<Weather> getWeather(@RequestParam("q") String zipcode) {
        Weather weather = weatherService.getWeather(zipcode);
        return ResponseEntity.ok(weather);
    }
} 