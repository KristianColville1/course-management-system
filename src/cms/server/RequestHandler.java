/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import cms.server.adapters.JettyHttpRequestAdapter;
import cms.server.adapters.JettyHttpResponseAdapter;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author kristian
 *
 * Responsible for handling incoming HTTP requests. Routes the requests to the
 * appropriate controllers.
 *
 * Wraps incoming server request and response objects in abstract adapters.
 * Determines the appropriate controller to handle the request. Invokes the
 * controller with the abstract request and response object. Ensures that the
 * processed response is sent back to the client.
 */
public class RequestHandler extends AbstractHandler {

    // instance fields
    private final DynamicRouter router;

    /**
     * Default Constructor for RequestHandler
     * 
     * Sets up the dynamic router to use.
     */
    public RequestHandler() {
        this.router = new DynamicRouter();
    }

    /**
     * Processes all HTTP requests and delegates the work to the controllers. It
     * is overridden from AbstractHandler and is called by the server for each
     * request. It adapts the request and response objects, performs the routing
     * and invokes controller logic.
     *
     * @param target of the request is used for routing
     * @param baseRequest is the raw request received by the server
     * @param request is the servlet request use for providing a HTTP request
     * view
     * @param response is the servlet response used for constructing HTTP
     * response
     * @throws IOException is an input or output exception occurs
     * @throws ServletException if an exception occurs that interrupts the
     * handlers operation
     */
    @Override
    public void handle(
            String target,
            Request baseRequest,
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        IHttpRequest adaptedRequest = new JettyHttpRequestAdapter(request);
        IHttpResponse adaptedResponse = new JettyHttpResponseAdapter(response);

        // TODO: implement routing to controllers and response handling here
        // mark request as handled to prevent further processing
        baseRequest.setHandled(true);
    }
}
