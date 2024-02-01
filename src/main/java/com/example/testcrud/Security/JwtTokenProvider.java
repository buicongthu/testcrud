package com.example.testcrud.Security;

import com.example.testcrud.Config.UserDetailsImpl;
import com.example.testcrud.Config.UserDetailsServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenProvider {
    private final String secretKey = "JwtSecretKeyddadasdasdJwtSecretKeyddadasdasdJwtSecretKeyddadasdasdJwtSecretKeyddadasdasd";
    private final long validityInMilliseconds = 3600000; // 1 hour



    public String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }




}
