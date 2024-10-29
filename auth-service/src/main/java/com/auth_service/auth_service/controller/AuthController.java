package com.example.auth.controller;

import com.auth_service.auth_service.model.User;
import com.auth_service.auth_service.service.AuthService;
import com.auth_service.auth_service.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        authService.registerUser(user.getUsername(), user.getPassword());
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User loggedInUser = authService.loginUser(user.getUsername(), user.getPassword());
        return jwtService.generateToken(loggedInUser.getUsername());
    }
}
