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
 * Concrete classes which extend this BaseView class should carry out behaviour
 * defined here in a structured and predictable way.
 */
public abstract class BaseView implements IView {

    /**
     * Implementation for the IView, child classes will use this on render to
     * perform the logic views should carry out in a structured and predictable
     * way.
     *
     * When called in child classes it will automatically call methods required
     * in the order they are needed.
     *
     * @param request is the IHttpRequest object
     * @param response is the IHttpResponse object
     */
    @Override
    public void render(IHttpRequest request, IHttpResponse response) {
        renderContent(request, response);
        renderOptions(request, response);
        processInput(request, response);
    }

    /**
     * Render the content
     *
     * @param request is the IHttpRequest object
     * @param response is the IHttpResponse object
     */
    protected abstract void renderContent(IHttpRequest request, IHttpResponse response);

    /**
     * Render the options to the user
     *
     * @param request is the IHttpRequest object
     * @param response is the IHttpResponse object
     */
    protected abstract void renderOptions(IHttpRequest request, IHttpResponse response);

    /**
     * Process input by the user
     *
     * @param request is the IHttpRequest object
     * @param response is the IHttpResponse object
     */
    protected abstract void processInput(IHttpRequest request, IHttpResponse response);
}
