/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package jframe;

import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author sujairibrahim
 */
public class ViewAllRecordNGTest {
    
    public ViewAllRecordNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        Connection con = DbConnection.getconnection();
        assertNotNull(con, "Database connection should be initialized for tests.");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getIssueDetailsToTable method, of class ViewAllRecord.
     */
    @Test
    public void testGetIssueDetailsToTable() {
        System.out.println("getIssueDetailsToTable");
        ViewAllRecord instance = new ViewAllRecord();
        instance.getIssueDetailsToTable();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of clearTableDetails method, of class ViewAllRecord.
     */
    @Test
    public void testClearTableDetails() {
        System.out.println("clearTableDetails");
        ViewAllRecord instance = new ViewAllRecord();
        instance.clearTableDetails();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of main method, of class ViewAllRecord.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ViewAllRecord.main(args);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
