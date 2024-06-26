/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.mvc.models;

import cms.database.annotations.Table;
import cms.database.annotations.Column;
import cms.database.annotations.ForeignKey;
import cms.database.annotations.CheckConstraint;
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
    public static String generateCreateTableStatement(
            Class<?> clazz, String dbName) {
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new IllegalArgumentException(
                    "The class " + clazz.getSimpleName() + " does not exist");
        }

        Table tableAnnotation = clazz.getAnnotation(Table.class);
        String tableName = tableAnnotation.name(); // we get the name of table

        List<String> columns = new ArrayList<>(); // for storing column names
        List<String> foreignKeys = new ArrayList<>(); // for storing foreign keys

        for (Field field : clazz.getDeclaredFields()) { // instance fields
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                String columnDefinition = getColumnDefinition(column);
                columns.add(columnDefinition);
            }
            if (field.isAnnotationPresent(ForeignKey.class)) {
                ForeignKey foreignKey
                        = field.getAnnotation(ForeignKey.class);
                String foreignKeyDefinition
                        = getForeignKeyDefinition(foreignKey);
                foreignKeys.add(foreignKeyDefinition);
            }
        }

        List<String> tableDefinitions = new ArrayList<>(columns);
        tableDefinitions.addAll(foreignKeys); // add to end

        // Process class-level annotations (Check Constraints)
        if (clazz.isAnnotationPresent(CheckConstraint.class)) {
            CheckConstraint checkConstraint = clazz.getAnnotation(CheckConstraint.class);
            String constraintSQL = "CONSTRAINT " + checkConstraint.name() + " CHECK (" + checkConstraint.condition() + ")";
            tableDefinitions.add(constraintSQL);
        }
        String tableSQL = String.join(", ", tableDefinitions); // build
        // returns the table statement needed to build this.
        return String.format(
                "CREATE TABLE IF NOT EXISTS %s.%s (%s);",
                dbName,
                tableName,
                tableSQL);
    }

    /**
     * Generates the column definition for the create table statement.
     *
     * Sets it up as typical SQL statement for a column.
     *
     * @param column is the annotation for the column schema
     * @return
     */
    private static String getColumnDefinition(Column column) {

        // in the order they are needed in a SQL statement
        String columnDef = column.name() + " " + column.type()
                + (column.primaryKey() ? " PRIMARY KEY" : "")
                + (column.nullable() ? "" : " NOT NULL")
                + (column.unique() ? " UNIQUE" : "")
                + (column.defaultValue().isEmpty() ? "" : " DEFAULT '" + column.defaultValue() + "'")
                + (column.autoIncrement() ? " AUTO_INCREMENT" : "");
        return columnDef;
    }

    /**
     * Generates the foreign key statement for the create table statement
     *
     * @param foreignKey is the annotation information needed to build it
     * @return a String of the foreign key statement
     */
    private static String getForeignKeyDefinition(ForeignKey foreignKey) {
        return "FOREIGN KEY ("
                + foreignKey.columnName()
                + ") REFERENCES "
                + foreignKey.foreignTableName()
                + "(" + foreignKey.foreignColumnName() + ")";
    }
}
