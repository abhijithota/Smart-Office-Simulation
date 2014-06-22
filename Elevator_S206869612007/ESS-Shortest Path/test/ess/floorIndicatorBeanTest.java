/*
 * floorIndicatorBeanTest.java
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
public class floorIndicatorBeanTest extends TestCase {
    
    public floorIndicatorBeanTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(floorIndicatorBeanTest.class);
        
        return suite;
    }

    /**
     * Test of getCurrentFloor method, of class ess.floorIndicatorBean.
     */
    public void testGetCurrentFloor() {
        System.out.println("getCurrentFloor");
        
        floorIndicatorBean instance = new floorIndicatorBean();
        
        int result = instance.getCurrentFloor();
        if(result < 1 || result > 4) {
        	System.out.println("Test of getCurrentFloor method, of class ess.floorIndicatorBean : [ Pass ]");
        }
        else {
        	System.out.println("Test of getCurrentFloor method, of class ess.floorIndicatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setCurrentFloor method, of class ess.floorIndicatorBean.
     */
    public void testSetCurrentFloor() {
        System.out.println("setCurrentFloor");
        
        int currentFloor = 0;
        floorIndicatorBean instance = new floorIndicatorBean();
        try {
        	instance.setCurrentFloor(currentFloor);
        	System.out.println("Test of setCurrentFloor method, of class ess.floorIndicatorBean : [ Pass ]");
        }
        catch(Exception ex) {
        	System.out.println("Test of setCurrentFloor method, of class ess.floorIndicatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setEmergency method, of class ess.floorIndicatorBean.
     */
    public void testSetEmergency() {
        System.out.println("setEmergency");
        floorIndicatorBean instance = new floorIndicatorBean();
        try {
        	instance.setEmergency();
        	System.out.println("Test of setEmergency method, of class ess.floorIndicatorBean : [ Pass ]");
        } catch(Exception ex) {
        	System.out.println("Test of setEmergency method, of class ess.floorIndicatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of SetMessage method, of class ess.floorIndicatorBean.
     */
    public void testSetMessage() {
        System.out.println("SetMessage");
        
        String msg = "";
        floorIndicatorBean instance = new floorIndicatorBean();
        
        try {
        	instance.SetMessage(msg);
        	System.out.println("Test of SetMessage method, of class ess.floorIndicatorBean : [ Pass ]");
        } catch(Exception ex) {
        	System.out.println("Test of SetMessage method, of class ess.floorIndicatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isElevatorDirection method, of class ess.floorIndicatorBean.
     */
    public void testIsElevatorDirection() {
        System.out.println("isElevatorDirection");
        
        floorIndicatorBean instance = new floorIndicatorBean();
        
        boolean expResult1 = true;  // Up Direction
        boolean expResult2 = false;	// Down Direction
        boolean result = instance.isElevatorDirection();
        if (result==expResult1 || result==expResult2) {
        	System.out.println("Test of isElevatorDirection method, of class ess.floorIndicatorBean : [ Pass ]");
		}
        else {
        	System.out.println("Test of isElevatorDirection method, of class ess.floorIndicatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setElevatorDirection method, of class ess.floorIndicatorBean.
     */
    public void testSetElevatorDirection() {
        System.out.println("setElevatorDirection");
        
        boolean elevatorDirection = true;
        floorIndicatorBean instance = new floorIndicatorBean();
        
        try {
        	instance.setElevatorDirection(elevatorDirection);
        	System.out.println("Test of setElevatorDirection method, of class ess.floorIndicatorBean : [ Pass ]");
        } catch(Exception ex) {
        	System.out.println("Test of setElevatorDirection method, of class ess.floorIndicatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }
    
}
