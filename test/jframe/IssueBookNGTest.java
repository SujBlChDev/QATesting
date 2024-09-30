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
public class IssueBookNGTest {

    public IssueBookNGTest() {
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
        assertEquals(result, expResult);
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
        assertEquals(result, expResult);
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
