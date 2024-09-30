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
public class StudentBorrowDetailsNGTest {
    
    public StudentBorrowDetailsNGTest() {
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
     * Test of noOfPending method, of class StudentBorrowDetails.
     */
    @Test
    public void testNoOfPending() {
        System.out.println("noOfPending");
        StudentBorrowDetails instance = new StudentBorrowDetails();
        instance.noOfPending();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of noOfReturned method, of class StudentBorrowDetails.
     */
    @Test
    public void testNoOfReturned() {
        System.out.println("noOfReturned");
        StudentBorrowDetails instance = new StudentBorrowDetails();
        instance.noOfReturned();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of createSession method, of class StudentBorrowDetails.
     */
    @Test
    public void testCreateSession() {
        System.out.println("createSession");
        StudentBorrowDetails instance = new StudentBorrowDetails();
        instance.createSession();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getIssueDetailsToTable method, of class StudentBorrowDetails.
     */
    @Test
    public void testGetIssueDetailsToTable() {
        System.out.println("getIssueDetailsToTable");
        StudentBorrowDetails instance = new StudentBorrowDetails();
        instance.getIssueDetailsToTable();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of clearTableDetails method, of class StudentBorrowDetails.
     */
    @Test
    public void testClearTableDetails() {
        System.out.println("clearTableDetails");
        StudentBorrowDetails instance = new StudentBorrowDetails();
        instance.clearTableDetails();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class StudentBorrowDetails.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        StudentBorrowDetails.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
