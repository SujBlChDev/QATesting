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
public class StudentSignUpPageTest {
    
    public StudentSignUpPageTest() {
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
public void testChkUsrName_NoUser() {
    System.out.println("chkUsrName - No User Exists");
    
    // Setup test data to simulate no existing user
    // Assuming txtAdmission is a JTextField, set the text to a non-existing admission number
    StudentSignUpPage instance = new StudentSignUpPage();
    instance.txtAdmission.setText("nonExistingAdmissionNumber");

    boolean expResult = false;  // Expect false, as no such user should exist
        boolean result = instance.chkUsrName();

        assertEquals("Expected no user to be found, but user exists.", expResult, result);
    }

    @Test
    public void testChkUsrName_UserExists() {
        System.out.println("chkUsrName - User Exists");

        // Setup test data to simulate an existing user
        // Assuming txtAdmission is a JTextField, set the text to an existing admission number
        StudentSignUpPage instance = new StudentSignUpPage();
        instance.txtAdmission.setText("existingAdmissionNumber");

        boolean expResult = true;  // Expect true, as the user should exist
        boolean result = instance.chkUsrName();

        assertEquals("Expected user to be found, but no user exists.", expResult, result);
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
    
}
