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
}
