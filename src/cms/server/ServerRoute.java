/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

/**
 *
 * @author kristian
 *
 * Responsible for the concrete implementation of the IRoute interface for
 * matching HTTP requests based on path and method, and delegating to a specific
 * controller.
 */
public class ServerRoute implements IRoute {

    // instance fields
    private String path;
    private String method;
    private ControllerBase controller;

    /**
     * Constructor for Route. Sets up a Route object with the path, method and
     * controller to use.
     *
     * @param path
     * @param method
     * @param controller
     */
    public ServerRoute(String path, String method, ControllerBase controller) {
        this.path = path;
        this.method = method;
        this.controller = controller;
    }

    /**
     * Checks if the request path and method equals the routes path and method.
     *
     * @param request is the incoming HTTP request to match against
     * @return true if match otherwise false
     */
    @Override
    public boolean matches(IHttpRequest request) {
        return request.getMethod().equalsIgnoreCase(method)
                && request.getPath().equals(path);
    }

    /**
     * Retrieves the controller associated with the route. Controller handles
     * the logic for that route.
     *
     * @return the controller instance that handles the request
     */
    @Override
    public ControllerBase getController() {
        return controller;
    }
}
