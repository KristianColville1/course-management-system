package cms.server;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author kristian
 *
 * Responsible for initializing the application server instance
 */
public class ServerInitialiser {

    // instance fields
    private int port;

    /**
     * Default Constructor for ServerInitialiser 
     * 
     * - Sets up server dependencies
     * through dependency injection. 
     * 
     * - The port number is used to determine on
     * which network port the server will listen for incoming HTTP requests.
     *
     * @param port is the number of the port that the server will listen for
     * incoming connections
     */
    public ServerInitialiser(int port) {
        this.port = port;
    }
}
