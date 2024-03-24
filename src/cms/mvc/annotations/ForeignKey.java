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
 * Custom annotation for defining foreign key on table columns
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ForeignKey {

    String columnName(); // column for the foreign key

    String foreignTableName(); // the table

    String foreignColumnName(); // column name for the foreign key
}
