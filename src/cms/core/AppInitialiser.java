/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.core;

import cms.database.DatabaseInitialiser;
import cms.server.IHttpRequest;
import cms.server.InternalRequestHandler;
import cms.server.ServerInitialiser;
import cms.server.SimpleHttpRequest;

/**
 *
 * @author kristian
 *
 * Responsible for initialising the application and running services.
 */
public class AppInitialiser {

    private ServerInitialiser serverInitialiser;

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
    private void databaseInit() {
        DatabaseInitialiser db = new DatabaseInitialiser();
        db.initialise();
    }

    /**
     * Responsible for setting up the server.
     *
     * Sets up server on its own thread
     */
    private void serverInit() {

        // Starting the server in its own thread
        Thread serverThread = new Thread(() -> {
            serverInitialiser = new ServerInitialiser(0);
            serverInitialiser.setOnReadyListener(() -> startMenu());
            serverInitialiser.start();
        });

        serverThread.start();

    }

    /**
     * Sets up the initial internal routing and sets up start menu for user
     */
    private void startMenu() {
        int portToRouteTo = serverInitialiser.getRealPortNumber();
        System.out.println(portToRouteTo);
        IHttpRequest request = new SimpleHttpRequest(
                "http",
                "localhost",
                portToRouteTo,
                "GET",
                "");
        InternalRequestHandler.sendRequest(request,
                "",
                "GET");
    }
}
