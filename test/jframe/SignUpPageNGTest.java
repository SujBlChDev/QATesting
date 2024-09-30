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
public class SignUpPageNGTest {
    
    public SignUpPageNGTest() {
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
     * Test of insertSignUpDetails method, of class SignUpPage.
     */
    @Test
    public void testInsertSignUpDetails() {
        System.out.println("insertSignUpDetails");
        SignUpPage instance = new SignUpPage();
        instance.insertSignUpDetails();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of validSignup method, of class SignUpPage.
     */
    @Test
    public void testValidSignup() {
        System.out.println("validSignup");
        SignUpPage instance = new SignUpPage();
        boolean expResult = false;
        boolean result = instance.validSignup();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of chkUsrName method, of class SignUpPage.
     */
    @Test
    public void testChkUsrName() {
        System.out.println("chkUsrName");
        SignUpPage instance = new SignUpPage();
        boolean expResult = false;
        boolean result = instance.chkUsrName();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class SignUpPage.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        SignUpPage.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
