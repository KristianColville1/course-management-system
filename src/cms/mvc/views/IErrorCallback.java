/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cms.mvc.views;

/**
 *
 * @author kristian
 * 
 * Classes which implement this need to use the onError method and create a 
 * method of updating an error message
 */
public interface IErrorCallback {
    
    /**
     * Should do something with an error message
     * @param errorMessage 
     */
    void onError(String errorMessage);
}
