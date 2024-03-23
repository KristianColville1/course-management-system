/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.server.annotations;
import java.lang.annotation.*;
/**
 *
 * @author kristian
 * 
 * Custom Annotation for specifying routes on top of controller methods for
 * different logic.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Route {
    String path(); // the path of the request
    String method(); // the method type of the request
}
