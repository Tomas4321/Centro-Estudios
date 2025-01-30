package com.example.Centro_Estudios.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    //Del Front al Back
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Rutas que quieres habilitar para CORS
                .allowedOrigins("http://localhost:5173", "http://localhost:5174")  // Tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos que permites
                .allowedHeaders("*")  // Permite todos los encabezados
                .allowCredentials(true);  // Permite enviar cookies si es necesario
    }
}


