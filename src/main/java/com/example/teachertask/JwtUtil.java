package com.example.teachertask;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.sql.Date;

import java.util.HashMap;
import java.util.Map;
@Component
public class JwtUtil {
    private final String secretKey = "345hu34bnhsiddfg3453453dfgv34564645ghf4576fmni32imvid8";
    public String generateToken(String username,String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role",role);
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String username) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //10 saat
                .signWith(SignatureAlgorithm.HS256,key)

                .compact();
    }
}
