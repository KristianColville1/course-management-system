/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

/**
 *
 * @author kristian
 *
 * Responsible for the concrete implementation of the IRoute interface for
 * matching HTTP requests based on path and method, and delegating to a specific
 * controller.
 */
public class Route implements IRoute {

    // instance fields
    private String path;
    private String method;
    private ControllerBase controller;
}
