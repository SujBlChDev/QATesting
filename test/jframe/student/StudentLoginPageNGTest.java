/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package jframe.student;

import java.sql.Connection;
import jframe.DbConnection;
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
public class StudentLoginPageNGTest {
    
    public StudentLoginPageNGTest() {
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
     * Test of validLogin method, of class StudentLoginPage.
     */
    @Test
    public void testValidLogin() {
        System.out.println("validLogin");
        StudentLoginPage instance = new StudentLoginPage();
        boolean expResult = false;
        boolean result = instance.validLogin();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        ;
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
