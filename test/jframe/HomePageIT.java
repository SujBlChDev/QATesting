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
public class HomePageIT {
    
    public HomePageIT() {
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
