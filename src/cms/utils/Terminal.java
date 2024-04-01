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

    // ANSI escape codes for colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_MAGENTA = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";

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
    public static String addDashHeader() {
        String dashes = "";
        for (int str = 0; str < 22; str++) {
            dashes += ">-<";
        }
        return dashes;
    }

    /**
     * Dynamically modifies the string used in an output to the terminal by
     * changing its color.
     *
     * @param message the message to modify
     * @param colorCode the ANSI color code to apply to the message
     * @return the colored message string
     */
    public static String colorText(String message, String colorCode) {
        return colorCode + message + ANSI_RESET;
    }
    
    public static void printColorText(String message, String colorCode){
        System.out.println(colorCode + message + ANSI_RESET);
    }
}
