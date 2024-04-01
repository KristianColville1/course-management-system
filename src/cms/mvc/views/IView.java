/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.mvc.views;

import cms.server.IHttpRequest;
import cms.server.IHttpResponse;
/**
 *
 * @author kristian
 * 
 * Interface for MVC framework views. Views should implement this interface
 * as the standard way to operate.
 */
public interface IView {
    
    /**
     * Should render a view and perform its own logic on the request & response
     */
    void render();
}
