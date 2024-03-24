/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.database.security;

import cms.database.security.enums.Permission;
import cms.database.security.enums.UserRole;
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
}
