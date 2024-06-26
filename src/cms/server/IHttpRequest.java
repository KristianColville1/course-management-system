/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import cms.server.utils.RequestHistory;
import java.util.Map;

/**
 *
 * @author kristian
 *
 * This interface represents an abstraction over a HTTP request. It provides
 * access to the common elements of a HTTP request such as headers, parameters
 * and the request path. This is all done in a server agnostic manner.
 */
public interface IHttpRequest {

    /**
     * Retrieves the request path.
     *
     * @return a string representing of the path the request is targeting.
     */
    String getPath();

    /**
     * Retrieves the HTTP method of the request.
     *
     * @return a string representing the HTTP method request used (POST,GET etc)
     */
    String getMethod();

    /**
     * Retrieves a single header given its name
     *
     * @param name is the header to retrieve
     * @return the header value as a string. Return null if header not found.
     */
    String getHeader(String name);

    /**
     * Retrieves all the headers of a request as a map. Each key in the map is
     * the header name and the value is the header value.
     *
     * @return a map of headers and their values.
     */
    Map<String, String> getAllHeaders();

    /**
     * Retrieves all the parameters of a request as a map. Each key in the map
     * is the parameter name and the value is an array of strings which contain
     * all the values for that parameter
     *
     * @return a map of parameters and their values
     */
    Map<String, String[]> getParameters();

    /**
     * Should set the user ID for the person making the request when they pass
     * through the auth middle ware functionality.
     *
     * @param userId to set
     */
    void setUserId(int userId);

    /**
     * Should retrieve the user ID for the person making the request
     *
     * @return the user ID of person making request
     */
    Integer getUserId();

    /**
     * Should return the scheme of the request HTTP, HTTPS etc
     *
     * @return scheme of the request
     */
    String getScheme();

    /**
     * Should return the host name or IP address
     *
     * @return localhost, 127.0.0.1 etc
     */
    String getServerName();

    /**
     * Should return the port number used in the request
     *
     * @return port number
     */
    int getServerPort();

    /**
     * Should return the content after the host and port, URI only
     *
     * @return the request URI
     */
    String getRequestURI();

    /**
     * Should return the full URL of the request
     *
     * @return the request URL in full
     */
    String getRequestURL();
    
    RequestHistory getRequestHistory();
}
