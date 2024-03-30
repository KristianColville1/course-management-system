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
 * Responsible for handling the authentication of requests and implements the 
 * IMiddleware interface.
 * 
 * Processes requests for authentication.
 * 
 */
public class AuthenticationMiddleware implements IMiddleware {

    @Override
    public boolean process(IHttpRequest request, IHttpResponse response) throws IOException {
        return false;
    }
    
}
