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
 * Custom annotation for check constraints in SQL statement columns.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CheckConstraint {
    String name() default "";
    String condition(); 
}
