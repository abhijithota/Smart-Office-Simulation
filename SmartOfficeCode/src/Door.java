
public class Door {
	public boolean door = false;
	
	public void openDoor()
	{
		if(!door) {
			System.out.println("Door Opened");
			door = true;
		}
	}
	
	public void closeDoor()
	{
		if(door) {
			System.out.println("Door Closed");
			door = false;
		}
	}
	
}
