package com.zehraarslan.weatherAPI.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zehraarslan.weatherAPI.exception.InternalServerErrorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherApiClient {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public WeatherApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getWeatherForecast(String country, String city, int numberOfDays) {
        String url = buildUrl(country, city, numberOfDays);
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response;
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to fetch weather forecast data from external API");
        }
    }

    private String buildUrl(String country, String city, int numberOfDays) {
        return String.format("%s?q=%s,%s&cnt=%d&APPID=%s&units=metric", apiUrl, city, country, numberOfDays, apiKey);
    }


}
