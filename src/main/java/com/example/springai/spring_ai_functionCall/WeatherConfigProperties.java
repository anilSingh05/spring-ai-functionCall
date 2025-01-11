package com.example.springai.spring_ai_functionCall;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "weather")
public record WeatherConfigProperties(String  apiKey, String apiUrl) {
}
