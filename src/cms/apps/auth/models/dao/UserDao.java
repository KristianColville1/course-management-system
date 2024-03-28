/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.apps.auth.models.dao;

import cms.apps.auth.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kristian
 *
 * Responsible for communicating with the database using CRUD operations for the
 * User Object.
 */
public class UserDao {

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
}
