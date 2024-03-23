/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

/**
 *
 * @author kristian
 *
 * Responsible for throwing custom ServerStopException when server fails to stop
 */
public class ServerStopException extends Exception {

    /**
     * Default constructor for the ServerStopException
     */
    public ServerStopException() {
        super("Server failed to stop gracefully. "
                + "Check for active connections or ongoing processes.");
    }

    /**
     * Constructor for the ServerStopException
     *
     * @param cause provides more details on the exception to the user
     */
    public ServerStopException(Throwable cause) {
        super("Server failed to stop due to an exception. "
                + "See cause for details", cause);
    }
}
