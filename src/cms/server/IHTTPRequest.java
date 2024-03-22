/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

/**
 *
 * @author kristian
 *
 * This interface represents an abstraction over a HTTP request. It provides
 * access to the common elements of a HTTP request such as headers, parameters
 * and the request path. This is all done in a server agnostic manner.
 */
public interface IHTTPRequest {

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
}
