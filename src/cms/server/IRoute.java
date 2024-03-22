/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author kristian
 */

@FunctionalInterface
public interface IRoute {
    
    /**
     * Should determine if the route matches a given request.
     * @param request is the HTTP request to match against
     * @return true if the route matches the request otherwise false
     */
    boolean matches(HttpServletRequest request);
}
