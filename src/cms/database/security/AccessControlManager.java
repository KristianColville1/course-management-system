/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.database.security;

import cms.database.security.enums.Permission;
import cms.database.security.enums.UserRole;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kristian
 *
 * Manages access control by mapping user roles to specific permissions. This
 * class provides the functionality to check whether a given role has the
 * necessary permissions to perform an action in the system.
 */
public class AccessControlManager {

    // instance fields
    private final Map<UserRole, EnumSet<Permission>> accessControlMap;

    /**
     * Default constructor AccessControlManager.
     *
     * Sets up the accessControlMap of the various users and their permissions
     */
    public AccessControlManager() {
        accessControlMap = new HashMap<>(); // set it up here
        setupAccessControl();
    }

    /**
     * Configures the default permissions for each user role.
     * 
     * Called during initialising the AccessControlManger.
     */
    private void setupAccessControl() {

        // the administrator has all of the essentials
        accessControlMap.put(
                UserRole.ADMIN, EnumSet.of(
                        Permission.READ,
                        Permission.WRITE,
                        Permission.DELETE));

        // the office worker has some permissions and can generate reports
        accessControlMap.put(
                UserRole.OFFICE, EnumSet.of(
                        Permission.READ,
                        Permission.GENERATE_REPORTS));

        // the lecturer worker has some permissions and can generate reports
        accessControlMap.put(
                UserRole.LECTURER, EnumSet.of(
                        Permission.READ,
                        Permission.GENERATE_REPORTS));
    }
}
