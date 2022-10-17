package com.runsystem.student.security;

import io.jsonwebtoken.*;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Utilities for JWT.
 */
@Component
@Slf4j
public class JwtTokenProvider {
    @Value("baoy")
    private String secret;

    private final long JWT_EXPIRATION = 604800000L;

    /**
     * Generate JWT token based on account.
     * @param account The email of the user.
     * @return The generated token.
     */
    public String generateToken(String account) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts
                .builder()
                .setSubject(account)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * Extract the email address from a JWT token.
     * @param token The token to extract email from.
     * @return The extracted email.
     */
    public String getAccountFromJWT(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    /**
     * Check if a JWT token is currently valid.
     * @param authToken The JWT token to check.
     * @return true if the token is valid, false otherwise.
     */
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
