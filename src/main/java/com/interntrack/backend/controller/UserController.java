package com.interntrack.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.interntrack.backend.entity.User;
import com.interntrack.backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(
            @RequestBody User user) {

        User registeredUser =
                userService.registerUser(user);

        if (registeredUser == null) {
            return ResponseEntity
                    .badRequest()
                    .body("Email already exists");
        }

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(
            @RequestBody User user) {

        User loggedInUser =
                userService.loginUser(
                        user.getEmail(),
                        user.getPassword()
                );

        if (loggedInUser == null) {
            return ResponseEntity
                    .badRequest()
                    .body("Invalid email or password");
        }

        return ResponseEntity.ok(loggedInUser);
    }
}