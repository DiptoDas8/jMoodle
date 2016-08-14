


import java.io.PrintWriter;
import java.net.ServerSocket;
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
public class serverdemo{

    public static void main(String[] args) {

        try {
            ServerSocket chief = new ServerSocket(12345);
            //String get = "";
            ServerSocket s1 = new ServerSocket(40001);
            ServerSocket s2 = new ServerSocket(40002);
            Thread thr;
            
            while (true) {
                Socket s = chief.accept();
                Scanner sc = new Scanner(s.getInputStream());
                String a = "";
                while (true) {
                    a = sc.nextLine();
                    if (a.equals("a") || a.equals("b")) {
                        break;
                    }
                }
                System.out.println(a);

                Socket socket = new Socket();
                if (a.equals("a")) {
                    socket = s1.accept();
                    System.out.println("client 1");
                    Scanner sp = new Scanner(socket.getInputStream());
                    String p = "";
                    while (socket.isConnected()) {
                        p = sp.nextLine();
                        System.out.println(p);
                    }
                } else if (a.equals("b")) {
                    socket = s2.accept();
                    System.out.println("client 2");
                    Scanner sp = new Scanner(socket.getInputStream());
                    String p = "";
                    while (socket.isConnected()) {
                        p = sp.nextLine();
                        System.out.println(p);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
