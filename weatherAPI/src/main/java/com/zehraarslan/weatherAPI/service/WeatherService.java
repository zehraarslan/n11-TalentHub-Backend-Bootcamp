package com.zehraarslan.weatherAPI.service;

import com.zehraarslan.weatherAPI.client.WeatherApiClient;
import com.zehraarslan.weatherAPI.exception.BadRequestException;
import com.zehraarslan.weatherAPI.exception.InternalServerErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherApiClient weatherApiClient;

    public WeatherService(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    public ResponseEntity<String> getWeatherForecast (String country, String city, int numberOfDays) {
        try {
            if (numberOfDays <= 0) {
                throw new IllegalArgumentException("Number of days should be greater than zero");
            }
            if (city == null || city.trim().isEmpty() || country == null || country.trim().isEmpty()) {
                throw new BadRequestException("City and country parameters cannot be null or empty");
            }
            return weatherApiClient.getWeatherForecast(country, city, numberOfDays);
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to fetch weather forecast data");
        }
    }
}
