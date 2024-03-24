package cms.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kristian
 * 
 * Responsible for initialising the database for the application.
 */
public class DatabaseInitialiser {

    // instance fields
    private final String dbName = "cms";

    /**
     * Initializes the database.
     * 
     * If it does not exist build it.
     */
    public void initialise() {
        try (Connection conn = DBConnector.getConnection();
             Statement stmt = conn.createStatement()) {

            String sql = String.format(
                    "CREATE DATABASE IF NOT EXISTS `%s` "
                            + "CHARACTER SET utf8mb4 "
                            + "COLLATE utf8mb4_unicode_ci;", dbName);

            stmt.executeUpdate(sql);
            System.out.println("Database " + dbName + " initialized or already exists.");
            DBSchemaGenerator.generateSchema(conn, dbName);
            
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize the database: " + dbName, e);
        }
    }
}
