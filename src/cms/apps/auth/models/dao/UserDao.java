/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.apps.auth.models.dao;

import cms.apps.auth.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kristian
 *
 * Responsible for communicating with the database using CRUD operations for the
 * User Object.
 */
public class UserDao {

    /**
     * Creates a user from a User object
     *
     * @param conn to use for connecting to the database
     * @param user object to place into the database
     * @return true if the user has been created otherwise false on exception
     */
    public boolean createUser(Connection conn, User user) {
        String sql
                = "INSERT INTO users "
                + "("
                + "username, "
                + "first_name, "
                + "last_name, "
                + "password_hash, "
                + "salt, role) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());
            pstmt.setString(4, user.getPasswordHash());
            pstmt.setString(5, user.getSalt());
            pstmt.setString(6, user.getRole());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Finds a user by the username given in the database
     *
     * @param conn is the connection to the database
     * @param username is the username to check against
     * @return user object if found otherwise return null
     */
    public User findByUsername(Connection conn, String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // sets up the user object from database using setters
                    User user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setSalt(rs.getString("salt"));
                    user.setHashedPassword(rs.getString("password_hash"));
                    user.setRole(rs.getString("role"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
