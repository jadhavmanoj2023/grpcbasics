package com.example.grpcdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow only the frontend origin
        config.setAllowedOrigins(List.of("http://localhost:3000", "http://127.0.0.1:3000"));

        // Allow necessary methods
        config.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS"));

        // Allow headers
        config.setAllowedHeaders(Arrays.asList("content-type", "authorization", "grpc-timeout"));

        // Allow credentials
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
