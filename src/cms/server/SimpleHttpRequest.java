/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import cms.server.utils.RequestHistory;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author kristian
 *
 * SimpleHttpRequest is an implementation of the IHttpRequest. Custom request
 * object set up.
 *
 * This class is structured such that it allows a request to be created as base
 * this is not to be confused with the server adapters. This simple HTTP request
 * is a base object that can be used to create an initial request so that it can
 * work with the adapters and the server in a server agnostic manner.
 *
 * It implements the IHttpRequest object to conform with the rest of the request
 * specific logic throughout the application
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
    private RequestHistory requestHistory;

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
        this.requestHistory = new RequestHistory();
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

    /**
     * Set the User id of the request
     *
     * @param userId to set
     */
    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the user ID in the request
     *
     * @return the user ID
     */
    @Override
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * Gets the scheme of the request for the protocol used
     *
     * @return the protocol scheme
     */
    @Override
    public String getScheme() {
        return this.scheme;
    }

    /**
     * Gets the server name which is the host / IP address
     *
     * @return the server name
     */
    @Override
    public String getServerName() {
        return this.serverName;
    }

    /**
     * Gets the server port
     *
     * @return the port number used for the server
     */
    @Override
    public int getServerPort() {
        return this.serverPort;
    }

    /**
     * Gets the request URI
     *
     * @return request URI as path
     */
    @Override
    public String getRequestURI() {
        return this.path;
    }

    /**
     * Gets the request URL by building it from the scheme, host + port & path
     *
     * @return request URL
     */
    @Override
    public String getRequestURL() {
        return this.scheme + "://" + this.serverName + ":" + this.serverPort + this.path;
    }

    /**
     * Adds a header to the request
     *
     * @param name of the header
     * @param value to attach to the header
     */
    public void addHeader(String name, String value) {
        headers.put(name, value);
    }

    /**
     * Adds parameters to the request
     *
     * @param parameters
     */
    public void setParameters(Map<String, String[]> parameters) {
        this.parameters = parameters;
    }

    /**
     * Sets the request history of the request.
     *
     * @param requestHistory the request history to set
     */
    public void setRequestHistory(RequestHistory requestHistory) {
        this.requestHistory = requestHistory;
    }

    /**
     * Gets the request history of the request.
     *
     * @return the request history
     */
    @Override
    public RequestHistory getRequestHistory() {
        return requestHistory;
    }
}
