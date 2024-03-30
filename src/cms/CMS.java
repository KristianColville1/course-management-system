/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cms;

import cms.core.AppInitialiser;

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
        AppInitialiser app = new AppInitialiser();
        app.startServices();

    }

}
