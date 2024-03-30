/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server.adapters;

import cms.server.IHttpRequest;
import java.util.Enumeration;
import java.util.HashMap;
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
     *
     * @param originalRequest is the Jetty HttpServletRequest to be adapted
     */
    public JettyHttpRequestAdapter(HttpServletRequest originalRequest) {
        this.originalRequest = originalRequest;
    }

    /**
     * Retrieves the request URI.
     *
     * @return a string representation of the request URI.
     */
    @Override
    public String getPath() {
        return originalRequest.getRequestURI();
    }

    /**
     * Retrieves the HTTP method of the request.
     *
     * @return a string representation of the HTTP method
     */
    @Override
    public String getMethod() {
        return originalRequest.getMethod();
    }

    /**
     * Retrieves a header value when passed its name
     *
     * @param name is the name of the header to retrieve
     * @return the header value as a string. Returns null if header not there.
     */
    @Override
    public String getHeader(String name) {
        return originalRequest.getHeader(name);
    }

    /**
     * Retrieves all the header of a request as a map. Each key in the map is
     * the header name and the value is the header value.
     *
     * @return a map of headers and their values
     */
    @Override
    public Map<String, String> getAllHeaders() {
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = originalRequest.getHeaderNames();
        // extract a map of the headers
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, originalRequest.getHeader(headerName));
        }
        return headers;
    }

    /**
     * Retrieves all the parameters from a request as a map.
     *
     * @return map of parameters as keys and values in map
     */
    @Override
    public Map<String, String[]> getParameters() {
        return originalRequest.getParameterMap();
    }
}
