package com.example.microservice3;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Microservice3Application {
    public static void main(String[] args) {
        // SpringApplication.run(Microservice3Application.class, args);

        SpringApplication app = new SpringApplication(Microservice3Application.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
    }
}
