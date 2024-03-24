/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cms;

import cms.database.DatabaseInitialiser;
import cms.server.ServerInitialiser;

/**
 * @author kristian colville
 * @student sba23246
 * @github https://github.com/KristianColville1/course-management-system
 */
public class CMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseInitialiser db = new DatabaseInitialiser();
        db.initialise();
//        ServerInitialiser serverInitialiser = new ServerInitialiser(8080);
//
//        // Starting the server in its own thread
//        Thread serverThread = new Thread(() -> {
//            serverInitialiser.start();
//        });
//        serverThread.start();
//
//        Thread otherThread = new Thread(() -> {
//            System.out.println("I have started a separate thread");
//        });
//        otherThread.start();

    }

}
