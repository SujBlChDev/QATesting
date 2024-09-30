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
public class HomePageNGTest {
    
    public HomePageNGTest() {
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
     * Test of noOfBooks method, of class HomePage.
     */
    @Test
    public void testNoOfBooks() {
        System.out.println("noOfBooks");
        HomePage instance = new HomePage();
        instance.noOfBooks();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of noOfStudents method, of class HomePage.
     */
    @Test
    public void testNoOfStudents() {
        System.out.println("noOfStudents");
        HomePage instance = new HomePage();
        instance.noOfStudents();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getStudentDetailsToTable method, of class HomePage.
     */
    @Test
    public void testGetStudentDetailsToTable() {
        System.out.println("getStudentDetailsToTable");
        HomePage instance = new HomePage();
        instance.getStudentDetailsToTable();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getBookDetailsToTable method, of class HomePage.
     */
    @Test
    public void testGetBookDetailsToTable() {
        System.out.println("getBookDetailsToTable");
        HomePage instance = new HomePage();
        instance.getBookDetailsToTable();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of main method, of class HomePage.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        HomePage.main(args);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
