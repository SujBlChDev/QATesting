/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package jframe.student;

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
public class StudentSignUpPageIT {
    
    public StudentSignUpPageIT() {
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
     * Test of insertSignUpDetails method, of class StudentSignUpPage.
     */
    @Test
    public void testInsertSignUpDetails() {
        System.out.println("insertSignUpDetails");
        StudentSignUpPage instance = new StudentSignUpPage();
        instance.insertSignUpDetails();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of validSignup method, of class StudentSignUpPage.
     */
    @Test
    public void testValidSignup() {
        System.out.println("validSignup");
        StudentSignUpPage instance = new StudentSignUpPage();
        boolean expResult = false;
        boolean result = instance.validSignup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   
    }

    /**
     * Test of chkUsrName method, of class StudentSignUpPage.
     */
    @Test
    public void testChkUsrName() {
        System.out.println("chkUsrName");
        StudentSignUpPage instance = new StudentSignUpPage();
        boolean expResult = false;
        boolean result = instance.chkUsrName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of main method, of class StudentSignUpPage.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        StudentSignUpPage.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setTxtUser method, of class StudentSignUpPage.
     */
    @Test
    public void testSetTxtUser() {
        System.out.println("setTxtUser");
        String name = "";
        String pass = "";
        String index = "";
        String number = "";
        StudentSignUpPage instance = new StudentSignUpPage();
        instance.setTxtUser(name, pass, index, number);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
