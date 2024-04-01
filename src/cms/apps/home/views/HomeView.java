/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.apps.home.views;

import cms.mvc.views.BaseView;
import cms.server.IHttpRequest;
import cms.server.IHttpResponse;
import cms.utils.Terminal;
import com.github.lalyos.jfiglet.FigletFont;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author kristian
 */
public class HomeView extends BaseView {

    private Map<Integer, String> userOptions;
    /**
     * Renders the heading content
     *
     * @param request
     * @param response
     */
    @Override
    protected void renderContent(
            IHttpRequest request,
            IHttpResponse response) {
        Terminal.clearConsole();
        Terminal.addDashHeader();
        try {
            System.out.println(
                    FigletFont.convertOneLine("WELCOME"));;
            System.out.println(
                    FigletFont.convertOneLine("--CMS--"));
            System.out.println("            "
                    + "        © Course Management System 2024");
            Terminal.addDashHeader();

            System.out.println("\n\n");
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    
    
    /**
     * Renders the options for this view
     *
     * @param request
     * @param response
     */
    @Override
    protected void renderOptions(IHttpRequest request, IHttpResponse response) {
        System.out.println("          "
                + "Please enter a number to continue + hit Enter");
        System.out.println("          (1) Login");
        System.out.println("          (2) Exit App");
        System.out.println("\n");
    }

    /**
     * Handles the input from the user and is responsible for further routing
     * through the application
     *
     * @param request
     * @param response
     */
    @Override
    protected void processInput(IHttpRequest request, IHttpResponse response) {
    }
}
