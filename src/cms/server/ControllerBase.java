/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

/**
 *
 * @author kristian
 *
 * Abstract base class for all controllers in the application. It provides a
 * structure for handling HTTP requests and generating responses. Concrete
 * controllers must implement the handleRequest method to define their specific
 * behaviour.
 */
public abstract class ControllerBase {

    /**
     * Handles incoming HTTP requests and generates a response.
     *
     * Concrete subclasses should implement this method to process the request.
     *
     * @param request is the abstracted HTTP request
     * @param response is the abstracted HTTP response
     */
    public abstract void handleRequest(IHttpRequest request, IHttpResponse response);
}
