package com.example.springai.spring_ai_functionCall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(WeatherConfigProperties.class)
@SpringBootApplication
public class SpringAiFunctionCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiFunctionCallApplication.class, args);
	}

}
