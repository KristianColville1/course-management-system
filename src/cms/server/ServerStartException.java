/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

/**
 *
 * @author kristian
 * 
 * Responsible for throwing custom exception ServerStartException when server
 * fails to start.
 */
public class ServerStartException extends Exception{
    
    /**
     * Default constructor for the ServerStartException
     */
    public ServerStartException(){
        super("Server failed to start. Check configuration and port "
                + "availablitiy please.");
    }
    
    /**
     * Constructor for the ServerStartException
     * @param cause provides more details on the exception to the user
     */
    public ServerStartException(Throwable cause){
        super("Server failed to start due to an exception. "
                + "See cause for details", cause);
    }
}
