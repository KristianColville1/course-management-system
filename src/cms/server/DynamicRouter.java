/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kristian
 *
 * Responsible for dynamically routing requests to the controllers based on
 * registered routes here.
 */
public class DynamicRouter {

    // instance fields
    private List<IRoute> routes = new ArrayList<>();

    /**
     * Registers a new route with the router
     *
     * @param route is the route to be registered
     */
    public void registerRoute(IRoute route) {
        routes.add(route);
    }

    /**
     * Dispatches the incoming request to the appropriate controller based on
     * route. Calls the route to invoke the method responsible for the route.
     *
     * @param request the incoming request.
     * @param response the object to be used by the controller.
     */
    public void routeRequest(IHttpRequest request, IHttpResponse response) {
        for (IRoute route : routes) {
            if (route.matches(request)) {
                ((ServerRoute) route).invoke(request, response);
                return;
            }
        }

        // you would normally create 404 below if route not found
        // terminal based only but using same logic
        // response.setStatusCode(404);
        // response.write("not found");
    }
}
