/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import cms.database.DBConnector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author kristian
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConnector.class)
public class DBConnectorTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSourceConnection() {
        assertNotNull("DataSource should not be null", dataSource);

        try {
            DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
            assertNotNull("DatabaseMetaData should not be null, meaning connection was successful", metaData);

            String url = metaData.getURL();
            assertTrue("URL should start with jdbc:", url.startsWith("jdbc:"));
        } catch (SQLException ex) {
            // fail the test if a SQLException is thrown
            fail("DataSource should be able to establish a connection but threw an SQLException: " + ex.getMessage());
        }
    }

    // helper method to fail the tests in case of SQL exceptions
    private void fail(String message) {
        org.junit.Assert.fail(message);
    }
}
