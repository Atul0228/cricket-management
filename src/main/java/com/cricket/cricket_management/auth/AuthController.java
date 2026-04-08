package com.cricket.cricket_management.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cricket.cricket_management.user.User;
import com.cricket.cricket_management.user.UserRepository;
import com.cricket.cricket_management.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // REGISTER
    @PostMapping("/register")
    public String register(
            @RequestBody User user) {

        user.setRole("USER");

        userRepository.save(user);

        return "User registered successfully";
    }

    // LOGIN
    @PostMapping("/login")
    public String login(
            @RequestBody User user) {

        User existing =
                userRepository
                        .findByUsername(
                                user.getUsername())
                        .orElseThrow(
                                () ->
                                new RuntimeException(
                                        "User not found"));

        if (!existing.getPassword()
                .equals(user.getPassword())) {

            throw new RuntimeException(
                    "Invalid password");
        }

        return JwtUtil.generateToken(
                user.getUsername());
    }
}