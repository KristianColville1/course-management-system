/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.database.annotations;

import java.lang.annotation.*;

/**
 *
 * @author kristian
 *
 * Custom annotation for table models - used to identify tables in their
 * packages and build them if they don't exist in the database.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Model {

}
