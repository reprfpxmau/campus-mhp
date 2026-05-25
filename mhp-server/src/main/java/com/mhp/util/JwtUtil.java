package com.mhp.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import com.mhp.properties.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    @Autowired
    private JwtProperties jwtProperties;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes());
    }

    public String createToken(String studentNo, String role) {
        long expiration = "admin".equals(role)
                ? jwtProperties.getAdminExpiration()
                : jwtProperties.getUserExpiration();
        return Jwts.builder()
                .claim("studentNo", studentNo)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getKey())
                .compact();
    }
}
