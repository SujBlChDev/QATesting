/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package jframe;

import java.sql.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sujairibrahim
 */
import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

public class DbConnectionIT {

    @Test
    public void testGetconnection() {
        System.out.println("getconnection");
        
        // Call the method you are testing
        Connection result = DbConnection.getconnection();
        
        // Assert that the result is not null (connection should be successful)
        assertNotNull("Connection should not be null", result);

        // Optionally, you can add checks for more specific connection properties if needed
        // For example, you could check whether the connection is valid:
        try {
            assertTrue("Connection should be valid", result.isValid(2));
        } catch (SQLException e) {
            fail("SQLException thrown during connection validation");
        }
    }
}

