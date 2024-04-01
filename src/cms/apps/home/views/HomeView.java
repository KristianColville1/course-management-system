/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.apps.home.views;

import cms.mvc.views.BaseView;
import cms.server.IHttpRequest;
import cms.server.IHttpResponse;
import cms.utils.Terminal;

/**
 *
 * @author kristian
 */
public class HomeView extends BaseView {

    /**
     * Constructor for HomeView calls the super constructor to set up the base
     * view instances and settings for views.
     *
     * Makes the request and response available throughout the class for use as
     * needed.
     *
     * @param request is the IHttpRequest object
     * @param response is the IHttpResponse object
     */
    public HomeView(IHttpRequest request, IHttpResponse response) {
        super(request, response);
    }

    /**
     * Sets up the available options for the home view
     */
    @Override
    protected void buildOptionsMap() {
        addOptionForView(1, "/login", "GET");
        addOptionForView(2, "/help", "GET");
    }

    /**
     * Renders the options for home view.
     */
    @Override
    protected void renderOptions() {
        System.out.println(Terminal.colorText("          "
                + "Please enter a number to continue + hit Enter", Terminal.ANSI_CYAN));
        System.out.println("          (1) Login");
        System.out.println("          (2) Help");
        System.out.println("          (3) Exit App");
        System.out.println("\n");
    }
}
