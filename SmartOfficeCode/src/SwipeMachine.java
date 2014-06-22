import java.io.*;


public class SwipeMachine {

	public SwipeMachine(int labOrEntry) {
		System.out.println("Inside SwipeMachine.\nPlease Input your credentials:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userName = null;
		try {
			userName = br.readLine();
		}catch(IOException ioe)
		{
			System.out.println("IO Error while reading!");
			System.exit(1);
		}
		DatabaseManager db = new DatabaseManager();
		if(labOrEntry == 3) {
			Gate gate = new Gate();
			Thread t = new Thread(gate);
			t.start();
			if(db.validate(labOrEntry, userName)) {
				System.out.println("Employee Vehicle Detected!!");
				gate.openEmployeeGate();
			}
			else {
				System.out.println("Visitor Vehicle Detected!!");
				gate.openVisitorGate();
			}
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			try {
				if(br1.readLine() != null)
				{
					gate.passed = true;
					System.out.println("Vehicle Passed!!");
					while(gate.passed);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(db.validate(labOrEntry, userName))
		{
			System.out.println("Valid Credentials! Entry Granted!");
		}
		else
		{
			System.out.println("Invalid Credentials! Raise ALARM!");
			new Alarm();
		}
		
	}

}
