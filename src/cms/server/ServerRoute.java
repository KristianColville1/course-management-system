/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import java.lang.reflect.Method;

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
    private final String path;
    private final String method;
    private final ControllerBase controller;
    private final Method controllerMethod;

    /**
     * Constructor for Route. Sets up a Route object with the path, method and
     * controller to use.
     *
     * @param path used in the request
     * @param method used in the request
     * @param controller is an instance of the matching controller for the
     * request
     * @param controllerMethod the method associated with the specific request
     */
    public ServerRoute(
            String path,
            String method,
            ControllerBase controller,
            Method controllerMethod) {
        this.path = path;
        this.method = method;
        this.controller = controller;
        this.controllerMethod = controllerMethod;
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
     * Responsible for invoking the correct method for the route
     *
     * @param request is the incoming HTTP request
     * @param response the object to be used by the controller.
     */
    public void invoke(IHttpRequest request, IHttpResponse response) {
        try {
            controllerMethod.setAccessible(true);
            controllerMethod.invoke(controller, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
