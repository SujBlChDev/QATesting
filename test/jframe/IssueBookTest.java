/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package jframe;

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
public class IssueBookTest {
    
    public IssueBookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
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
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
    }

    /**
     * Test of issueBook method, of class IssueBook.
     */
    @Test
    public void testIssueBook() {
        System.out.println("issueBook");
        IssueBook instance = new IssueBook();
        Boolean expResult = null;
        Boolean result = instance.issueBook();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
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
        fail("The test case is a prototype.");
    }
    
}
