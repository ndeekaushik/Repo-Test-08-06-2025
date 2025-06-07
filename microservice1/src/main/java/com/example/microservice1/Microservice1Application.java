package com.example.microservice1;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Microservice1Application {
    public static void main(String[] args) {
        // SpringApplication.run(Microservice1Application.class, args);
        
        SpringApplication app = new SpringApplication(Microservice1Application.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        app.run(args);
    }
}