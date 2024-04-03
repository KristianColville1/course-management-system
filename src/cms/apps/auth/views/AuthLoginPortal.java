/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.apps.auth.views;

import cms.mvc.views.BaseView;
import cms.server.IHttpRequest;
import cms.server.IHttpResponse;
import cms.utils.Terminal;

/**
 *
 * @author kristian
 *
 * Responsible for allowing the user to login or sign up for account access
 */
public class AuthLoginPortal extends BaseView {

    private final int maxSelectionValue;

    /**
     * Constructor for the Auth Login Portal sets up the view
     *
     * @param request is the IHttpRequest object
     * @param response is the IHttpResponse object
     */
    public AuthLoginPortal(IHttpRequest request, IHttpResponse response) {
        super(request, response);
        maxSelectionValue = 3;
    }

    /**
     * Builds the various options available to the user on this view
     */
    @Override
    protected void buildOptionsMap() {
        addOptionForView(1, "/signin", "GET");
        addOptionForView(2, "/signup", "GET");
        addOptionForView(3, "/help", "GET");
        addOptionForView(4, "/", "GET");
    }

    /**
     * Renders the options to the user for this view
     */
    @Override
    protected void renderOptions() {
        System.out.println(Terminal.colorText("          "
                + "Please enter a number to continue + hit Enter", Terminal.ANSI_CYAN));
        System.out.println("          (1) Sign in");
        System.out.println("          (2) Sign up");
        System.out.println("          (3) Help");
        System.out.println("          (4) <- Back");
        System.out.println("          (5) Exit App");
        System.out.println("\n");
    }
}
