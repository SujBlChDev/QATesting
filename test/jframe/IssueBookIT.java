/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package jframe;

import java.sql.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sujairibrahim
 */
public class IssueBookIT {
    
    public IssueBookIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        Connection con = DbConnection.getconnection();
        assertNotNull(con, "Database connection should be initialized for tests.");

    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getBookDetails method, of class IssueBook.
     */
    @Test
    public void testGetBookDetails() {
        System.out.println("getBookDetails");
        IssueBook instance = new IssueBook();
        instance.getBookDetails();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getStudentDetails method, of class IssueBook.
     */
    @Test
    public void testGetStudentDetails() {
        System.out.println("getStudentDetails");
        IssueBook instance = new IssueBook();
        instance.getStudentDetails();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of issueBook method, of class IssueBook.
     */
    @Test
    public void testIssueBook() {
        System.out.println("issueBook");
        IssueBook instance = new IssueBook();
        boolean expResult = false;
        boolean result = instance.issueBook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isAlreadyIssued method, of class IssueBook.
     */
    @Test
    public void testIsAlreadyIssued() {
        System.out.println("isAlreadyIssued");
        IssueBook instance = new IssueBook();
        Boolean expResult = null;
        Boolean result = instance.isAlreadyIssued();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of updateBookCount method, of class IssueBook.
     */
    @Test
    public void testUpdateBookCount() {
        System.out.println("updateBookCount");
        IssueBook instance = new IssueBook();
        instance.updateBookCount();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class IssueBook.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        IssueBook.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
