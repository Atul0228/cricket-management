package com.cricket.cricket_management.security;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

    private static final String SECRET =
            "mysecretkey";

    public static String generateToken(
            String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                + 1000 * 60 * 60))
                .signWith(
                        SignatureAlgorithm.HS256,
                        SECRET)
                .compact();
    }
}