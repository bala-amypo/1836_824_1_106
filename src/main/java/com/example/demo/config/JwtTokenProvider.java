package com.example.demo.config;

import com.example.demo.entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    // ---------- TOKEN GENERATION ----------

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateToken(Long userId, String email, Role role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("roles", Set.of(role.name()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateToken(Long userId, String email, Set<Role> roles) {
        Set<String> roleNames = new HashSet<>();
        for (Role role : roles) {
            roleNames.add(role.name());
        }
        
        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("roles", roleNames)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // ---------- VALIDATION ----------

    public boolean validateToken(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            // Invalid signature or malformed JWT
        } catch (ExpiredJwtException e) {
            // Token expired
        } catch (UnsupportedJwtException e) {
            // Unsupported JWT
        } catch (IllegalArgumentException e) {
            // JWT claims string is empty
        }
        return false;
    }

    public boolean isTokenExpired(String token) {
        try {
            return extractExpiration(token).before(new Date());
        } catch (Exception e) {
            return true;
        }
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // ---------- EXTRACTION ----------

    public String getUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Long getUserId(String token) {
        Object id = extractAllClaims(token).get("userId");
        return id == null ? 1L : Long.parseLong(id.toString());
    }

    public Set<SimpleGrantedAuthority> getAuthorities(String token) {
        Object rolesObj = extractAllClaims(token).get("roles");
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        
        if (rolesObj instanceof Collection<?>) {
            for (Object role : (Collection<?>) rolesObj) {
                if (role != null) {
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + role.toString()));
                }
            }
        }
        
        return authorities;
    }

    // ---------- HELPER METHODS ----------

    private Claims extractAllClaims(String token) {
        return parseClaims(token);
    }

    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
}