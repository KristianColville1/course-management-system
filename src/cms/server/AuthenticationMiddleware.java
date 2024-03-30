/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import java.io.IOException;

/**
 *
 * @author kristian
 *
 * Responsible for handling the authentication of requests and implements the
 * IMiddleware interface.
 *
 * Processes requests for authentication.
 *
 */
public class AuthenticationMiddleware implements IMiddleware {

    // instance fields
    private final String homeRoute; // whatever is home

    /**
     * Constructor for AuthenticationMiddleware responsible for using dependency
     * injection to configure the home route of the micro service.
     *
     * @param homeRoute is the route to bring user home if auth fails
     */
    public AuthenticationMiddleware(String homeRoute) {
        this.homeRoute = homeRoute;
    }

    @Override
    public boolean process(IHttpRequest request, IHttpResponse response) throws IOException {
        return false;
    }

}
