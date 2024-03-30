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
    private Integer userId;

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

    /**
     * Sets the user ID of the person making the request
     *
     * @param userId to set
     */
    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the user ID of the person making the request
     *
     * @return the user ID
     */
    @Override
    public Integer getUserId() {
        return userId;
    }

    /**
     * Gets the protocol used in the request
     *
     * @return the scheme
     */
    @Override
    public String getScheme() {
        return originalRequest.getScheme();
    }

    /**
     * Gets the host or IP address that the request was made from
     *
     * @return the host or IP address
     */
    @Override
    public String getServerName() {
        return originalRequest.getServerName();
    }

    /**
     * Gets the servers port number from the request that was made
     *
     * @return the server port number from the request
     */
    @Override
    public int getServerPort() {
        return originalRequest.getServerPort();
    }
    
    /**
     * Gets the request URI from the request made 
     * @return the request URI
     */
    @Override
    public String getRequestURI(){
        return originalRequest.getRequestURI();
    }
    
    /**
     * Gets the request URL of the request made
     * @return the request URL
     */
    @Override
    public String getRequestURL(){
        // converts the StringBuffer to a string
        return originalRequest.getRequestURL().toString();
    }
}
