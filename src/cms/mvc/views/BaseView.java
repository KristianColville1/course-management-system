/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.mvc.views;

import cms.server.IHttpRequest;
import cms.server.IHttpResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kristian
 *
 * Concrete classes which extend this BaseView class should carry out behaviour
 * defined here in a structured and predictable way.
 */
public abstract class BaseView implements IView {

    // Base instance fields
    protected IHttpRequest request;
    protected IHttpResponse response;
    protected Map<Integer, String[]> options;

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
        options = new HashMap<>();
        addDefaultOptionsForView();
        render();
    }

    /**
     * Adds the default options for all views
     */
    protected void addDefaultOptionsForView() {

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
        renderContent();
        renderOptions();
        processInput();
    }

    /**
     * Abstract method for rendering the content such as headers
     */
    protected abstract void renderContent();

    /**
     * Abstract method for rendering the options to the user for selection
     *
     */
    protected abstract void renderOptions();

    /**
     * Abstract method for processing the input received for a particular view
     */
    protected abstract void processInput();
}
