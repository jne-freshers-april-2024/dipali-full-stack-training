package com.microservices.userservice.controller;

import com.microservices.userservice.entity.User;
import com.microservices.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);


    //    @PostMapping("/user")
    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully: " + createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create user: " + e.getMessage());
        }
    }

//    @GetMapping("/user")
    @GetMapping
    public ResponseEntity<Object> getAllUser() {
        try {
            List<User> userList = userService.getAllUser();
            return ResponseEntity.status(HttpStatus.OK).body(userList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch users: " + e.getMessage());
        }
    }


//    @GetMapping("/user/{id}")
    @GetMapping("/{id}")
    @CircuitBreaker(name = "appointmentPaymentBreaker", fallbackMethod = "appointmentPaymentFallback")
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        try {
            User user = userService.getUserById(id);
            if (user != null) {
                return ResponseEntity.status(HttpStatus.OK).body(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch user: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> appointmentPaymentFallback(int id, Exception ex)
    {
        logger.info("Fallback is executed because service is down",ex.getMessage());
        User user = new User();
        user.setEmailId("dummy@gmail.com");
        user.setFirstName("Dummy");
        user.setLastName("DummyLastname");
        user.setRole("DummyRole");
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
