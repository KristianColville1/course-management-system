/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server.adapters;

import cms.server.IHttpRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 * @author kristian
 * 
 * Adapter class that wraps a Jetty HttpServletRequest and adapts it to the 
 * IHttpRequest interface. Allows the rest of the application to interact with
 * the request in a server agnostic manner.
 */
public class JettyHttpRequestAdapter implements IHttpRequest {

    // instance fields
    private final HttpServletRequest originalRequest;

    /**
     * JettyHttpRequestAdapter Constructor with the original request
     * @param originalRequest is the Jetty HttpServletRequest to be adapted
     */
    public JettyHttpRequestAdapter(HttpServletRequest originalRequest) {
        this.originalRequest = originalRequest;
    }
}
