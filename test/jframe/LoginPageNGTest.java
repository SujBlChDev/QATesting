package jframe;

import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Mohammed Asloof
 */
public class LoginPageNGTest {
    
    public LoginPageNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        // Ensure the database connection is established before tests
        Connection con = DbConnection.getconnection();
        assertNotNull(con, "Database connection should be initialized for tests.");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // Any teardown after all tests are completed
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        // Code to run before each test
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        // Code to run after each test
    }

    /**
     * Test for valid login with username "asloof" and password "123"
     */
    @Test
public void testValidLoginWithAsloofCredentials() {
    System.out.println("Testing validLogin with username 'asloof' and password '123'");
    
    // Create an instance of LoginPage
    LoginPage instance = new LoginPage();
    
    // Set the username and password using the appropriate method
    String username = "asloof";
    String password = "123";
    instance.setTxtUser(username, password);  // Assuming setTxtUser sets the login fields
    
    // Now test the validLogin method, which does not take arguments
    boolean expResult = true;  // expected result for valid credentials
    boolean result = instance.validLogin();  // validLogin uses internal fields set by setTxtUser
    
    // Verify the result
    assertEquals(result, expResult, "The login with username 'asloof' and password '123' should be successful.");
}

    /**
     * Test the verifyLogin method functionality
     */
    @Test
    public void testVerifyLogin() {
        System.out.println("Testing verifyLogin");
        LoginPage instance = new LoginPage();
        
        // Simulate verification logic if needed
        instance.verifyLogin();
        
        // TODO: Add assertions based on what verifyLogin is expected to do
    }

    /**
     * Test for setting username and password using setTxtUser
     */
    @Test
    public void testSetTxtUser() {
        System.out.println("Testing setTxtUser");
        
        // Input values for username and password
        String username = "asloof";
        String password = "123";
        
        // Create instance of LoginPage
        LoginPage instance = new LoginPage();
        
        // Set the username and password
        instance.setTxtUser(username, password);
        
        // Optionally, verify the set values (if you have getters for username and password)
        // e.g., assertEquals(instance.getUsername(), username);
        // e.g., assertEquals(instance.getPassword(), password);
    }

    /**
     * Test for the main method of the LoginPage class
     */
    @Test
    public void testMain() {
        System.out.println("Testing main method of LoginPage");
        
        // Arguments for the main method
        String[] args = null;
        
        // Invoke the main method
        LoginPage.main(args);
        
        // TODO: Add assertions if needed
    }
}
