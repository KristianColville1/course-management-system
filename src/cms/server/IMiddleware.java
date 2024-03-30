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
 * Classes implementing IMiddleware should process requests and throw and
 * IOException
 */
public interface IMiddleware {

    /**
     * Process a request and throw an IOException if exception occurs
     *
     * @param request is the IHttpRequest object to process
     * @param response is the IHttpResponse object to process
     * @return true or false
     * @throws IOException if an error occurs
     */
    boolean process(IHttpRequest request, IHttpResponse response) throws IOException;
}
