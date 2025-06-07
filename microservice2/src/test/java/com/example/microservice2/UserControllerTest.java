package com.example.microservice2;

import org.junit.jupiter.api.Test;                // JUnit 5 Test annotation
import org.junit.jupiter.api.Assertions;          // JUnit 5 Assertions
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.microservice2.controller.UserController;
import com.example.microservice2.service.UserService;
import com.example.microservice2.model.User;

import static org.mockito.Mockito.when;

@SpringBootTest
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private UserController userController;

    @Test
    void testCreateUser() {
        // Create a user instance
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        // Set an ID to simulate a generated ID
        user.setId(1L);  // Mock an ID, as it would be generated in a real scenario

        // Mock the userService.createUser() to return the user with the set ID
        when(userService.createUser(user)).thenReturn(user);

        // Call the controller method to create the user
        User createdUser = userController.createUser(user);

        // Assert that the ID is not null (simulating ID generation in the service layer)
        Assertions.assertNotNull(createdUser.getId(), "User ID should not be null");

        // Additional assertions to verify the user's name and email
        Assertions.assertEquals("John Doe", createdUser.getName());
        Assertions.assertEquals("john.doe@example.com", createdUser.getEmail());
    }
}


