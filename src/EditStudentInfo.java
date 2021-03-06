



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static com.ui.generateIP.*;
import javax.swing.*;

import java.io.*;
import java.net.Socket;
public class EditStudentInfo extends JFrame {
	JLabel namelabel;
	JTextField name;
	JLabel LTlabel;
	JTextField LT;
	JLabel Mobilelabel;
	JTextField Mobile;
	JLabel Emaillabel;
	JTextField Email;
	JLabel StdNolabel;
	JTextField StdNo;
	JLabel Addresslabel;
	JTextField Address;
	JButton save;
	public StudentElements temp;
	private int fontsize=14;
	public Font f1=new Font("Serif",Font.BOLD,fontsize);
	public EditStudentInfo(StudentElements std){
		super(std.getName()+"--Info Edit");
		temp=std;
		Container c=getContentPane();
		GroupLayout layout=new GroupLayout(c);
		c.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		namelabel=new JLabel("Name:");
		namelabel.setFont(f1);
		LTlabel=new JLabel("Level/Term:");
		LTlabel.setFont(f1);
		Mobilelabel=new JLabel("Mobile Number:");
		Mobilelabel.setFont(f1);
		Emaillabel=new JLabel("Email Address:");
		Emaillabel.setFont(f1);
		StdNolabel=new JLabel("Student No:");
		StdNolabel.setFont(f1);
		Addresslabel=new JLabel("Address:");
		Addresslabel.setFont(f1);
		name=new JTextField();
		name.setFont(f1);
		LT=new JTextField();
		LT.setFont(f1);
		Mobile=new JTextField();
		Mobile.setFont(f1);
		Email=new JTextField();
		Email.setFont(f1);
		StdNo=new JTextField();
		StdNo.setFont(f1);
		Address=new JTextField();
		Address.setFont(f1);
		save=new JButton("Save");
		save.setSize(100, 30);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(namelabel)
				.addComponent(LTlabel)
				.addComponent(Mobilelabel)
				.addComponent(Emaillabel)
				.addComponent(StdNolabel)
				.addComponent(Addresslabel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(name)
				.addComponent(LT)
				.addComponent(Mobile)
				.addComponent(Email)
				.addComponent(StdNo)
				.addComponent(Address)
				.addComponent(save))
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(namelabel)
				.addComponent(name))
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(LTlabel)
				.addComponent(LT))
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(Mobilelabel)
				.addComponent(Mobile))
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(Emaillabel)
				.addComponent(Email))
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(StdNolabel)
				.addComponent(StdNo))
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(Addresslabel)
				.addComponent(Address))
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(save))
				
		);
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				int errorflag=0;
				if((Address.getText().length()==0) || (Email.getText().length()==0) || (Mobile.getText().length()==0)){
					JOptionPane.showMessageDialog(null, "Please fill up the empty field(s)");
					errorflag=1;
				}
				if(errorflag==0){
					temp.setAddress(Address.getText());
					temp.setContactNo(Mobile.getText());
					temp.setEmail(Email.getText());
					try {
	/*eikhane 1*/			Socket clientsocket=new Socket(getglobal(),12345);
                                        PrintWriter pw=new PrintWriter(clientsocket.getOutputStream());
                                        pw.println("editstudent");
                                        pw.flush();
                                        Socket newclientsocket=new Socket(getglobal(),30003);
                                        
	/*client obj pathabe ouyputstream e, seita server inputstream e paia file e write korbe*/
                                        ObjectOutputStream oos = new ObjectOutputStream(newclientsocket.getOutputStream());
				      oos.writeObject(temp);
				      oos.flush();
				      
				      JOptionPane.showMessageDialog(null, "Profile Updated!");
                                      newclientsocket.close();
				    }
				    catch(Exception e) {
				      System.out.println("rror Connecting with Server");
				      
				    }
					StudentInfo a = new StudentInfo(temp.getStndID());
					a.setSize(500, 350);
					a.setVisible(true);
                                        a.setLocationRelativeTo(null);
					a.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					setVisible(false);
				}
					
														
			}
		});
		name.setText(std.getName());
		name.setEditable(false);
		LT.setText(std.getLT());
		LT.setEditable(false);
		Mobile.setText(std.getContactNo());
		Mobile.setEditable(true);
		Email.setText(std.getEmail());
		Email.setEditable(true);
		StdNo.setText(std.getStndID());
		StdNo.setEditable(false);
		Address.setText(std.getAddress());
		Address.setEditable(true);
		setResizable(false);

	}
}
