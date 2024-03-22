/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

import java.io.IOException;

/**
 *
 * @author kristian
 *
 * This interface represents an abstraction over a HTTP response. It allows for
 * setting response metadata like content type and status code as well as
 * writing any output to the response body in a server agnostic manner.
 */
public interface IHTTPResponse {

    /**
     * Sets the content type of the response.
     *
     * @param type is the MIME type of the content to be returned in the
     * response
     */
    void setContentType(String type);

    /**
     * Sets the HTTP status code of the response.
     *
     * @param statusCode is the HTTP status code
     */
    void setStatusCode(int statusCode);

    /**
     * Writes data to a response body.
     *
     * @param data is the data to write to the response body
     * @throws IOException if an input or output exception occurs
     */
    void write(String data) throws IOException;
}
