/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.apps.auth.controllers;

import cms.apps.auth.views.AuthLoginPortal;
import cms.mvc.views.IView;
import cms.server.ControllerBase;
import cms.server.IHttpRequest;
import cms.server.IHttpResponse;
import cms.server.annotations.Route;

/**
 *
 * @author kristian
 */
public class AuthController extends ControllerBase{

    @Override
    @Route(path="/login", method="GET")
    public void handleRequest(IHttpRequest request, IHttpResponse response) {
        System.out.println("I am here in the auth controller");
        IView view = new AuthLoginPortal(request, response);
        view.render();
    }
    
}
