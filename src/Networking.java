


/**
 *
 * @author User
 */
import java.net.*;
import java.util.*;
public class Networking {
    public static void main(String[] args){
        try{
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost());
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        	byte address[]=new byte[4];
  		address[0]=(byte)192;
  		address[1]=(byte)168;
  		address[2]=(byte)0;
  		address[3]=(byte)63;  		
    	try 
    	{
      		InetAddress ipAddress = InetAddress.getByAddress(address);
      		System.out.println(ipAddress);
                ipAddress = InetAddress.getByName("User-PC"); //so pc er nam jane eikhan theke ip address pabo...
      		System.out.println(ipAddress);
    	}
    	catch ( UnknownHostException ex )
    	{
      		System.out.println(ex);
    	}
        /*System.out.println(InetAddress.getByName("192.168.10.2"));
        Enumeration e = NetworkInterface.getNetworkInterfaces();
        
            while(e.hasMoreElements())
            {
                NetworkInterface n = (NetworkInterface) e.nextElement();
                Enumeration ee = n.getInetAddresses();
                while (ee.hasMoreElements())
                {
                    InetAddress i = (InetAddress) ee.nextElement();
                    System.out.println(i.getHostAddress());
                }
            }
        }*/
        
    }
}
