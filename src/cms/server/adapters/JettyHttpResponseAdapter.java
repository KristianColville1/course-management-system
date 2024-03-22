/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server.adapters;

import cms.server.IHttpResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @Override
    public void setContentType(String type) {

    }

    @Override
    public void setStatusCode(int statusCode) {

    }

    @Override
    public void write(String data) throws IOException {

    }

}
