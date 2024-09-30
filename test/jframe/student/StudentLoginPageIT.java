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
public class StudentLoginPageIT {
    
    public StudentLoginPageIT() {
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
     * Test of validLogin method, of class StudentLoginPage.
     */
    @Test
    public void testValidLogin() {
        System.out.println("validLogin");
        StudentLoginPage instance = new StudentLoginPage();
        boolean expResult = false;
        boolean result = instance.validLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of verifyLogin method, of class StudentLoginPage.
     */
    @Test
    public void testVerifyLogin() {
        System.out.println("verifyLogin");
        StudentLoginPage instance = new StudentLoginPage();
        instance.verifyLogin();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class StudentLoginPage.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        StudentLoginPage.main(args);
        // TODO review the generated test code and remove the default call to fail.
      
    }
    
}
