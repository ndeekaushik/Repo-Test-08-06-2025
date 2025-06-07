package com.example.microservice1;

import com.example.microservice1.controller.GreetingController;
import com.example.microservice1.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GreetingControllerTest {

    // Mock the GreetingService and inject it into the Spring context
    @MockBean
    private GreetingService greetingService;

    // Autowire the GreetingController which will have the mocked GreetingService injected
    @Autowired
    private GreetingController greetingController;

    @Test
    void testGetGreeting() {
        // Mock the behavior of the GreetingService
        when(greetingService.getGreeting()).thenReturn("Hello from Microservice 1!");

        // Call the method in the controller and check the result
        String response = greetingController.getGreeting();

        // Assert that the response from the controller is as expected
        assertEquals("Hello from Microservice 1!", response);
    }
}