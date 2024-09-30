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
public class SessionManagerIT {
    
    public SessionManagerIT() {
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
     * Test of getInstance method, of class SessionManager.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        SessionManager expResult = null;
        SessionManager result = SessionManager.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getUsername method, of class SessionManager.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        SessionManager instance = null;
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setUsername method, of class SessionManager.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        SessionManager instance = null;
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setAdmissionNo method, of class SessionManager.
     */
    @Test
    public void testSetAdmissionNo() {
        System.out.println("setAdmissionNo");
        String admissionNo = "";
        SessionManager instance = null;
        instance.setAdmissionNo(admissionNo);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAdmissionNo method, of class SessionManager.
     */
    @Test
    public void testGetAdmissionNo() {
        System.out.println("getAdmissionNo");
        SessionManager instance = null;
        String expResult = "";
        String result = instance.getAdmissionNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
