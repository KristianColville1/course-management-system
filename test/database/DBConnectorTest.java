/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import cms.database.DBConnector;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 *
 * @author kristian
 */
public class DBConnectorTest {

    @Test
    public void testDBConnectionWorks() {
        Connection conn = null;
        try {
            conn = DBConnector.getConnection();
            assertNotNull("Connection should not be null", conn);

            DatabaseMetaData metaData = conn.getMetaData();
            assertNotNull("DatabaseMetaData should not be null, meaning connection was successful", metaData);

            String url = metaData.getURL();
            assertTrue("URL should start with jdbc:", url.startsWith("jdbc:"));
        } catch (SQLException ex) {
            // fail the test if a SQLException is thrown
            org.junit.Assert.fail("DataSource should be able to establish a connection but threw an SQLException: " + ex.getMessage());
        } finally {
            // ensure the connection is closed after the test
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println("Test succeeded: " + description.getMethodName());
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("Test FAiled: " + description.getMethodName());
        }
    };

}
