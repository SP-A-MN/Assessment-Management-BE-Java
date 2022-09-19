package com.spamn.trainerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TrainerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainerApiApplication.class, args);
	}

	// to configure CORS, just copy paste the below code
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// addMapping is for umbrella URLS
				// allowed origins is frontend url
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		};
	}
}
