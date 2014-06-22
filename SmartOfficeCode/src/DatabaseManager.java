import java.io.*;
import java.sql.Time;
import java.util.Calendar;
import java.util.StringTokenizer;

public class DatabaseManager {
	private String FileName;

	public DatabaseManager() {
		System.out.println("Inside DatabaseManager.");
	}
	
	public Boolean validate(int labOrEntry, String credential)
	{
		Boolean result = false;
		if(labOrEntry == 1 || labOrEntry == 3)
		{
			FileName = "Entry.txt";
			System.out.println("Checking credentials against Entry Database.");
		}
		else if(labOrEntry == 2)
		{
			FileName = "Lab.txt";
			System.out.println("Checking credentials against Lab Database.");
		}
		try{
				FileInputStream fstream = new FileInputStream(FileName);
				DataInputStream in = new DataInputStream(fstream);
		        BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
				while ((strLine = br.readLine()) != null) 	{
					StringTokenizer idName = new StringTokenizer(strLine, "\t");
					if(idName.nextToken().equalsIgnoreCase(credential)) {
						result = true;
						if(labOrEntry ==  1)
						{
							try {
								System.out.println("Writing LOG!!");
								BufferedWriter out = new BufferedWriter(new FileWriter("Record.txt", true));
								out.write(strLine+"\t"+Calendar.getInstance().getTime()+"\n");
								out.close();
								} catch (IOException e) {}
						}
					}
			}
				in.close();
			}catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
		return result;
	}
	
	

}
