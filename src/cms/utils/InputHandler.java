/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.utils;

import cms.mvc.views.IErrorCallback;
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
    private IErrorCallback errorCallback;

    /**
     * Constructor for the InputHandler sets up the scanner for user input
     */
    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Sets the error callback allows us to pass the error message back up to
     * the class calling this
     *
     * @param errorCallback
     */
    public void setErrorCallback(IErrorCallback errorCallback) {
        this.errorCallback = errorCallback;
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
        return Integer.parseInt(scanner.nextLine().trim());

    }

    /**
     * Processing the input received for a particular view
     */
    public int processInputAsInteger() {
        int input = 0;
        try {
            input = promptInt("Enter your input: ");
        } catch (NumberFormatException e) {
            errorCallback.onError("\n\n" + Terminal.colorText(
                    "Invalid input. You must enter a number not letters. "
                    + "They are beside the selections below."
                    + e.getMessage(),
                    Terminal.ANSI_RED) + "\n\n");
        } catch (IllegalArgumentException e) {
            errorCallback.onError("\n\n" + Terminal.colorText(
                    "Invalid input. You must enter a number that matches the "
                    + "selections only.",
                    Terminal.ANSI_RED) + "\n\n");
        }

        return input;
    }

}
