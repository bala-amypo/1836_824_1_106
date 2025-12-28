package com.example.demo.controller;

import com.example.demo.config.JwtProvider;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtProvider jwtProvider;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request) {
        try {
            // Check if user already exists
            Optional<User> existingUser = userService.findByEmail(request.getEmail());
            if (existingUser.isPresent()) {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "Email already registered");
                return ResponseEntity.badRequest().body(errorResponse);
            }
            
            // Create new user with USER role by default
            User user = new User(
                request.getEmail(),
                request.getPassword(),
                Role.USER
            );
            
            // Register user
            User createdUser = userService.register(user);
            
            // Generate JWT token
            String token = jwtProvider.generateToken(
                createdUser.getId(),
                createdUser.getEmail(),
                createdUser.getRole()
            );
            
            // Return response
            return ResponseEntity.ok(new AuthResponse(token));
            
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        try {
            // Find user by email
            Optional<User> userOptional = userService.findByEmail(request.getEmail());
            if (userOptional.isEmpty()) {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "User not found");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
            }
            
            User user = userOptional.get();
            
            // Verify password
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "Invalid credentials");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
            }
            
            // Generate JWT token
            String token = jwtProvider.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
            );
            
            // Return response
            return ResponseEntity.ok(new AuthResponse(token));
            
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}