/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package jframe;

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
public class ViewAllRecordIT {
    
    public ViewAllRecordIT() {
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
     * Test of getIssueDetailsToTable method, of class ViewAllRecord.
     */
    @Test
    public void testGetIssueDetailsToTable() {
        System.out.println("getIssueDetailsToTable");
        ViewAllRecord instance = new ViewAllRecord();
        instance.getIssueDetailsToTable();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of clearTableDetails method, of class ViewAllRecord.
     */
    @Test
    public void testClearTableDetails() {
        System.out.println("clearTableDetails");
        ViewAllRecord instance = new ViewAllRecord();
        instance.clearTableDetails();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class ViewAllRecord.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ViewAllRecord.main(args);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
