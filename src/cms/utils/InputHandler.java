/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.utils;

import java.util.Scanner;

/**
 *
 * @author kristian
 *
 * InputHandler is responsible for managing input
 */
public class InputHandler {

    // instance fields
    private final Scanner scanner;

    /**
     * Constructor for the InputHandler sets up the scanner for user input
     */
    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user for integer input and returns the input as an integer.
     * Re-prompts the user until a valid integer is entered.
     *
     * @param prompt to display to the user.
     * @return the user input as an integer.
     */
    public int promptInt(String prompt) {
        System.out.print(prompt);
        int input = Integer.parseInt(scanner.nextLine().trim());
        return input;

    }

}
