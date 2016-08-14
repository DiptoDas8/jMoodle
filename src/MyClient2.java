

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient2
{
	public static void main (String[] args)throws Exception
	{
		
		System.out.println ("client");
		
		String serverAddress="127.0.0.1";
            int serverPort=33334;
            Socket sp= new Socket(InetAddress.getLocalHost().getHostAddress(),12345);
            PrintWriter p= new PrintWriter( sp.getOutputStream() );
            p.println("2");
            p.flush();
            sp.close();

		Socket socket= new Socket(InetAddress.getLocalHost().getHostAddress(),serverPort);
		
		PrintWriter pw= new PrintWriter( socket.getOutputStream() );
		
		Scanner sc= new Scanner( System.in );
		
		while( sc.hasNext() )
		{
			pw.println(sc.nextLine());
			pw.flush();
		}
		
		
    }
}