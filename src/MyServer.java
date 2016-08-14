import com.socket.Database;
import com.socket.ServerFrame;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

class changepassthread implements Runnable {

	private Socket socket;
	private Thread thr;

	public changepassthread(Socket socket) {
		this.socket = socket;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {

			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());
			StudentElements std;
			std = (StudentElements) ois.readObject();
			FileOutputStream fos = new FileOutputStream("D:\\eclipseJavaLuna\\Combine_Try\\Students/"
					+ std.getStndID() + ".dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(std);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class changepassteacherthread implements Runnable {

	private Socket socket;
	private Thread thr;

	public changepassteacherthread(Socket s) {
		socket = s;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {

			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());
			TeacherElements std;
			std = (TeacherElements) ois.readObject();
			FileOutputStream fos = new FileOutputStream("D:\\eclipseJavaLuna\\Combine_Try\\Teachers/"
					+ std.getUserID() + ".dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(std);
			oos.flush();
			oos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class editstudentthread implements Runnable {

	private Socket socket;
	private Thread thr;

	public editstudentthread(Socket socket) {
		this.socket = socket;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {

			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());
			StudentElements std;
			std = (StudentElements) ois.readObject();
			FileOutputStream fos = new FileOutputStream("D:\\eclipseJavaLuna\\Combine_Try\\Students/"
					+ std.getStndID() + ".dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(std);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class editteacherthread implements Runnable {

	private Socket socket;
	private Thread thr;

	public editteacherthread(Socket socket) {
		this.socket = socket;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {

			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());
			TeacherElements std;
			std = (TeacherElements) ois.readObject();
			FileOutputStream fos = new FileOutputStream("D:\\eclipseJavaLuna\\Combine_Try\\Teachers/"
					+ std.getUserID() + ".dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(std);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class totalfilethread implements Runnable {

	private Socket socket;
	private Thread thr;

	public totalfilethread(Socket socket) {
		this.socket = socket;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {
			String dirname = "D:\\eclipseJavaLuna\\Combine_Try\\Students";
			File f1 = new File(dirname);
			String all[] = f1.list();
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(all.length);
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class getnoticethread implements Runnable {

	private Socket socket;
	private Thread thr;

	public getnoticethread(Socket socket) {
		this.socket = socket;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {

			String dirname = "D:\\eclipseJavaLuna\\Combine_Try\\Students";
			File f1 = new File(dirname);
			String all[] = f1.list();
			StudentElements std;
			for (int i = 0; i < all.length; ++i) {
				FileInputStream fis = new FileInputStream("D:\\eclipseJavaLuna\\Combine_Try\\Students/" + all[i]);
				ObjectInputStream ois1 = new ObjectInputStream(fis);
				ObjectOutputStream oos1 = new ObjectOutputStream(
						socket.getOutputStream());
				std = (StudentElements) ois1.readObject();
				oos1.writeObject(std);
				ois1.close();
				ObjectInputStream ois2 = new ObjectInputStream(
						socket.getInputStream());
				std = (StudentElements) ois2.readObject();
				FileOutputStream fos = new FileOutputStream("D:\\eclipseJavaLuna\\Combine_Try\\Students/"
						+ all[i]);
				ObjectOutputStream oos2 = new ObjectOutputStream(fos);
				oos2.writeObject(std);
				oos2.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class studentinfothread implements Runnable {

	private Socket socket;
	private Thread thr;

	public studentinfothread(Socket socket) {
		this.socket = socket;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {

			Scanner sp = new Scanner(socket.getInputStream());
			String p = "";
			while (p.length() == 0) {
				p = sp.nextLine();
				if (p.length() > 0) {
					break;
				}
			}
			File f1 = new File("D:\\eclipseJavaLuna\\Combine_Try\\Students");
			String all[] = f1.list();
			int i;
			StudentElements std = new StudentElements("", "", "", "", "", "",
					"", "");
			for (i = 0; i < all.length; ++i) {
				if (all[i].equals(p + ".dat")) {
					break;
				}
			}
			FileInputStream fis = new FileInputStream("D:\\eclipseJavaLuna\\Combine_Try\\Students/" + all[i]);
			ObjectInputStream ois = new ObjectInputStream(fis);
			std = (StudentElements) ois.readObject();
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());
			oos.writeObject(std);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class teacherinfothread implements Runnable {

	private Socket socket;
	private Thread thr;

	public teacherinfothread(Socket socket) {
		this.socket = socket;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {

			Scanner sp = new Scanner(socket.getInputStream());
			String p = "";
			while (p.length() == 0) {
				p = sp.nextLine();
				if (p.length() > 0) {
					break;
				}
			}
			File f1 = new File("D:\\eclipseJavaLuna\\Combine_Try\\Teachers");
			String all[] = f1.list();
			int i;
			TeacherElements std = new TeacherElements("", "", "", "", "", "",
					"");
			for (i = 0; i < all.length; ++i) {
				if (all[i].equals(p + ".dat")) {
					break;
				}
			}
			FileInputStream fis = new FileInputStream("D:\\eclipseJavaLuna\\Combine_Try\\Teachers/" + all[i]);
			ObjectInputStream ois = new ObjectInputStream(fis);
			std = (TeacherElements) ois.readObject();
			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());
			oos.writeObject(std);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class studentregisterthread implements Runnable {

    private Socket socket;
    private Thread thr;
    private String username, ps, type, levelTerm, pos, mobile, mail, stNo, addr, Id;
    public studentregisterthread(Socket socket) {
        this.socket = socket;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {

            File f1 = new File("D:\\eclipseJavaLuna\\Combine_Try\\Students");
            String all[] = f1.list();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            StudentElements std = new StudentElements("", "", "", "", "", "", "", "");
            TeacherElements stdtemp = new TeacherElements("", "", "", "", "", "", "");
            while (true) {
                std = (StudentElements) ois.readObject();
                if (std.getName().length() > 0) {
                    break;
                }
            }
            int i;
            for (i = 0; i < all.length; ++i) {
                if ((all[i]).equals(std.getStndID() + ".dat")) {
                    break;
                }
            }
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            if (i < all.length) {
                pw.println("Invalid ID, User already has an account");
                pw.flush();
            } else {
                serverFeedback feed = new serverFeedback(std,std.getStndID(), std.getPass(), "Student",stdtemp);
                feed.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                feed.setLocationRelativeTo(null);
                feed.setVisible(true);
                int b = feed.getacceptvalue();
                while (b == -1) {
                    b = feed.getacceptvalue();
                }
                feed.setVisible(false);
                if (b == 1) {
                    FileOutputStream fos = new FileOutputStream("D:\\eclipseJavaLuna\\Combine_Try\\Students/" + std.getStndID() + ".dat");
                    /*eikhane 6*/ ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(std);
                    oos.flush();
                    oos.close();
                    pw.println("Registration successful");
                    pw.flush();
                    Database db = new Database("D:\\eclipseJavaLuna\\Combine_Try\\necessary\\Data.xml");
                    username = std.getName();
                    ps = std.getPass();
                    type = "student";
                    levelTerm = std.getLT();
                    pos = "NULL";
                    mobile = std.getContactNo();
                    mail = std.getEmail();
                    stNo = std.getStndID();
                    addr = std.getAddress();
                    Id = std.getStndID();
                    db.addUser(username, ps, type, levelTerm, pos, mobile, mail, stNo, addr, Id);
                } else {
                    pw.println("Registration failed");
                    pw.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class teacherregisterthread implements Runnable {

    private Socket socket;
    private Thread thr;
     private String username, ps, type, levelTerm, pos, mobile, mail, stNo, addr, Id;
    public teacherregisterthread(Socket socket) {
        this.socket = socket;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {

            File f1 = new File("D:\\eclipseJavaLuna\\Combine_Try\\Teachers");
            String all[] = f1.list();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            TeacherElements std = new TeacherElements("", "", "", "", "", "", "");
            StudentElements stdtemp = new StudentElements("", "", "", "", "", "", "", "");
            while (true) {
                std = (TeacherElements) ois.readObject();
                if (std.getName().length() > 0) {
                    break;
                }
            }
            int i;
            for (i = 0; i < all.length; ++i) {
                if ((all[i]).equals(std.getUserID() + ".dat")) {
                    break;
                }
            }
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            if (i < all.length) {
                pw.println("Invalid ID, User already has an account");
                pw.flush();
            } else {
                serverFeedback feed = new serverFeedback(stdtemp,std.getUserID(), std.getPass(), "Teacher",std);
                feed.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                feed.setLocationRelativeTo(null);
                feed.setVisible(true);
                int b = feed.getacceptvalue();
                while (b == -1) {
                    b = feed.getacceptvalue();
                }
                feed.setVisible(false);
                if (b == 1) {
                    FileOutputStream fos = new FileOutputStream("D:\\eclipseJavaLuna\\Combine_Try\\Teachers/" + std.getUserID() + ".dat");
                    /*eikhane 6*/ ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(std);
                    oos.flush();
                    oos.close();
                    pw.println("Registration successful");
                    pw.flush();
                    Database db = new Database("D:\\eclipseJavaLuna\\Combine_Try\\necessary\\Data.xml");
					username = std.getName();
					ps = std.getPass();
					type = "teacher";
					levelTerm = "NULL";
					pos = std.getPosition();
					mobile = std.getContactNo();
					mail = std.getEmail();
					stNo = "NULL";
					addr = std.getAddress();
					Id = std.getUserID();
					db.addUser(username,ps,type,levelTerm,pos,mobile,mail,stNo,addr,Id);
                } else {
                    pw.println("Registration failed");
                    pw.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class studentloginthread implements Runnable {

	private Socket socket;
	private Thread thr;

	public studentloginthread(Socket socket) {
		this.socket = socket;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {

			File f1 = new File("D:\\eclipseJavaLuna\\Combine_Try\\Students");
			String all[] = f1.list();
			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());
			StudentElements std = new StudentElements("", "", "", "", "", "",
					"", "");
			while (true) {
				std = (StudentElements) ois.readObject();
				if (std.getStndID().length() > 0) {
					break;
				}
			}
			int i;
			int flag = 0;
			for (i = 0; i < all.length; ++i) {
				if ((all[i]).equals(std.getStndID() + ".dat")) {
					FileInputStream fstd = new FileInputStream("D:\\eclipseJavaLuna\\Combine_Try\\Students/"
							+ all[i]);
					ObjectInputStream ostd = new ObjectInputStream(fstd);
					StudentElements temp;
					temp = (StudentElements) ostd.readObject();
					if ((temp.getPass()).equals(std.getPass())) {
						flag = 1;
						break;
					}
				}
			}
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			if (flag == 0) {
				pw.println("Wrong");
				pw.flush();
			} else {
				pw.println("Right");
				pw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class teacherloginthread implements Runnable {

	private Socket socket;
	private Thread thr;

	public teacherloginthread(Socket socket) {
		this.socket = socket;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {

			File f1 = new File("D:\\eclipseJavaLuna\\Combine_Try\\Teachers");
			String all[] = f1.list();
			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());
			TeacherElements std = new TeacherElements("", "", "", "", "", "",
					"");
			while (true) {
				std = (TeacherElements) ois.readObject();
				if ((std.getUserID()).length() > 0) {
					break;
				}
			}
			int i;
			int flag = 0;
			for (i = 0; i < all.length; ++i) {
				if ((all[i]).equals(std.getUserID() + ".dat")) {
					FileInputStream fstd = new FileInputStream("D:\\eclipseJavaLuna\\Combine_Try\\Teachers/"
							+ all[i]);
					ObjectInputStream ostd = new ObjectInputStream(fstd);
					TeacherElements temp;
					temp = (TeacherElements) ostd.readObject();
					if ((temp.getPass()).equals(std.getPass())) {
						flag = 1;
						break;
					}
				}
			}
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			if (flag == 0) {
				pw.println("Wrong");
				pw.flush();
			} else {
				pw.println("Right");
				pw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class ChiefThread implements Runnable {

	private Socket sa;
	private Thread thr;
	private ServerSocket changepass;
	private ServerSocket changepassteacher;
	private ServerSocket EditStudent;
	private ServerSocket EditTeacher;
	private ServerSocket getNotice;
	private ServerSocket totalfile;
	private ServerSocket studentinfo;
	private ServerSocket teacherinfo;
	private ServerSocket studentregister;
	private ServerSocket teacherregister;
	private ServerSocket studentlogin;
	private ServerSocket teacherlogin;

	public ChiefThread(Socket sa, ServerSocket changepass,
			ServerSocket changepassteacher, ServerSocket EditStudent,
			ServerSocket EditTeacher, ServerSocket getNotice,
			ServerSocket totalfile, ServerSocket studentinfo,
			ServerSocket teacherinfo, ServerSocket studentregister,
			ServerSocket teacherregister, ServerSocket studentlogin,
			ServerSocket teacherlogin) {
		this.sa = sa;
		this.changepass = changepass;
		this.changepassteacher = changepassteacher;
		this.EditStudent = EditStudent;
		this.EditTeacher = EditTeacher;
		this.getNotice = getNotice;
		this.totalfile = totalfile;
		this.studentinfo = studentinfo;
		this.teacherinfo = teacherinfo;
		this.studentregister = studentregister;
		this.teacherregister = teacherregister;
		this.studentlogin = studentlogin;
		this.teacherlogin = teacherlogin;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {
			Scanner sc = new Scanner(sa.getInputStream());
			String a;
			while (true) {
				a = sc.nextLine();
				if (a.equals("changepass") || a.equals("changepassteacher")
						|| a.equals("editstudent") || a.equals("editteacher")) {
					break;
				} else if (a.equals("totalfile") || a.equals("getnotice")
						|| a.equals("studentinfo") || a.equals("teacherinfo")) {
					break;
				} else if (a.equals("studentregister")
						|| a.equals("teacherregister")) {
					break;
				} else if (a.equals("studentlogin") || a.equals("teacherlogin")) {
					break;
				}
			}
			System.out.println(a);
			Socket socket;
			if (a.equals("changepass")) {
				// while(true){
				socket = changepass.accept();
				new changepassthread(socket);
				// }
			}

			if (a.equals("changepassteacher")) {

				// while(true){
				socket = changepassteacher.accept();
				new changepassteacherthread(socket);
				// }
			}
			if (a.equals("editstudent")) {

				// while(true){
				socket = EditStudent.accept();
				new editstudentthread(socket);
				// }
			}
			if (a.equals("editteacher")) {

				// while(true){
				socket = EditTeacher.accept();
				new editteacherthread(socket);
				// }
			}
			if (a.equals("totalfile")) {

				// while(true){
				socket = totalfile.accept();
				new totalfilethread(socket);
				// }
			}

			if (a.equals("getnotice")) {

				// while(true){
				socket = getNotice.accept();
				new getnoticethread(socket);
				// }
			}
			if (a.equals("studentinfo")) {

				// while(true){
				socket = studentinfo.accept();
				new studentinfothread(socket);
				// }
			}
			if (a.equals("teacherinfo")) {

				// while(true){
				socket = teacherinfo.accept();
				new teacherinfothread(socket);
				// }
			}
			if (a.equals("studentregister")) {

				// while(true){
				socket = studentregister.accept();
				new studentregisterthread(socket);
				// }
			}
			if (a.equals("teacherregister")) {

				// while(true){
				socket = teacherregister.accept();
				new teacherregisterthread(socket);
				// }
			}
			if (a.equals("studentlogin")) {

				// while(true){
				socket = studentlogin.accept();
				new studentloginthread(socket);
				// }
			}
			if (a.equals("teacherlogin")) {

				// while(true){
				socket = teacherlogin.accept();
				new teacherloginthread(socket);
				// }
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class MyServer {

	public MyServer() {
            MyServerFrame a=new MyServerFrame();
            a.setVisible(true);
            a.setResizable(false);
            a.setLocationRelativeTo(null);
		System.out.println("server");
		try {
			ServerSocket chief = new ServerSocket(12345);
			ServerSocket changepass = new ServerSocket(30001);
			ServerSocket changepassteacher = new ServerSocket(30002);
			ServerSocket EditStudent = new ServerSocket(30003);
			ServerSocket EditTeacher = new ServerSocket(30004);
			ServerSocket getNotice = new ServerSocket(30005);
			ServerSocket totalfile = new ServerSocket(30006);
			ServerSocket studentinfo = new ServerSocket(30007);
			ServerSocket teacherinfo = new ServerSocket(30008);
			ServerSocket studentregister = new ServerSocket(30009);
			ServerSocket teacherregister = new ServerSocket(30010);
			ServerSocket studentlogin = new ServerSocket(30011);
			ServerSocket teacherlogin = new ServerSocket(30012);

			while (true) {
				Socket s = chief.accept();
				new ChiefThread(s, changepass, changepassteacher, EditStudent,
						EditTeacher, getNotice, totalfile, studentinfo,
						teacherinfo, studentregister, teacherregister,
						studentlogin, teacherlogin);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		System.out.println("server");
		ServerFrame frame = new ServerFrame();
		frame.setVisible(true);
                
		try {
			ServerSocket chief = new ServerSocket(12345);
			ServerSocket changepass = new ServerSocket(30001);
			ServerSocket changepassteacher = new ServerSocket(30002);
			ServerSocket EditStudent = new ServerSocket(30003);
			ServerSocket EditTeacher = new ServerSocket(30004);
			ServerSocket getNotice = new ServerSocket(30005);
			ServerSocket totalfile = new ServerSocket(30006);
			ServerSocket studentinfo = new ServerSocket(30007);
			ServerSocket teacherinfo = new ServerSocket(30008);
			ServerSocket studentregister = new ServerSocket(30009);
			ServerSocket teacherregister = new ServerSocket(30010);
			ServerSocket studentlogin = new ServerSocket(30011);
			ServerSocket teacherlogin = new ServerSocket(30012);

			while (true) {
				Socket s = chief.accept();
				new ChiefThread(s, changepass, changepassteacher, EditStudent,
						EditTeacher, getNotice, totalfile, studentinfo,
						teacherinfo, studentregister, teacherregister,
						studentlogin, teacherlogin);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
