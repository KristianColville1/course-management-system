/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.apps.auth.models;

import cms.mvc.annotations.Model;
import cms.mvc.annotations.Table;
import cms.mvc.annotations.Column;
import cms.mvc.models.BaseModel;

/**
 *
 * @author kristian
 */
@Model
@Table(name = "users")
public class User extends BaseModel{

    // instances
    /**
     * Primary key in the user database table
     */
    @Column(name = "user_id", type = "INT", primaryKey = true, nullable = false)
    private int userId;

    /**
     * The username of a user
     */
    @Column(name = "username", type = "VARCHAR(50)", nullable = false, unique = true)
    private String username;

    /**
     * The users first name
     */
    @Column(name = "first_name", type = "VARCHAR(50)", nullable = false)
    private String firstName;

    /**
     * The users last name
     */
    @Column(name = "last_name", type = "VARCHAR(50)", nullable = false)
    private String lastName;

    /**
     * The users password hash to compare against
     */
    @Column(name = "password_hash", type = "CHAR(64)", nullable = false)
    private String passwordHash;

    /**
     * The users salt - each user gets their own
     */
    @Column(name = "salt", type = "CHAR(16)", nullable = false)
    private String salt;

    /**
     * The users role
     */
    @Column(name = "role", type = "VARCHAR(20)", nullable = false)
    private String role;

}
