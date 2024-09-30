/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package jframe.student;

import java.sql.Connection;
import jframe.DbConnection;
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
public class StudentReturnedDetailsNGTest {
    
    public StudentReturnedDetailsNGTest() {
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
     * Test of noOfPending method, of class StudentReturnedDetails.
     */
    @Test
    public void testNoOfPending() {
        System.out.println("noOfPending");
        StudentReturnedDetails instance = new StudentReturnedDetails();
        instance.noOfPending();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of noOfReturned method, of class StudentReturnedDetails.
     */
    @Test
    public void testNoOfReturned() {
        System.out.println("noOfReturned");
        StudentReturnedDetails instance = new StudentReturnedDetails();
        instance.noOfReturned();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSession method, of class StudentReturnedDetails.
     */
    @Test
    public void testCreateSession() {
        System.out.println("createSession");
        StudentReturnedDetails instance = new StudentReturnedDetails();
        instance.createSession();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getIssueDetailsToTable method, of class StudentReturnedDetails.
     */
    @Test
    public void testGetIssueDetailsToTable() {
        System.out.println("getIssueDetailsToTable");
        StudentReturnedDetails instance = new StudentReturnedDetails();
        instance.getIssueDetailsToTable();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of clearTableDetails method, of class StudentReturnedDetails.
     */
    @Test
    public void testClearTableDetails() {
        System.out.println("clearTableDetails");
        StudentReturnedDetails instance = new StudentReturnedDetails();
        instance.clearTableDetails();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class StudentReturnedDetails.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        StudentReturnedDetails.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
