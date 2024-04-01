/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.apps.auth.controllers;

import cms.server.ControllerBase;
import cms.server.IHttpRequest;
import cms.server.IHttpResponse;
import cms.server.annotations.Route;
import java.util.Map;

/**
 *
 * @author kristian
 */
public class CreateNewUserController extends ControllerBase {

    @Override
    @Route(path = "/create/user/test/", method = "POST")
    public void handleRequest(IHttpRequest request, IHttpResponse response) {
        // Retrieve all headers from the request
        Map<String, String> headers = request.getAllHeaders();

        // Iterate over each header and print its name and value
        for (Map.Entry<String, String> header : headers.entrySet()) {
            System.out.println(header.getKey() + ": " + header.getValue());
        }
    }

}
