/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.mvc.views;

import cms.server.IHttpRequest;
import cms.server.IHttpResponse;
import cms.server.InternalRequestHandler;
import cms.utils.InputHandler;
import cms.utils.Terminal;
import com.github.lalyos.jfiglet.FigletFont;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kristian
 *
 * Concrete classes which extend this BaseView class should carry out behaviour
 * defined here in a structured and predictable way.
 */
public abstract class BaseView implements IView, IErrorCallback {

    // Base instance fields
    protected IHttpRequest request;
    protected IHttpResponse response;
    protected Map<Integer, List<Map<String, String>>> options;
    protected String errorMessage;
    protected InputHandler inputHandler;
    protected int maxSelection;

    /**
     * Default Constructor for all views
     *
     * Using dependency injection sets the request and response for the view.
     * Sets up the options map
     *
     * @param request is the IHttpRequest object
     * @param response is the IHttpResponse object
     */
    public BaseView(IHttpRequest request, IHttpResponse response) {
        this.request = request;
        this.response = response;
        this.inputHandler = new InputHandler();
        this.inputHandler.setErrorCallback(this::onError);
        errorMessage = null;
    }

    /**
     * Adds the default options for all views
     */
    protected void addDefaultOptionsForView() {
        // set up options hashmap and the exit view
        options = new HashMap<>();
        Map<String, String> detailsMap = new HashMap<>();
        detailsMap.put("scheme", request.getScheme());
        detailsMap.put("serverName", request.getServerName());
        detailsMap.put("serverPort", Integer.toString(request.getServerPort()));
        detailsMap.put("method", "GET");
        detailsMap.put("path", "/exit/app");

        // add the default exit view
        List<Map<String, String>> detailsList = new ArrayList<>();
        detailsList.add(detailsMap);
        options.put(0, detailsList);
    }

    /**
     * Builds an option data structure for the view
     *
     * @param optionNum is the key for map
     * @param method is the request type
     * @param path is the path to go to for the option
     */
    protected void addOptionForView(int optionNum, String method, String path) {
        // builds the data structure consistently for the options
        Map<String, String> detailsMap = new HashMap<>();
        detailsMap.put("scheme", request.getScheme());
        detailsMap.put("serverName", request.getServerName());
        detailsMap.put("serverPort", Integer.toString(request.getServerPort()));
        detailsMap.put("method", method);
        detailsMap.put("path", path);

        // add the default exit view
        List<Map<String, String>> detailsList = new ArrayList<>();
        detailsList.add(detailsMap);
        options.put(optionNum, detailsList);
    }

    /**
     * Gets the option selected by the user to help sort for next view
     *
     * @param option selected by the user
     * @return the option selected or return null
     */
    protected Map<String, String> getOptionSelected(int option) {
        List<Map<String, String>> routes = options.get(option);
        if (routes != null && !routes.isEmpty()) {
            return routes.get(option);
        }
        return null;
    }

    /**
     * Implementation for the IView, child classes will use this on render to
     * perform the logic views should carry out in a structured and predictable
     * way.
     *
     * When called in child classes it will automatically call methods required
     * in the order they are needed.
     */
    @Override
    public void render() {
        Terminal.clearConsole();
        renderHeaderContent();
        addDefaultOptionsForView();
        renderOptions();
        buildOptionsMap();
    }

    /**
     * Responsible for rendering the header content
     */
    protected void renderHeaderContent() {
        try {
            Terminal.printAppHeader();
            System.out.println(
                    FigletFont.convertOneLine("           CMS  "));
            Terminal.printColorText("                    "
                    + "© Course Management System 2024",
                    Terminal.ANSI_YELLOW);
            Terminal.printAppHeader();
            displayErrorMessageOrNewLines();
            
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    /**
     * Abstract method for building the options map
     */
    protected abstract void buildOptionsMap();

    /**
     * Abstract method for rendering the options to the user for selection
     *
     */
    protected abstract void renderOptions();

    /**
     * Displays an error message for feedback to the user or just renders empty
     * lines for spacing and formatting of the view
     */
    protected void displayErrorMessageOrNewLines() {
        // display an error if re-rendered on error
        if (errorMessage != null) {
            System.out.println(errorMessage);
            errorMessage = null;
        } else {
            System.out.println("\n\n");
        }
    }

    /**
     * Routing user to the next view
     */
    protected void routeToNextView(int userInput) {
        Map<String, String> optionSelected = getOptionSelected(userInput);
        InternalRequestHandler.sendRequest(request,
                optionSelected.get("path"),
                optionSelected.get("method"));
    }

    /**
     * On error re-render the view and update the error message
     * @param errorMessage 
     */
    @Override
    public void onError(String errorMessage) {
        this.errorMessage = errorMessage;
        render(); // re-render the view with the error message
    }
}
