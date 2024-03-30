/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kristian
 *
 * SimpleHttpRequest is an implementation of the IHttpRequest. Custom request
 * object set up.
 */
public class SimpleHttpRequest implements IHttpRequest {

    // instance fields to store request details
    private final String scheme;
    private final String serverName;
    private final int serverPort;
    private final String method;
    private final String path;
    private final Map<String, String> headers = new HashMap<>();
    private Map<String, String[]> parameters;
    private Integer userId;

    /**
     * Constructor for SimpleHttpRequest sets up the request object with the
     * values for a request object.
     *
     * @param scheme is the protocol used in the request
     * @param serverName is the host or IP address
     * @param serverPort is the port the request is on
     * @param method is the type of request
     * @param path of the request
     */
    public SimpleHttpRequest(
            String scheme,
            String serverName,
            int serverPort,
            String method,
            String path) {
        this.scheme = scheme;
        this.serverName = serverName;
        this.serverPort = serverPort;
        this.method = method;
        this.path = path;
    }

    /**
     * Get the request path
     *
     * @return the request path
     */
    @Override
    public String getPath() {
        return this.path;
    }

    /**
     * Get the request method
     *
     * @return the request method
     */
    @Override
    public String getMethod() {
        return this.method;
    }

    /**
     * Get the a header from the request using the header name
     *
     * @param name of the header to get
     * @return the header
     */
    @Override
    public String getHeader(String name) {
        return headers.get(name);
    }

    /**
     * Get all of the headers
     *
     * @return all of the headers
     */
    @Override
    public Map<String, String> getAllHeaders() {
        return headers;
    }

    /**
     * Get all the parameters in the request
     *
     * @return all of the parameters
     */
    @Override
    public Map<String, String[]> getParameters() {
        return parameters;
    }

}
