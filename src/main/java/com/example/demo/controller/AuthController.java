package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.config.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }
 @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody AuthRequest request) {
        try {
            // Check if user already exists
            if (userService.findByEmail(request.getEmail()).isPresent()) {
                return ResponseEntity
                    .badRequest()
                    .body(Map.of("error", "Email already registered"));
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
            return ResponseEntity
                .badRequest()
                .body(Map.of("error", e.getMessage()));
        }
    }
    

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        User user = userService.findByEmail(request.getEmail());
        String token = jwtTokenProvider.generateToken(user.getId(), user.getEmail(), user.getRole());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}