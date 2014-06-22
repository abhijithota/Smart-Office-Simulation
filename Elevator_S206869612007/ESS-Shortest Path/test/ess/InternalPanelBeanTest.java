/*
 * InternalPanelBeanTest.java
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
public class InternalPanelBeanTest extends TestCase {
    
    public InternalPanelBeanTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(InternalPanelBeanTest.class);
        
        return suite;
    }

     /**
      * Test of addMouseListener method, of class ess.InternalPanelBean.
     */
    public void testAddMouseListener() {
        System.out.println("addMouseListener");
        
        java.awt.event.MouseListener listener = null;
        InternalPanelBean instance = new InternalPanelBean();
        try {
        instance.addMouseListener(listener);
        	System.out.println("Test of addMouseListener method, of class ess.InternalPanelBean : [ Pass ]");
        }
        catch(Exception ex) {
        	System.out.println("Test of addMouseListener method, of class ess.InternalPanelBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of removeMouseListener method, of class ess.InternalPanelBean.
     */
    public void testRemoveMouseListener() {
        System.out.println("removeMouseListener");
        
        java.awt.event.MouseListener listener = null;
        InternalPanelBean instance = new InternalPanelBean();
        try {
        	instance.removeMouseListener(listener);
        	System.out.println("Test of removeMouseListener method, of class ess.InternalPanelBean : [ Pass ]");
        }
        catch(Exception ex) {
        	System.out.println("Test of removeMouseListener method, of class ess.InternalPanelBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }
    
}
