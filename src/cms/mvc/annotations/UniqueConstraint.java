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
 * Custom annotation for unique constraints on the models
 */
public @interface UniqueConstraint {
    String name() default "";
    String[] columnNames(); // the constraints
}
