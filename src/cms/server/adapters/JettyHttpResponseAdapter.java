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
 */
public class JettyHttpResponseAdapter implements IHttpResponse{

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
