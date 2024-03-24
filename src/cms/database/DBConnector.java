/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

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

    private static String dbHost;
    private static String user;
    private static String password;

    // static block to initialize the database connection parameters
    static {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream("env.properties")) {
            props.load(in);
            dbHost = props.getProperty("database.host");
            user = props.getProperty("database.user");
            password = props.getProperty("database.password");

            // load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // handle the exception appropriately
        }
    }

    /**
     * Gets a connection to the database using the connection parameters.
     *
     * @return a Connection object
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbHost, user, password);
    }
}
