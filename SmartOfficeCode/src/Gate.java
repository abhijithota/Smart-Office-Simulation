
public class Gate implements Runnable{

	private boolean employeeGate = false;
	private boolean visitorGate = false;
	public boolean passed = false;
	
	public void openEmployeeGate()
	{
		if(!employeeGate) {
			System.out.println("Employee Parking Gate Opened!!");
			employeeGate = true;
		}
	}
	
	public void openVisitorGate()
	{
		if(!visitorGate) {
			System.out.println("Visitor Parking Gate Opened!!");
			visitorGate = true;
		}
	}
	
	public void closeEmployeeGate()
	{
		if(employeeGate) {
			System.out.println("Employee Parking Gate closed!!");
			employeeGate = false;
			passed = false;
		}
	}
	
	public void closeVisitorGate()
	{
		if(visitorGate) {
			System.out.println("Visitor Parking Gate Closed!!");
			visitorGate = false;
			passed = false;
		}
	}

	@Override
	public void run() {
		while(true)
		{
			if(passed == true && employeeGate == true)
			{
				closeEmployeeGate();
			}
			else if(passed == true && visitorGate == true)
			{
				closeVisitorGate();
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
}
