/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.utils;

import java.io.IOException;

/**
 *
 * @author kristian
 */
public class Terminal {

    /**
     * Clear the console
     */
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder(
                        "cmd",
                        "/c",
                        "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
                for (int i = 0; i < 100; i++) {
                    System.out.println();
                }
            }
        } catch (IOException | InterruptedException e) {
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
        }
    }
    
    /**
     * Outputs some header dashes to the the terminal
     */
    public static void addDashHeader(){
        String dashes = "";
        for(int str = 0; str < 22; str++){
            dashes+=">-<";
        }
        System.out.println(dashes);
    }
}
