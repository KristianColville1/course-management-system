/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server.adapters;

import cms.server.IHttpRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 * @author kristian
 */
public class JettyHttpRequestAdapter implements IHttpRequest{
        private final HttpServletRequest originalRequest;

    public JettyHttpRequestAdapter(HttpServletRequest originalRequest) {
        this.originalRequest = originalRequest;
    }

    @Override
    public String getPath() {
        
    }

    @Override
    public String getMethod() {
        

    @Override
    public String getHeader(String name) {
        
    }

    @Override
    public Map<String, String[]> getParameters() {
        
    }
}
