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
}
