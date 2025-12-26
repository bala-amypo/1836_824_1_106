package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String username) {
       
        return "dummy-jwt-token-for-" + username;
    }

    public String getUsernameFromToken(String token) {
       
        return "user";
    }

    public boolean validateToken(String token) {
        
        return true;
    }
}
