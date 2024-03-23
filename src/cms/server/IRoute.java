/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author kristian
 *
 * Interface responsible for defining a route in the application. A route is
 * responsible for matching an incoming request to a controller to it can be
 * handled correctly.
 */
public interface IRoute {

    /**
     * Should determine if the route matches a given request.
     *
     * @param request is the HTTP request to match against
     * @return true if the route matches the request otherwise false
     */
    boolean matches(IHttpRequest request);

    /**
     * Should retrieve the controller associated with this route.
     *
     * @return the controller that should handle the request if this route
     * matches.
     */
    ControllerBase getController();
}
