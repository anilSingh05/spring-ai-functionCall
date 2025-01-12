package com.example.springai.spring_ai_functionCall;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "weather.api")
public record WeatherConfigProperties(String  key, String url) {
}
