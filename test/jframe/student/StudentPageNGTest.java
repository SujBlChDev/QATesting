/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package jframe.student;

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
public class StudentPageNGTest {
    
    public StudentPageNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
     * Test of noOfPending method, of class StudentPage.
     */
    @Test
    public void testNoOfPending() {
        System.out.println("noOfPending");
        StudentPage instance = new StudentPage();
        instance.noOfPending();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of noOfReturned method, of class StudentPage.
     */
    @Test
    public void testNoOfReturned() {
        System.out.println("noOfReturned");
        StudentPage instance = new StudentPage();
        instance.noOfReturned();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of createSession method, of class StudentPage.
     */
    @Test
    public void testCreateSession() {
        System.out.println("createSession");
        StudentPage instance = new StudentPage();
        instance.createSession();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class StudentPage.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        StudentPage.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
