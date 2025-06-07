package com.example.microservice2.service;

import com.example.microservice2.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User createUser(User user) {
        // Simulate user creation
        user.setId(1L);
        return user;
    }

    public String getUser() {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return "Hello from Microservice 2!!!! \nUser Name is Vineet Sharma  \nVersion - 4.0.0 \n Todays Date - " + formattedDate;
    }
}
