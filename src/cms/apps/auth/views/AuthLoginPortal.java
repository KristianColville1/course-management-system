/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.apps.auth.views;

import cms.mvc.views.BaseView;
import cms.server.IHttpRequest;
import cms.server.IHttpResponse;

/**
 *
 * @author kristian
 */
public class AuthLoginView extends BaseView{
    private final int maxSelectionValue;
    
    public AuthLoginView(IHttpRequest request, IHttpResponse response) {
        super(request, response);
        maxSelectionValue = 3;
    }

    @Override
    protected void buildOptionsMap() {
        
    }

    @Override
    protected void renderOptions() {
        
    }

    @Override
    protected void routeToNextView(int userInput) throws IllegalArgumentException {
        
    }
    
}
