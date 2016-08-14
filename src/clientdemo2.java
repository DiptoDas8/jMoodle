


/**
 *
 * @author User
 */
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class clientdemo2 {
    public static void main(String[] args){
        
        try{
            Socket clientsocket=new Socket("127.0.0.1",12345);
            PrintWriter pw=new PrintWriter(clientsocket.getOutputStream());
            pw.println("b");
            pw.flush();
            Socket newclientsocket=new Socket("127.0.0.1",40002);
            Scanner sc=new Scanner(System.in);
            String p="";
            while(true){
                p=sc.nextLine();
                if(p.equals("end")){
                    break;
                }
                PrintWriter pa=new PrintWriter(newclientsocket.getOutputStream());
                pa.println(p+" client 2");
                pa.flush();
            }
            newclientsocket.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
