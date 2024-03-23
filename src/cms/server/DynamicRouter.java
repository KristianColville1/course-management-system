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
}
