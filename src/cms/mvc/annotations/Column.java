/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.mvc.annotations;

import java.lang.annotation.*;
/**
 *
 * @author kristian
 * 
 * Custom annotation for model columns in tables
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    String name(); // name of the field
    String type() default "VARCHAR(255)"; // type
    boolean primaryKey() default false; // if primary
    boolean nullable() default true; // if null
    int length() default 255; // lenght if appropriate
    String defaultValue() default ""; // default if needed
    boolean unique() default false; // if unique
}
