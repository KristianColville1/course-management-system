/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server.utils;

import java.util.Stack;

/**
 *
 * @author kristian
 *
 * Simple class designed to capture the request history, it will be used on a
 * view to modify the individual requests
 */
public class RequestHistory {

    // instance fields
    private Stack<String> history;

    /**
     * Default constructor sets up the stack type with string for the request
     * history
     */
    public RequestHistory() {
        history = new Stack<>();
    }

    /**
     * Adds a page to the request history
     *
     * @param page is the path which corresponds to a page
     */
    public void addPage(String page) {
        history.push(page);
    }

    /**
     * Returns the history with the last result removed, the other side using
     * this may then use the last value inserted quickly.
     *
     * @return the history with the current page removed 
     */
    public String navigateBack() {
        if (!history.isEmpty()) {
            return history.pop();
        } else {
            return null; // No previous page available
        }
    }
}
