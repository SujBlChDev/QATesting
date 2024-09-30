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
public class ManageBookNGTest {
    
    public ManageBookNGTest() {
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
     * Test of getBookDetailsToTable method, of class ManageBook.
     */
    @Test
    public void testGetBookDetailsToTable() {
        System.out.println("getBookDetailsToTable");
        ManageBook instance = new ManageBook();
        instance.getBookDetailsToTable();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of clearTableDetails method, of class ManageBook.
     */
    @Test
    public void testClearTableDetails() {
        System.out.println("clearTableDetails");
        ManageBook instance = new ManageBook();
        instance.clearTableDetails();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addBookDetails method, of class ManageBook.
     */
    @Test
    public void testAddBookDetails() {
        System.out.println("addBookDetails");
        ManageBook instance = new ManageBook();
        boolean expResult = false;
        boolean result = instance.addBookDetails();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of updateBookDetails method, of class ManageBook.
     */
    @Test
    public void testUpdateBookDetails() {
        System.out.println("updateBookDetails");
        ManageBook instance = new ManageBook();
        boolean expResult = false;
        boolean result = instance.updateBookDetails();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of deleteBookDetails method, of class ManageBook.
     */
    @Test
    public void testDeleteBookDetails() {
        System.out.println("deleteBookDetails");
        ManageBook instance = new ManageBook();
        boolean expResult = false;
        boolean result = instance.deleteBookDetails();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of emptyText method, of class ManageBook.
     */
    @Test
    public void testEmptyText() {
        System.out.println("emptyText");
        ManageBook instance = new ManageBook();
        instance.emptyText();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class ManageBook.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ManageBook.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
