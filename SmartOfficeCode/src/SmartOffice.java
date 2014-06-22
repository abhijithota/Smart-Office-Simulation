import java.io.*;

import javax.swing.JFrame;

public class SmartOffice {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true)
		{
			System.out.println("Enter Your choice\n1. Entry System\n2. Lab System\n3. Cube System\n4. Door System\n5. AC\n6. Lights\n7. Parking");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String choice = "0";
			try {
				choice = br.readLine();
			}catch(IOException ioe)
			{
				System.out.println("IO Error while reading!");
				System.exit(1);
			}
			switch(Integer.parseInt(choice)){
				case 1:										//Choice Entry
					new SwipeMachine(1);
					break;
				case 2:										//Choice Lab
					new SwipeMachine(2);
					break;
				case 3:										//Choice Cube
					new OccupancyMonitor();
					break;
				case 4:										//Choice Door
					new Sensor();
					break;
				case 5:										//Choice AC
					{
						AC ac = new AC();
						Thread t = new Thread(ac);
						t.start();
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						String choice1 = "0";
						try {
							choice1 = br1.readLine();
						}catch(IOException ioe)
						{
							System.out.println("IO Error while reading!");
							System.exit(1);
						}
						t.stop();
						break;
					}
				case 6:										//Choice Lights
					Light gLight = new Light();
					gLight.setVisible(true);
					gLight.setSize(1400,600);
					gLight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					break;
				case 7:
					new SwipeMachine(3);
					break;
				default:
					break;
			}
			
		}
	}

}
