/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.apps.home.controllers;

import cms.apps.home.views.HomeView;
import cms.mvc.views.IView;
import cms.server.ControllerBase;
import cms.server.IHttpRequest;
import cms.server.IHttpResponse;
import cms.server.annotations.Route;

/**
 *
 * @author kristian
 */
public class HomeController extends ControllerBase {

    /**
     * Handles the request for user at the start of the application. This is the
     * default view for the application.
     *
     * @param request is the IHttpRequest object
     * @param response is the IHttpResponse object
     */
    @Override
    @Route(path = "/", method = "GET")
    public void handleRequest(IHttpRequest request, IHttpResponse response) {
        IView view = new HomeView(request, response);
    }

}
