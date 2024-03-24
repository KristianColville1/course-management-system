/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.database.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author kristian
 *
 * Hashes a password using SHA-256 algorithm
 */
public class PasswordHasher {

    /**
     * Attempts to hash a password for a user
     * @param password the password the user gave
     * @param salt the salt to use for hashing
     * @return hexadecimal string of the hashed password
     */
    public static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((salt + password).getBytes());
            byte[] hashedPassword = md.digest();
            return DatatypeConverter.printHexBinary(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorithm not supported", e);
        }
    }
}
