package com.example.microservice1.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreeting() {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return "Hello from Microservice 1!\nVineet Sharma\nVersion-4.0.0 \n Todays Date - " + formattedDate;
    }
}
