


import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class clientdemo1 {
    public static void main(String[] args){
        
        try{
            Socket clientsocket=new Socket("127.0.0.1",12345);
            PrintWriter pw=new PrintWriter(clientsocket.getOutputStream());
            pw.println("a");
            pw.flush();
            Socket newclientsocket=new Socket("127.0.0.1",40001);
            Scanner sc=new Scanner(System.in);
            String p="";
            while(true){
                p=sc.nextLine();
                if(p.equals("end")){
                    break;
                }
                PrintWriter pa=new PrintWriter(newclientsocket.getOutputStream());
                pa.println(p+" client 1");
                pa.flush();
            }
            newclientsocket.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
