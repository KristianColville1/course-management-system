package cms.database;

import cms.apps.auth.models.User;
import cms.apps.auth.models.dao.UserDao;
import cms.database.security.SaltGenerator;
import cms.database.security.enums.UserRole;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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
        try (Connection conn = DBConnector.getConnection(); Statement stmt = conn.createStatement()) {

            String sql = String.format(
                    "CREATE DATABASE IF NOT EXISTS `%s` "
                    + "CHARACTER SET utf8mb4 "
                    + "COLLATE utf8mb4_unicode_ci;", dbName);

            stmt.executeUpdate(sql);
            System.out.println("Database " + dbName + " initialized or already exists.");
            DBSchemaGenerator.generateSchema(conn, dbName);

            // ensure we have admin access
            ensureAdminUserExists(conn);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize the database: " + dbName, e);
        }
    }

    /**
     * If the admin does not exist then create them.
     *
     * @param conn the connection to communicate with the database.
     */
    private void ensureAdminUserExists(Connection conn) {
        UserDao userDao = new UserDao();
        User adminUser = userDao.findByUsername(conn, "admin");
        if (adminUser == null) {
            // no admin user found, let's create the default one.
            Properties props = new Properties();
            try (FileInputStream in = new FileInputStream("env.properties")) {
                props.load(in);
                String username = props.getProperty("database.admin.username");
                String password = props.getProperty("database.admin.password");
                String role = UserRole.ADMIN.name();
                String salt = SaltGenerator.generateSalt();

                adminUser = new User(
                        username,
                        "Admin",
                        "User",
                        salt,
                        password,
                        role);
                boolean isCreated = userDao.createUser(conn, adminUser);

                if (isCreated) {
                    System.out.println(
                            "Admin user created successfully.");
                } else {
                    System.out.println(
                            "Failed to create admin user.");
                }
            } catch (IOException e) {
                System.out.println(
                        "Error, creating default admin failed. app broken.");
            }

        }
    }
}
