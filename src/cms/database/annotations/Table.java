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
 * Custom annotation for model table
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {

    String name(); // table name

    UniqueConstraint[] uniqueConstraints() default {}; // incase needed
}
