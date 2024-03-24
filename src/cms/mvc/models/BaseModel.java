/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.mvc.models;

import cms.mvc.annotations.Table;
import cms.mvc.annotations.Column;
import cms.mvc.annotations.ForeignKey;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kristian
 *
 * Base Model for the individual tables in the database, abstracts out all of
 * the generation operations needed to create a table using the custom
 * annotations.
 */
public abstract class BaseModel {

    /**
     * Static method responsible for skimming through each model that extends
     * this abstract BaseModel and checks for the custom MVC annotations.
     *
     * Uses the annotations to build out the table create statement for each
     * table.
     *
     * @param clazz is the class to build the table statement for
     * @return a SQL CREATE TABLE statement as a String
     */
    public static String generateCreateTableStatement(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException(
                    "The class " + clazz.getSimpleName() + " does not exist");
        }

        Table tableAnnotation = clazz.getAnnotation(Table.class);
        String tableName = tableAnnotation.name(); // we get the name of table

        List<String> columns = new ArrayList<>(); // for storing column names

        for (Field field : clazz.getDeclaredFields()) { // instance fields
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                // TODO: get column definition 
            }
            if (field.isAnnotationPresent(ForeignKey.class)) {
                ForeignKey foreignKey = field.getAnnotation(ForeignKey.class);
                // TODO: get the foreign key definition
            }
        }

        // combine the column definitions
        // TODO: the constraints if any also
        String columnSQL = String.join(", ", columns);
        return String.format(
                "CREATE TABLE %s (%s);", tableName, columnSQL);
    }
}
