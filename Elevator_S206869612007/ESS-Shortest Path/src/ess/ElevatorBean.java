/*
 * ElevatorBean.java
 *
 * Created on February 10, 2007, 7:19 PM
 */
package ess;


import com.sun.jmx.remote.internal.ArrayQueue;
import java.awt.Window;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author  Administrator
 */
public class ElevatorBean extends javax.swing.JPanel implements Runnable {
    
    /** Creates new form ElevatorBean */
    private boolean elevatorDirection=false; // true means move to down
    private ArrayList UPrequestPool=new ArrayList();
    private ArrayList DownrequestPool=new ArrayList();
    
    private boolean DoorRequest=false;  // false means close down;
                                        // true means open up
    
    private boolean StopRequest=false; // false means no Stop Request
                                       // true means stop elevator for half minutes
    
    private boolean emergency=false;    // when emergency is set up True Stop the elevator.
    private int emergencyFloorNumber=0; // Reset emergencyFloorNumber to 0  when emergency is set to false
            
    private int elevatorSpeed=40;
    
    public void setDoorRequest(boolean  DRequest) {
        DoorRequest=DRequest;
    }
    
    public boolean getDoorRequest() {
        return DoorRequest;
    }
    
    public void setStopRequest(boolean StopReq) {
        StopRequest=StopReq;
    }
    
    public boolean getStopRequest() {
        return StopRequest;
    }
    
    private int[] floorPositions= {510,350,190,30};
        
    
    public ElevatorBean() {
        initComponents();
        Thread ethread = new Thread(this);
        ethread.start();
    }
    
    public void calllForEmergency(int floorNumber) {
        emergency=true;
        emergencyFloorNumber=floorNumber;
        floor1Indicator.setEmergency();
        floor2Indicator.setEmergency();
        floor3Indicator.setEmergency();
        floor4Indicator.setEmergency();
    }
    
    public boolean isEmergencySet()
    {

        return emergency;
        
    }
    
    public void releaseEmergency() {
        floor1Indicator.setCurrentFloor(this.currentFloor);
        floor2Indicator.setCurrentFloor(this.currentFloor);
        floor3Indicator.setCurrentFloor(this.currentFloor);
        floor4Indicator.setCurrentFloor(this.currentFloor);
        emergencyFloorNumber=0;
        emergency=false;
        Thread ethread = new Thread(this);
        ethread.start();
    }
    
    private void setFloorIndicator(int yPosition)
    {
        int floorPos=0;
        
        if(yPosition==floorPositions[0]) 
        {
            floorPos=1;
        }
        else if(yPosition==floorPositions[1])
        {
            floorPos=2;
        }
        else if(yPosition==floorPositions[2])
        {
            floorPos=3;
        }
        else if(yPosition==floorPositions[3])
        {
            floorPos=4;
        }
        
        if (floorPos!=0)
        {
            
            if (!emergency) {
                floor1Indicator.setCurrentFloor(floorPos);
                floor2Indicator.setCurrentFloor(floorPos);
                floor3Indicator.setCurrentFloor(floorPos);
                floor4Indicator.setCurrentFloor(floorPos);
            }
            setCurrentFloor(floorPos);
            
            if (emergency) {
                openDoor(floorPos);
            }
            
            if (elevatorDirection==true)
            {
                //move to down
                if(ServeDownRequest(floorPos))
                {
                    openDoor(floorPos);
                }
                
            }
            else
            {
                //move to  up
                if(ServeUPRequest(floorPos))
                {
                    openDoor(floorPos);
                }
            }
            
            while(emergency) {
                // Do nothing
            }
            
            while(StopRequest) {
                // Do nothing
            }
            try {
               Thread.sleep(10);
            } catch (Exception e) {
                
            }
        }
    }
    
    private void showDirection()
    {
        floor1Indicator.setElevatorDirection(elevatorDirection);
        floor2Indicator.setElevatorDirection(elevatorDirection);
        floor3Indicator.setElevatorDirection(elevatorDirection);
        floor4Indicator.setElevatorDirection(elevatorDirection);
    }
    
    public boolean isDoorOpen(int floorNo) {
        boolean doorStatus=true; // Door is Open When value is true
        if (floorNo==1) {
            if(floor1.WIDTH!=100) {
                doorStatus= false;
            }
        }
        else if (floorNo==2) {
            if(floor2.WIDTH==100) {
                doorStatus= false;
            }
        }
        else if (floorNo==3) {
            if(floor3.WIDTH==100) {
                doorStatus= false;
            }
        }
        else if (floorNo==4) {
            if(floor4.WIDTH==100) {
                doorStatus= false;
            }
        }
        return doorStatus;
    }
    
    public void openDoor(int floorNo)
    {
        int side1Width=100;
        int iCount;
        
            for(iCount=1;iCount<100;iCount++)    {    
                    if(floorNo==1) {
                        floor1.setBounds(30,510,side1Width,130);            
                    }
                    else if(floorNo==2) {
                        floor2.setBounds(30,350,side1Width,130);
                    }
                    else if(floorNo==3) {
                        floor3.setBounds(30,190,side1Width,130);
                    }
                    else if(floorNo==4) {
                        floor4.setBounds(30,30,side1Width,130);
                    }
                    setVisible(true);
                    side1Width = side1Width -1;
                    DoorRequest=false;
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch(Exception ex)
                    {
                        
                    }               
            }
        
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch(Exception ex)
                    {
                        
                    }    
        
        while(emergency) {
            // Do nothing
        }
        closeDoor(floorNo);
  }

     public void closeDoor(int floorNo)
    {
        int side1Width=1;
        int iCount;
        
            for(iCount=1;iCount<100;iCount++)    {    
                    if(floorNo==1) {
                        floor1.setBounds(30,510,side1Width ,130);
                    }
                    else if(floorNo==2) {
                        floor2.setBounds(30,350,side1Width ,130);
                    }
                    else if(floorNo==3) {
                        floor3.setBounds(30,190,side1Width ,130);
                    }
                    else if(floorNo==4) {
                        floor4.setBounds(30,30,side1Width,130);
                    }
                    side1Width = side1Width + 1;
                    try
                    {
                        
                        Thread.sleep(10);
                    }
                    catch(Exception ex)
                    {
                        
                    }               
            }
  }
    
    public void addToRequestPool(int floorPosition,boolean direction)
    {
        if(direction==true) {
            DownrequestPool.add(floorPosition);
        }
        else {
            UPrequestPool.add(floorPosition);
        }
    }
    
    private boolean ServeDownRequest(int floorNumber)
    {
        int iCount;
        boolean Served=false;
        for(iCount=0;iCount<DownrequestPool.size();iCount++)
        {
            if(Integer.parseInt(DownrequestPool.get(iCount).toString())==floorNumber)
            {
                DownrequestPool.remove(iCount);
                Served=true;
            }
        }
        return Served;
    }
    
    private boolean ServeUPRequest(int floorNumber)
    {
        int iCount;
        boolean Served=false;
        for(iCount=0;iCount<UPrequestPool.size();iCount++)
        {
             if(Integer.parseInt(UPrequestPool.get(iCount).toString())==floorNumber)
            {
                UPrequestPool.remove(iCount);
                Served=true;
            }
        }
        return Served;
    }
    
    private int getLargestDownRequest()
    {
        int iCount;
        int maxVal=-1,maxPos=-1;
        
        for(iCount=0;iCount<DownrequestPool.size();iCount++)
        {
            if (iCount==0) {
                maxVal=Integer.parseInt(DownrequestPool.get(iCount).toString());
                maxPos=0;
            }
            else
            {
                if(maxVal<Integer.parseInt(DownrequestPool.get(iCount).toString()))
                {
                    maxVal=Integer.parseInt(DownrequestPool.get(iCount).toString());
                    maxPos=iCount;
                            
                }
            }
            
         }
        if(maxPos != -1)
        {
            DownrequestPool.remove(maxPos);
        }
        return maxVal;
    }
        
    
    
    private int getSmallestUPRequest()
    {
        int iCount;
        int minVal=-1,minPos=-1;
        
        for(iCount=0;iCount<UPrequestPool.size();iCount++)
        {
            if (iCount==0) {
                minVal=Integer.parseInt(UPrequestPool.get(iCount).toString());
                minPos=0;
            }
            else
            {
                if(minVal>Integer.parseInt(UPrequestPool.get(iCount).toString()))
                {
                    minVal=Integer.parseInt(UPrequestPool.get(iCount).toString());
                    minPos=iCount;  
                }
            }
            
         }
        if(minPos != -1)
        {
            UPrequestPool.remove(minPos);
        }
        return minVal;
    }
        
    
    
    public void run() {
        int fromFloor=currentFloor;
        int toFloor=currentFloor;
        int yStart=30,yEnd=30;
        yStart=floorPositions[currentFloor-1];
        yEnd=floorPositions[currentFloor-1];
        setFloorIndicator(yStart);
        elevator.setLocation(elevator.getBounds().x,yStart);
        elevatorDirection=true;
        //System.out.println("Start -----------------------------------------------");
        // System.out.println("S1 Covered");
        // System.out.println("S2 Covered"); 
        while(!emergency) {        
                try{
                    Thread.sleep(500);
                }
                catch(Exception ex)
                {
                }
                yStart=floorPositions[currentFloor-1];
                fromFloor=currentFloor;
                // System.out.println("S3 Covered"); 
                // System.out.println("S4 Covered"); 
                if (elevatorDirection==true)
                {
                    toFloor=getLargestDownRequest();
                    // System.out.println("S5 Covered");
                }
                else
                {
                    toFloor=getSmallestUPRequest();
                    // System.out.println("S6 Covered");
                }
                
                // System.out.println("S7 Covered"); 
                if(toFloor==-1 && elevatorDirection==true)
                {
                    // System.out.println("S8 Covered"); 
                    toFloor=getSmallestUPRequest();
                }
                // System.out.println("S9 Covered");
                if(toFloor==-1 && elevatorDirection==false)
                {
                    // System.out.println("S10 Covered");
                    toFloor=getLargestDownRequest();
                }
                // System.out.println("S11 Covered");
                if (toFloor==-1) {
                    // System.out.println("S12 Covered");
                    toFloor=currentFloor;
                }
                // System.out.println("S13 Covered");
                yEnd=floorPositions[toFloor-1];
                int yCount=yStart;
                // System.out.println("S14 Covered");
                if(DoorRequest==true)
                {
                    // System.out.println("S15 Covered");
                    openDoor(getCurrentFloor());
                    DoorRequest=false;
                }                
                // System.out.println("S16 Covered");
                if(StopRequest==true)
                {
                            try
                            {
                                int stopCounter=5000;
                                // System.out.println("S17 Covered");
                                // System.out.println("S18 Covered");
                                
                                while(stopCounter>0)
                                {   
                                   String msg = String.valueOf("Wait :" + Integer.toString(stopCounter/100));
                                   floor1Indicator.SetMessage(msg);
                                   floor2Indicator.SetMessage(msg);
                                   floor3Indicator.SetMessage(msg);
                                   floor4Indicator.SetMessage(msg);
                                   Thread.sleep(1);
                                   stopCounter=stopCounter -1;                   
                                   // System.out.println("S19 Covered");
                                }
                                // System.out.println("S20 Covered");
                                StopRequest=false;
                                floor1Indicator.setCurrentFloor(currentFloor);
                                floor2Indicator.setCurrentFloor(currentFloor);
                                floor3Indicator.setCurrentFloor(currentFloor);
                                floor4Indicator.setCurrentFloor(currentFloor);
                            }
                            catch(Exception ex)
                            {
                            }
                }
                //System.out.println("S21 Covered");
                if(fromFloor==toFloor) {
                       // System.out.println("SEnd Covered");
                       // Do nothing - Wait for User Request
                }
                else if((fromFloor - toFloor) > 0) {
                //System.out.println("S22 Covered");
                    //Down Direction
                    // System.out.println("S23 Covered");
                    elevatorDirection=true;
                    showDirection();
                    // System.out.println("S24 Covered");
                        while(yCount<=yEnd)
                        {
                            // System.out.println("S25 Covered");
                            elevator.setLocation(elevator.getBounds().x,yCount);
                            setFloorIndicator(yCount);
                            
                            yCount=yCount + elevatorSpeed;
                            try
                            {
                                Thread.sleep(500);
                            }
                            catch(Exception ex)
                            {       
                            }
                        }
                    // System.out.println("S26 Covered");
                    openDoor(toFloor);
                }
                else {
                    // UP Direction
                    // System.out.println("S27 Covered");
                    elevatorDirection=false;
                    showDirection();
                    // System.out.println("S28 Covered");
                    while(yCount>=yEnd)
                    {
                        // System.out.println("S29 Covered");
                        elevator.setLocation(elevator.getBounds().x,yCount);
                        setFloorIndicator(yCount);
                        
                        yCount=yCount - elevatorSpeed;
                            try
                            {
                                Thread.sleep(500);
                            }
                            catch(Exception ex)
                            {   
                            }
                    }
                    // System.out.println("S30 Covered");
                    openDoor(toFloor);
                } 
        //System.out.println("Last Statement within While Loop ----------------------------");
        }
    }
  
    
    
   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        floor4 = new javax.swing.JLabel();
        floor3 = new javax.swing.JLabel();
        floor2 = new javax.swing.JLabel();
        floor1 = new javax.swing.JLabel();
        floor4Indicator = new ess.floorIndicatorBean();
        floor3Indicator = new ess.floorIndicatorBean();
        floor1Indicator = new ess.floorIndicatorBean();
        floor2Indicator = new ess.floorIndicatorBean();
        elevator = new javax.swing.JLabel();
        floor1Door = new javax.swing.JLabel();
        floor2Door = new javax.swing.JLabel();
        floor3Door = new javax.swing.JLabel();
        floor4Door = new javax.swing.JLabel();
        floor4No = new javax.swing.JLabel();
        floor3No = new javax.swing.JLabel();
        floor2No = new javax.swing.JLabel();
        floor1No = new javax.swing.JLabel();

        setLayout(null);

        floor4.setBackground(new java.awt.Color(102, 102, 0));
        floor4.setAlignmentY(0.0F);
        floor4.setDoubleBuffered(true);
        floor4.setOpaque(true);
        add(floor4);
        floor4.setBounds(30, 30, 100, 130);

        floor3.setBackground(new java.awt.Color(102, 102, 0));
        floor3.setAlignmentY(0.0F);
        floor3.setOpaque(true);
        add(floor3);
        floor3.setBounds(30, 190, 100, 130);

        floor2.setBackground(new java.awt.Color(102, 102, 0));
        floor2.setAlignmentY(0.0F);
        floor2.setOpaque(true);
        add(floor2);
        floor2.setBounds(30, 350, 100, 130);

        floor1.setBackground(new java.awt.Color(102, 102, 0));
        floor1.setAlignmentY(0.0F);
        floor1.setOpaque(true);
        add(floor1);
        floor1.setBounds(30, 510, 100, 130);

        add(floor4Indicator);
        floor4Indicator.setBounds(30, 10, 110, 20);

        add(floor3Indicator);
        floor3Indicator.setBounds(30, 170, 110, 20);

        add(floor1Indicator);
        floor1Indicator.setBounds(30, 490, 110, 20);

        add(floor2Indicator);
        floor2Indicator.setBounds(30, 330, 110, 20);

        elevator.setBackground(new java.awt.Color(255, 153, 0));
        elevator.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        elevator.setDoubleBuffered(true);
        add(elevator);
        elevator.setBounds(30, 510, 120, 130);

        floor1Door.setBackground(new java.awt.Color(255, 204, 51));
        floor1Door.setAlignmentY(0.0F);
        floor1Door.setOpaque(true);
        add(floor1Door);
        floor1Door.setBounds(130, 510, 10, 130);

        floor2Door.setBackground(new java.awt.Color(255, 204, 51));
        floor2Door.setAlignmentY(0.0F);
        floor2Door.setOpaque(true);
        add(floor2Door);
        floor2Door.setBounds(130, 350, 10, 130);

        floor3Door.setBackground(new java.awt.Color(255, 204, 51));
        floor3Door.setAlignmentY(0.0F);
        floor3Door.setOpaque(true);
        add(floor3Door);
        floor3Door.setBounds(130, 190, 10, 130);

        floor4Door.setBackground(new java.awt.Color(255, 204, 51));
        floor4Door.setAlignmentY(0.0F);
        floor4Door.setOpaque(true);
        add(floor4Door);
        floor4Door.setBounds(130, 30, 10, 130);

        floor4No.setBackground(new java.awt.Color(255, 204, 51));
        floor4No.setFont(new java.awt.Font("Arial Black", 1, 24));
        floor4No.setForeground(new java.awt.Color(102, 102, 0));
        floor4No.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        floor4No.setText("4");
        floor4No.setAlignmentY(0.0F);
        floor4No.setOpaque(true);
        add(floor4No);
        floor4No.setBounds(0, 10, 30, 150);

        floor3No.setBackground(new java.awt.Color(255, 204, 0));
        floor3No.setFont(new java.awt.Font("Arial Black", 1, 24));
        floor3No.setForeground(new java.awt.Color(102, 102, 0));
        floor3No.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        floor3No.setText("3");
        floor3No.setAlignmentY(0.0F);
        floor3No.setOpaque(true);
        add(floor3No);
        floor3No.setBounds(0, 170, 30, 150);

        floor2No.setBackground(new java.awt.Color(255, 204, 51));
        floor2No.setFont(new java.awt.Font("Arial Black", 1, 24));
        floor2No.setForeground(new java.awt.Color(102, 102, 0));
        floor2No.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        floor2No.setText("2");
        floor2No.setAlignmentY(0.0F);
        floor2No.setOpaque(true);
        add(floor2No);
        floor2No.setBounds(0, 330, 30, 150);

        floor1No.setBackground(new java.awt.Color(255, 204, 51));
        floor1No.setFont(new java.awt.Font("Arial Black", 1, 24));
        floor1No.setForeground(new java.awt.Color(102, 102, 0));
        floor1No.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        floor1No.setText("1");
        floor1No.setAlignmentY(0.0F);
        floor1No.setOpaque(true);
        add(floor1No);
        floor1No.setBounds(0, 490, 30, 150);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel elevator;
    private javax.swing.JLabel floor1;
    private javax.swing.JLabel floor1Door;
    private ess.floorIndicatorBean floor1Indicator;
    private javax.swing.JLabel floor1No;
    private javax.swing.JLabel floor2;
    private javax.swing.JLabel floor2Door;
    private ess.floorIndicatorBean floor2Indicator;
    private javax.swing.JLabel floor2No;
    private javax.swing.JLabel floor3;
    private javax.swing.JLabel floor3Door;
    private ess.floorIndicatorBean floor3Indicator;
    private javax.swing.JLabel floor3No;
    private javax.swing.JLabel floor4;
    private javax.swing.JLabel floor4Door;
    private ess.floorIndicatorBean floor4Indicator;
    private javax.swing.JLabel floor4No;
    // End of variables declaration//GEN-END:variables

    /**
     * Holds value of property currentFloor.
     */
    private int currentFloor=4;

    /**
     * Getter for property currentFloor.
     * @return Value of property currentFloor.
     */
    public int getCurrentFloor() {
        return this.currentFloor;
    }

    /**
     * Setter for property currentFloor.
     * @param currentFloor New value of property currentFloor.
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }


    public boolean getElevatorDirection()
    {
        return this.elevatorDirection;
    }
    
        

    
    
}
