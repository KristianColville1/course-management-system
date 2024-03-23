/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

/**
 *
 * @author kristian
 *
 * The DBConnector class is designed to establish a connection to the database.
 * It establishes a connection using the details from the env.properties file.
 *
 * This class can be extended or used by other classes for performing specific
 * database operations, ensuring that all interactions with the database are
 * routed through a single connection mechanism.
 */

@Configuration
@PropertySource("classpath:env.properties")
public class DBConnector {

    // instance fields
    @Value("${database.host}")
    private String dbHost;

    @Value("${database.user}")
    private String user;

    @Value("${database.password}")
    private String password;

    /**
     * Creates a DataSource bean that manages the database connection.
     *
     * Uses the properties from the env.properties file.
     *
     * The DataSource is a factory for connections to the physical data source
     * that this class represents. The created DataSource will pool the
     * connections and reuse them.
     *
     * @return a configured DataSource object ready for use.
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(dbHost);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}
