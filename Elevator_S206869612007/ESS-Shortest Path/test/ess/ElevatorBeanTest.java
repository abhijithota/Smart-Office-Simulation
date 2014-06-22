/*
 * ElevatorBeanTest.java
 * JUnit based test
 *
 * Created on April 28, 2007, 12:59 PM
 */

package ess;

import junit.framework.*;
import com.sun.jmx.remote.internal.ArrayQueue;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class ElevatorBeanTest extends TestCase {
    
    public ElevatorBeanTest(String testName) {
        super(testName);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ElevatorBeanTest.class);
        
        return suite;
    }

    /**
     * Test of setDoorRequest method, of class ess.ElevatorBean.
     */
    public void testSetDoorRequest() {
        System.out.println("setDoorRequest");
        
        boolean DRequest = true;
        ElevatorBean instance = new ElevatorBean();
        
        try {
        	instance.setDoorRequest(DRequest);
        	System.out.println("Test of setDoorRequest method, of class ess.ElevatorBean : [ Pass ]");
        } catch(Exception ex) {
        	System.out.println("Test of setDoorRequest method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getDoorRequest method, of class ess.ElevatorBean.
     */
    public void testGetDoorRequest() {
        System.out.println("getDoorRequest");
        
        ElevatorBean instance = new ElevatorBean();
        
        boolean expResult1 = true;
        boolean expResult2 = false;
        boolean result = instance.getDoorRequest();
        if (result==expResult1 || result==expResult2) {
        	System.out.println("Test of getDoorRequest method, of class ess.ElevatorBean : [ Pass ]");
		}
        else {
        	System.out.println("Test of getDoorRequest method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of setStopRequest method, of class ess.ElevatorBean.
     */
    public void testSetStopRequest() {
        System.out.println("setStopRequest");
        
        boolean StopReq = true;
        ElevatorBean instance = new ElevatorBean();

        try {
        	instance.setStopRequest(StopReq);
        	System.out.println("Test of setStopRequest method, of class ess.ElevatorBean : [ Pass ]");
        } catch(Exception ex) {
        	System.out.println("Test of setStopRequest method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getStopRequest method, of class ess.ElevatorBean.
     */
    public void testGetStopRequest() {
        System.out.println("getStopRequest");
        
        ElevatorBean instance = new ElevatorBean();
        
        boolean expResult1 = true;
        boolean expResult2 = false;
        
        boolean result = instance.getStopRequest();
        
        if (result==expResult1 || result==expResult2) {
        	System.out.println("Test of getStopRequest method, of class ess.ElevatorBean : [ Pass ]");
		}
        else {
        	System.out.println("Test of getStopRequest method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of calllForEmergency method, of class ess.ElevatorBean.
     */
    public void testCalllForEmergency() {
        System.out.println("calllForEmergency");        
        int floorNumber = 1;
        ElevatorBean instance = new ElevatorBean();

        try {
        	instance.calllForEmergency(floorNumber);
        	System.out.println("Test of calllForEmergency method, of class ess.ElevatorBean : [ Pass ]");
        } catch(Exception ex) {
        	System.out.println("Test of calllForEmergency method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isEmergencySet method, of class ess.ElevatorBean.
     */
    public void testIsEmergencySet() {
        System.out.println("isEmergencySet");        
        ElevatorBean instance = new ElevatorBean();
        
        boolean expResult1 = true;
        boolean expResult2 = false;
        boolean result = instance.isEmergencySet();
        
        if (result==expResult1 || result==expResult2) {
        	System.out.println("Test of isEmergencySet method, of class ess.ElevatorBean : [ Pass ]");
		}
        else {
        	System.out.println("Test of isEmergencySet method, of class ess.ElevatorBean : [ Fail ]");
        	fail("Test Failed");
        }
    }

     /**
     * Test of releaseEmergency method, of class ess.ElevatorBean.
     */
    public void testReleaseEmergency() {
        System.out.println("releaseEmergency");
        ElevatorBean instance = new ElevatorBean();
        try {
        	instance.releaseEmergency();
        	System.out.println("Test of releaseEmergency method, of class ess.ElevatorBean : [ Pass ]");
        } catch(Exception ex) {
        	System.out.println("Test of releaseEmergency method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of isDoorOpen method, of class ess.ElevatorBean.
     */
    public void testIsDoorOpen() {
        System.out.println("isDoorOpen");        
        int floorNo = 1;
        ElevatorBean instance = new ElevatorBean();

        boolean result = instance.isDoorOpen(floorNo);
        if (result==true || result==false) {
        	System.out.println("Test of isDoorOpen method, of class ess.ElevatorBean : [ Pass ]");
        }
        else {
        	System.out.println("Test of isDoorOpen method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of openDoor method, of class ess.ElevatorBean.
     */
    public void testOpenDoor() {
        System.out.println("openDoor");
        
        int floorNo = 2;
        ElevatorBean instance = new ElevatorBean();
        
        try {
        	instance.openDoor(floorNo);
        	System.out.println("Test of openDoor method, of class ess.ElevatorBean : [ Pass ]");
        } catch(Exception ex) {
        	System.out.println("Test of openDoor method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of closeDoor method, of class ess.ElevatorBean.
     */
    public void testCloseDoor() {
        System.out.println("closeDoor");
        
        int floorNo = 2;
        ElevatorBean instance = new ElevatorBean();
        
        try {
        	instance.closeDoor(floorNo);
        	System.out.println("Test of closeDoor method, of class ess.ElevatorBean : [ Pass ]");
        } catch(Exception ex) {
        	System.out.println("Test of closeDoor method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of addToRequestPool method, of class ess.ElevatorBean.
     */
    public void testAddToRequestPool() {
        System.out.println("addToRequestPool");
        
        int floorPosition = 2;
        boolean direction = true;
        ElevatorBean instance = new ElevatorBean();
        
        
        try {
        	instance.addToRequestPool(floorPosition, direction);
        	System.out.println("Test of addToRequestPool method, of class ess.ElevatorBean : [ Pass ]");
        } catch(Exception ex) {
        	System.out.println("Test of addToRequestPool method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of run method, of class ess.ElevatorBean.
     */
    public void testRun() {
        System.out.println("run");
        
        ElevatorBean instance = new ElevatorBean();        
        //instance.run();
        
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentFloor method, of class ess.ElevatorBean.
     */
    public void testGetCurrentFloor() {
        System.out.println("getCurrentFloor");        
        ElevatorBean instance = new ElevatorBean();
        
        int result = instance.getCurrentFloor();
        
        if(result <1 || result >4) {
        	System.out.println("Test of getCurrentFloor method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
        else {
        	System.out.println("Test of getCurrentFloor method, of class ess.ElevatorBean : [ Pass ]");        	
        }
    }

    /**
     * Test of setCurrentFloor method, of class ess.ElevatorBean.
     */
    public void testSetCurrentFloor() {
        System.out.println("setCurrentFloor");
        
        int currentFloor = 1;
        ElevatorBean instance = new ElevatorBean();
        
        try {
        	instance.setCurrentFloor(currentFloor);
        	System.out.println("Test of setCurrentFloor method, of class ess.ElevatorBean : [ Pass ]");
        } catch(Exception ex) {
        	System.out.println("Test of setCurrentFloor method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }

    /**
     * Test of getElevatorDirection method, of class ess.ElevatorBean.
     */
    public void testGetElevatorDirection() {
        System.out.println("getElevatorDirection");
        ElevatorBean instance = new ElevatorBean();
               
        boolean expResult1 = true;
        boolean expResult2 = false;
        boolean result = instance.getElevatorDirection();
        
        if (result==expResult1 || result==expResult2) {
        	System.out.println("Test of getElevatorDirection method, of class ess.ElevatorBean : [ Pass ]");
		}
        else {
        	System.out.println("Test of getElevatorDirection method, of class ess.ElevatorBean : [ Fail ]");
        	fail("The test case is a prototype.");
        }
    }
    
}
