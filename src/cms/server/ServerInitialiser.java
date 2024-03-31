package cms.server;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import org.eclipse.jetty.server.Server;

/**
 *
 * @author kristian
 *
 * Responsible for initializing the application server instance
 */
public class ServerInitialiser {

    // instance fields
    private int port;
    private Server server;

    /**
     * Default Constructor for ServerInitialiser
     *
     * - Sets up server dependencies through dependency injection.
     *
     * - The port number is used to determine on which network port the server
     * will listen for incoming HTTP requests.
     *
     * @param port is the number of the port that the server will listen for
     * incoming connections
     */
    public ServerInitialiser(int port) {
        this.port = port;
    }

    /**
     * Starts the Jetty server.
     *
     * Initializes the server if it has not been already and sets up the handler
     * for processing HTTP requests.
     */
    public void start() {
        if (this.server == null) {
            this.server = new Server(this.port); // server config
            server.setHandler(new RequestHandler()); // ready for requests
        }

        try {
            this.server.start();
            this.server.join();
        } catch (Exception e) {
            System.out.println(new ServerStartException().getMessage());
        }
    }

    /**
     * Stops the Jetty server.
     *
     * Responsible for turning off the server. Tries to turn it off gracefully.
     */
    public void stop() {
        if (this.server != null) {
            try {
                this.server.stop();
            } catch (Exception e) {
                System.out.println(new ServerStopException().getMessage());
            }
        }
    }

    /**
     * Gets the real port number
     */
    public int getRealPortNumber() {
        return server.getConnectors()[0].getLocalPort();
    }
}
