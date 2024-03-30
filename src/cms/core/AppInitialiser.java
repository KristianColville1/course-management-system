/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.core;

import cms.database.DatabaseInitialiser;
import cms.server.ServerInitialiser;

/**
 *
 * @author kristian
 * 
 * Responsible for initialising the application and running services.
 */
public class AppInitialiser {

    /**
     * Starts the application services
     */
    public void startServices() {
        databaseInit();
        serverInit();
    }

    /**
     * Responsible for setting up the database
     */
    private void databaseInit(){
        DatabaseInitialiser db = new DatabaseInitialiser();
        db.initialise();

    }
    
    /**
     * Responsible for setting up the server.
     * 
     * Sets up server on its own thread
     */
    private void serverInit(){
        ServerInitialiser serverInitialiser = new ServerInitialiser(0);

        // Starting the server in its own thread
        Thread serverThread = new Thread(() -> {
            serverInitialiser.start();
        });

        serverThread.start();
    }
}
