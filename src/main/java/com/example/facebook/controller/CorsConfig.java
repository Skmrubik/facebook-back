package com.example.facebook.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableJpaAuditing
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica CORS a todos los endpoints de la API
                .allowedOrigins("http://localhost:5173","http://127.0.0.1:5173") // Orígenes permitidos
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Permite todas las cabeceras
                .allowCredentials(true) // Permite credenciales (cookies, tokens de auth, etc.)
                .maxAge(3600); // Tiempo en segundos que la respuesta preflight puede ser cacheados
    }
}