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
public class SessionManagerNGTest {

    public SessionManagerNGTest() {
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
     * Test of getInstance method, of class SessionManager.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        // We expect getInstance() to return a valid non-null instance.
        SessionManager result = SessionManager.getInstance();
        assertNotNull(result, "SessionManager instance should not be null");
    }

    /**
     * Test of getUsername method, of class SessionManager.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        SessionManager instance = SessionManager.getInstance();
        String expResult = null;  // Expecting null as the default value
        String result = instance.getUsername();
        assertEquals(result, expResult, "Username should be null initially");
    }

    /**
     * Test of setUsername method, of class SessionManager.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "testUser";
        SessionManager instance = SessionManager.getInstance();
        instance.setUsername(username);  // Set a new username
        assertEquals(instance.getUsername(), username, "Username should be set to 'testUser'");
    }

    /**
     * Test of setAdmissionNo method, of class SessionManager.
     */
    @Test
    public void testSetAdmissionNo() {
        System.out.println("setAdmissionNo");
        String admissionNo = "A12345";
        SessionManager instance = SessionManager.getInstance();
        instance.setAdmissionNo(admissionNo);
        assertEquals(instance.getAdmissionNo(), admissionNo, "Admission No should be set to 'A12345'");
    }

    /**
     * Test of getAdmissionNo method, of class SessionManager.
     */
    public void testGetAdmissionNo() {
        System.out.println("getAdmissionNo");
        SessionManager instance = SessionManager.getInstance();
        String expResult = null;  // Expecting null as the default value
        String result = instance.getAdmissionNo();
        assertEquals(result, expResult, "Admission No should be null initially");
    }
}
