/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

/**
 *
 * @author kristian
 *
 * SimpleHttpRequest is an implementation of the IHttpRequest. Custom request
 * object set up.
 */
public class SimpleHttpRequest implements IHttpRequest {

    // instance fields to store request details
    private String scheme;
    private String serverName;
    private int serverPort;
    private String method;
    private String path;
}
