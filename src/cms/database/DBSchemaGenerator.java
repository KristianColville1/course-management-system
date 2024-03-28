/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.database;

import cms.mvc.annotations.Model;
import cms.mvc.models.BaseModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.reflections.Reflections;
import java.util.Set;

/**
 *
 * @author kristian
 *
 * Responsible for generating the database schema if they do not exist. Builds
 * the tables for the database using reflection and the custom MVC annotations.
 */
public class DBSchemaGenerator {

    /**
     * Generates the database schema based on the annotated model classes. It
     * scans the specified package for classes annotated with @Model, generates
     * SQL CREATE TABLE statements, and executes them against the database.
     */
    public static void generateSchema(Connection connection, String dbName) {
        // Using Reflections to scan for classes annotated with @Model
        Reflections reflections = new Reflections("cms.apps");
        Set<Class<?>> modelClasses = reflections.getTypesAnnotatedWith(Model.class);

        for (Class<?> clazz : modelClasses) {
            String createTableSQL = BaseModel.generateCreateTableStatement(clazz, dbName);
            try (Statement stmt = connection.createStatement()) {
                stmt.execute(createTableSQL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
