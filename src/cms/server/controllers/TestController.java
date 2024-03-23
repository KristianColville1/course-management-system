/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server.controllers;

import cms.server.ControllerBase;
import cms.server.IHttpRequest;
import cms.server.IHttpResponse;
import cms.server.annotations.Route;

/**
 * Simple test of using an API REST endpoint Controller in the application.
 * Pinging this endpoint will output the result we expect.
 *
 * By building the application as web micro service that could be integrated
 * with existing web infrastructure we can separate packages more effectively
 * for the features required and hot swap these component packages with ease.
 *
 * The design is highly flexible for an array of different web architectures.
 *
 * @author kristian
 */
public class TestController extends ControllerBase {

    @Route(path = "/test", method = "GET")
    public void handleRequest(IHttpRequest request, IHttpResponse response) {
        System.out.println("Here");
    }
}
