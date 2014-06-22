
public class DoorController implements Runnable{
	
	public boolean person =  false;

	@Override
	public void run() {
		Door door = new Door();
		while(true) {
			if(person) {
				door.openDoor();
				while(person)
				{
					try {
						System.out.println("Door will close in 5 seconds!!");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				door.closeDoor();
			}
		}
		
	}
}
