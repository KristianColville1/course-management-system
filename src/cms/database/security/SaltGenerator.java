/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.database.security;

import java.security.SecureRandom;
import javax.xml.bind.DatatypeConverter;
/**
 *
 * @author kristian
 *
 * Utility class for generating a salt for passwords.
 *
 * Generates a cryptographic salt. These are used to add randomness to passwords
 * before they are hashed to enhance security.
 */
public class SaltGenerator {

    /**
     * Generates a new salt.
     * 
     * @return hexadecimal representation of a generated salt
     */
    public static String generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // big enough
        random.nextBytes(salt);
        return DatatypeConverter.printHexBinary(salt);
    }
}
