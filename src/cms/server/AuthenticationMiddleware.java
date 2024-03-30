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

    /**
     * Processes the request and returns true or false if the token is valid.
     * Routes the user home with the redirectHome method.
     *
     * @param request is the IHttpRequest object
     * @param response is the IHttpResponse object
     * @return true or false for token validation
     * @throws IOException if exception occurs
     */
    @Override
    public boolean process(IHttpRequest request, IHttpResponse response) throws IOException {
        String authHeader = request.getHeader("Authorization"); // the auth

        // when the header is attached
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                int userId = TokenService.extractUserIdFromBearerToken(authHeader);
                request.setUserId(userId);
                return true; // token is valid
            } catch (Exception e) {
                redirectHome(request, "Invalid token. Please log in.");
                return false; // token is invalid
            }
        } else {
            redirectHome(request, "You need to login to continue");
        }
        return false;
    }

    /**
     * Routes user back to the home controller logic
     *
     * @param request is the original request for extracting details
     * @param message is the message to display for reason going home
     */
    private void redirectHome(IHttpRequest request, String message) {
        System.out.println(message);
        InternalRequestHandler.sendRequest(
                request, homeRoute, "GET");
    }
}
