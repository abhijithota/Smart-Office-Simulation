import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AC implements Runnable{
	public int currentTemp;
	public int setTemp;
	private boolean acFlag;
	final int THRESHOLD = 3;
	
	public AC() {
		acFlag = false;
		System.out.println("Inside AC.\nPlease Enter the desired TEMP:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = "0";
		try {
			temp = br.readLine();
		}catch(IOException ioe)
		{
			System.out.println("IO Error while reading!");
			System.exit(1);
		}
		setTemp = Integer.parseInt(temp);
		currentTemp = setTemp - (int)(java.lang.Math.random()*10);
		System.out.println("Current Temperature is " + currentTemp);
	}
	
	private void switchOn()
	{
		if(!acFlag) {
			System.out.println("AC switched ON");
		}
		acFlag = true;
	}
	private void switchOff()
	{
		if(acFlag) {
			System.out.println("AC switched OFF");
		}
		acFlag = false;
	}
	private void checkTemp()
	{
		if(acFlag) {
			currentTemp--;
		}
		else {
			currentTemp++;
		}
	}


	@Override
	public void run() {
		while(true) {
			checkTemp();
			System.out.println("Current Temperature is " + currentTemp);
			if(currentTemp > setTemp) {
				switchOn();
			}
			else if(currentTemp < setTemp  - THRESHOLD) {
				switchOff();
			}
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ie) {
				System.out.println(ie.getMessage());
			}
		}
	}
	
	
	
}
