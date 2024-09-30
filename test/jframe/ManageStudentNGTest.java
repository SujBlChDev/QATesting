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
public class ManageStudentNGTest {
    
    public ManageStudentNGTest() {
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
     * Test of getStudentDetailsToTable method, of class ManageStudent.
     */
    @Test
    public void testGetStudentDetailsToTable() {
        System.out.println("getStudentDetailsToTable");
        ManageStudent instance = new ManageStudent();
        instance.getStudentDetailsToTable();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of clearTableDetails method, of class ManageStudent.
     */
    @Test
    public void testClearTableDetails() {
        System.out.println("clearTableDetails");
        ManageStudent instance = new ManageStudent();
        instance.clearTableDetails();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of validSignup method, of class ManageStudent.
     */
    @Test
    public void testValidSignup() {
        System.out.println("validSignup");
        ManageStudent instance = new ManageStudent();
        boolean expResult = false;
        boolean result = instance.validSignup();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of chkUsrName method, of class ManageStudent.
     */
    @Test
    public void testChkUsrName() {
        System.out.println("chkUsrName");
        ManageStudent instance = new ManageStudent();
        boolean expResult = false;
        boolean result = instance.chkUsrName();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addStudentDetails method, of class ManageStudent.
     */
    @Test
    public void testAddStudentDetails() {
        System.out.println("addStudentDetails");
        ManageStudent instance = new ManageStudent();
        boolean expResult = false;
        boolean result = instance.addStudentDetails();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of updateStudentDetails method, of class ManageStudent.
     */
    @Test
    public void testUpdateStudentDetails() {
        System.out.println("updateStudentDetails");
        ManageStudent instance = new ManageStudent();
        boolean expResult = false;
        boolean result = instance.updateStudentDetails();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of deleteStudentDetails method, of class ManageStudent.
     */
    @Test
    public void testDeleteStudentDetails() {
        System.out.println("deleteStudentDetails");
        ManageStudent instance = new ManageStudent();
        boolean expResult = false;
        boolean result = instance.deleteStudentDetails();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of emptyText method, of class ManageStudent.
     */
    @Test
    public void testEmptyText() {
        System.out.println("emptyText");
        ManageStudent instance = new ManageStudent();
        instance.emptyText();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class ManageStudent.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ManageStudent.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
