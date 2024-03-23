/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.database;

/**
 *
 * @author kristian
 *
 * The DBConnector class is designed to establish a connection to the database.
 * It establishes a connection using the details from the env.properties file.
 *
 * This class can be extended or used by other classes for performing specific
 * database operations, ensuring that all interactions with the database are
 * routed through a single connection mechanism.
 */

public class DBConnector {

    // instance fields
    private String DB_URL;
    private String USER;
    private String PASSWORD;

}