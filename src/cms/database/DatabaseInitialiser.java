/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.database;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author kristian
 * 
 * Responsible for initialising the database for the application.
 */
@Component
public class DatabaseInitialiser {

    // instance fields
    private final DataSource dataSource;
    private final String dbName = "cms";

    /**
     * Constructor for DatabaseInitialiser. Uses dependency injection through
     * the @autowired spring annotation.
     *
     * @param dataSource is the DataSource for the database connections
     */
    @Autowired
    public DatabaseInitialiser(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
