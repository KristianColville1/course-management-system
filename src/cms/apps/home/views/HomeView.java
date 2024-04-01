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
import java.util.InputMismatchException;

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
     * Renders the heading content
     */
    @Override
    protected void renderContent() {
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
            displayErrorMessageOrNewLines();
        } catch (IOException e) {
            System.out.println(e);
        }

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
        System.out.println("          "
                + "Please enter a number to continue + hit Enter");
        System.out.println("          (1) Login");
        System.out.println("          (2) Help");
        System.out.println("          (3) Exit App");
        System.out.println("\n");
    }

    /**
     * Handles the input from the user and is responsible for further routing
     * through the application.
     */
    @Override
    protected void processInput() {
        try {
            System.out.println("Enter your input: ");
            int input = userInput.nextInt();
            userInput.nextLine();
            routeToNextView(3, input, 3);
        } catch (InputMismatchException e) {
            userInput.nextLine(); // clear the invalid input 
            errorMessage = Terminal.textDanger("Numbers only please. You must enter a number to continue\n\n");
        } catch (IllegalArgumentException e) {
            errorMessage = Terminal.textDanger("Max option exceeded try again.\n\n");
        } finally {
            render(); // re-render the view with error message
        }
    }

}
