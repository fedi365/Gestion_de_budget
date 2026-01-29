package org.example.gestion_de_budget.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // toutes les routes API
                        .allowedOrigins(
                                "http://localhost:5173", // Vite
                                "http://localhost:3000", // Create React App
                                "http://127.0.0.1:5173",
                                "https://tonsite.com" // futur domaine prod
                )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true); // important pour les cookies/sessions
            }
        };
    }
}
