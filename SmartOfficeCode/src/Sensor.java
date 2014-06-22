import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Sensor {
	DoorController door;

	public Sensor() {
		super();
		door = new DoorController();
		Thread t = new Thread(door);
		t.start();
		String sense = "0";
		
		while(sense.equalsIgnoreCase("0") || sense.equalsIgnoreCase("detected") || sense.equalsIgnoreCase("passed")) {
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			try {
				sense = br1.readLine();
			}catch(IOException ioe)
			{
				System.out.println("IO Error while reading!");
				System.exit(1);
			}
			if(sense.equalsIgnoreCase("detected")) {
				System.out.println("Person detected!");
				door.person =  true;
			}
			if(sense.equalsIgnoreCase("passed")) {
				door.person =  false;
				System.out.println("Person Passed!");
			}
			
		}
		t.stop();
		
	}

}
