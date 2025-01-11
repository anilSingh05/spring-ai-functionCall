package com.example.springai.spring_ai_functionCall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.function.Function;

/**
 * Weather API Service
 */
public class WeatherService implements Function<WeatherService.Request, WeatherService.Response> {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    private final WeatherConfigProperties weatherConfigProperties;
    private final RestClient restClient;

    public WeatherService(WeatherConfigProperties weatherConfigProperties) {
        this.weatherConfigProperties = weatherConfigProperties;
        this.restClient = RestClient.create(weatherConfigProperties.apiUrl());
    }

    @Override
    public Response apply(Request request) {
        log.info("Weather Request: {}", request);
        Response  response = restClient.get()
                .uri("/current.json?key={key}&q={q}",weatherConfigProperties.apiKey(),request.city)
                .retrieve()
                .body(Response.class);
        log.info("Weather API Response: {}", response);
        return  response;
    }

    // Mapping the response of the weather API to record. I only respond the information I was interested in.
    public record Request(String city){}
    public record Response(Location location, Current current){}
    public record Location(String name,String  region, String  country, Long lat, Long lon){}
    public record Current(String temp_f, Condition  condition, String wind_mph, String humidity){}
    public record Condition(String  text){}
}
