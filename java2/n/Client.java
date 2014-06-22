import java.net.*;
import java.io.*;

public class Client
{
	Socket soc;
	BufferedReader sin,cin;
	PrintWriter sout;

	public Client(String srvName)
	{
		try
		{
			soc = new Socket("localhost",1181);
			System.out.println("****request went*****");

			sin = new BufferedReader(new InputStreamReader(soc.getInputStream()));

			sout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())),true);
			cin = new BufferedReader(new InputStreamReader(System.in));

			while(true)
			{
				System.out.print("Client : ");
				String str = cin.readLine();
				sout.println(str);
				if(str.equals("end"))
					break;
				System.out.println("Waiting for server response");
				str = sin.readLine();
				System.out.println("Server : " + str);
			}

			System.out.println("Session Terminated");
			soc.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	public static void main(String a[])
	{
		new Client("STAFF");
	}
}
