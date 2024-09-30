/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package jframe;

import java.sql.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sujairibrahim
 */
public class LoginPageIT {
    
    public LoginPageIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        Connection con = DbConnection.getconnection();
        assertNotNull(con, "Database connection should be initialized for tests.");

    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of validLogin method, of class LoginPage.
     */
    @Test
    public void testValidLogin() {
        System.out.println("validLogin");
        LoginPage instance = new LoginPage();
        boolean expResult = false;
        boolean result = instance.validLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of verifyLogin method, of class LoginPage.
     */
    @Test
    public void testVerifyLogin() {
        System.out.println("verifyLogin");
        LoginPage instance = new LoginPage();
        instance.verifyLogin();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setTxtUser method, of class LoginPage.
     */
    @Test
    public void testSetTxtUser() {
        System.out.println("setTxtUser");
        String name = "";
        String pass = "";
        LoginPage instance = new LoginPage();
        instance.setTxtUser(name, pass);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of main method, of class LoginPage.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        LoginPage.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
