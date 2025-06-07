package com.example.microservice2;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Microservice2Application {
    public static void main(String[] args) {
        // SpringApplication.run(Microservice2Application.class, args);

        SpringApplication app = new SpringApplication(Microservice2Application.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
        app.run(args);
    }
}
