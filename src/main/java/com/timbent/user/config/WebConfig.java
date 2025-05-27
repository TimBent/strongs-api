package com.timbent.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/**") // Adjust the path pattern as needed
                .allowedOrigins("http://localhost:3000","http://localhost:80")
                .allowedMethods("GET", "POST", "OPTIONS")
                .allowedHeaders("Content-Type: application/json") // Or restrict to specific headers
                .allowCredentials(true);
    }
}

