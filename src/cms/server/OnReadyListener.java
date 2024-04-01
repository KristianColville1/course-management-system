/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server;

/**
 *
 * @author kristian

 Classes that implement the OnReadyListener should invoke onReady when they
 are ready and have completed some sort functionality for further processing
 */
public interface OnReadyListener {

    /**
     * onReady method should be invoked to indicate readiness
     */
    void onReady();
}
