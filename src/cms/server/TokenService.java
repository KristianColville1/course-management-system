/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Date;

import javax.crypto.SecretKey;
/**
 *
 * @author kristian
 * 
 * Responsible for creating and validating Bearer tokens in HTTP requests
 */
public class TokenService {
    
    // static instances - bearer key and expiration time 
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(
    SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 86400000; // 1 day
    
    /**
     * Static method generates a new Bearer Token for the user ID given
     * @param userId is the user this bearer belongs to
     * @return the Bearer token header string
     */
    public static String generateBearerToken(int userId){
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);
        
        String token = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
        return "Bearer " + token;
    }
}
