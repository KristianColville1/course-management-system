/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server.adapters;

import cms.server.IHttpResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author kristian
 *
 * Adapter class that wraps a Jetty HttpServletResponse and adapts it to the
 * IHttpResponse interface. Allows the rest of the application to interact with
 * the response in a server agnostic manner.
 */
public class JettyHttpResponseAdapter implements IHttpResponse {

    // instance fields
    private final HttpServletResponse originalResponse;

    /**
     * JettyHttpResponseAdapter Constructor with the original response
     *
     * @param originalResponse is the Jetty HttpServletResponse to be adapted
     */
    public JettyHttpResponseAdapter(HttpServletResponse originalResponse) {
        this.originalResponse = originalResponse;
    }

    /**
     * Sets the content type of the response
     *
     * @param type is the MIME type for the content returned
     */
    @Override
    public void setContentType(String type) {
        originalResponse.setContentType(type);
    }

    /**
     * Sets the HTTP status code in the response
     *
     * @param statusCode is the HTTP status code for the response
     */
    @Override
    public void setStatusCode(int statusCode) {
        originalResponse.setStatus(statusCode);
    }

    /**
     * Writes data to the response body
     *
     * @param data is the data to write to the body
     * @throws IOException if there's an input or output error
     */
    @Override
    public void write(String data) throws IOException {
        PrintWriter writer = originalResponse.getWriter();
        writer.write(data);
        writer.flush(); // ensures the data is sent to the client
    }

}
