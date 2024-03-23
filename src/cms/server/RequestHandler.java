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
 * Determines the appropriate controller to handle the request.
 * Invokes the controller with the abstract request and response object.
 * Ensures that the processed response is sent back to the client.
 */
public class RequestHandler {
    
}
