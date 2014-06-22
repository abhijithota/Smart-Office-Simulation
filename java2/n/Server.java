import java.net.*;
import java.io.*;

public class Server implements Runnable
{
	ServerSocket srv;
	Socket soc[];
	Integer i;

	public Server()
	{
			i=0;
			InetAddress sadd;
			while(true)
			{
			sadd = InetAddress.getLocalHost();
			srv = new ServerSocket(1181);

			System.out.println("Server  Started on "+sadd+" ....");
			System.out.println("Waiting for client request ...");

			soc[i] = srv.accept(i);
			}
	}
	

	
	public void run(i)
	{
			BufferedReader cin,sin;
			PrintWriter cout;
			InetAddress cadd = soc[i].getInetAddress();
			System.out.println("Client Request accepted from "+cadd+"\n");

			cin = new BufferedReader(new InputStreamReader(soc.getInputStream()));

			cout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc[i].getOutputStream())),true);
			sin = new BufferedReader(new InputStreamReader(System.in));

			while(true)
			{
				String str = cin.readLine();
				if(str.equals("end"))
					break;
				System.out.println("Client : " + str);
				System.out.print("Server : ");
				str = sin.readLine();
				cout.println(str);
				System.out.println("Waiting for client response");
			}

			System.out.println("Session Terminated");
			srv.close();
	}


	public static void main(String a[])
	{
		new Server();
	}
}