/*
 * elevatorAppletTest.java
 * JUnit based test
 *
 * Created on April 28, 2007, 12:59 PM
 */

package ess;

import junit.framework.*;

/**
 *
 * @author Administrator
 */
public class elevatorAppletTest extends TestCase {
    
    public elevatorAppletTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(elevatorAppletTest.class);
        
        return suite;
    }

    /**
     * Test of init method, of class ess.elevatorApplet.
     */
    public void testInit() {
        System.out.println("init");
        elevatorApplet instance = new elevatorApplet();
        try {
        	instance.init();;
        	System.out.println("Test of init method, of class ess.elevatorApplet : [ Pass ]");
        } catch(Exception ex) {
        	System.out.println("Test of init method, of class ess.elevatorApplet : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }
    
}
