/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
/**
 *
 * @author kristian
 * 
 * Responsible for creating and validating Bearer tokens in HTTP requests
 */
public class TokenService {
    
    // static instance
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(
    SignatureAlgorithm.HS256);
}
