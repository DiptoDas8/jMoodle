import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.io.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.Socket;
import java.util.Scanner;






//notun
import com.socket.Database;

import static com.ui.generateIP.*;

public class TeacherRegistry extends JFrame {
	private String[] strings;
	private String username, pw, type, levelTerm, pos, mobile, mail, stNo,
			addr, Id;
	public String ipAddr;

	public Database db;
	
	public TeacherRegistry() {
		
	}

	public TeacherRegistry(String ipAddr) {
		this.ipAddr = ipAddr;
		initComponents();
	}

	private void initComponents() {

		nameTagLabel = new JLabel();
		positionTagLabel = new JLabel();
		contactNumTagLabel = new JLabel();
		emailTagLabel = new JLabel();
		addrTagLabel = new JLabel();
		userIDTagLabel = new JLabel();
		passTagLabel = new JLabel();
		confPassLabel = new JLabel();
		wcLabel = new JLabel();
		youAreServedFromLabel = new JLabel();
		hostLabel = new JLabel();
		portLabel = new JLabel();
		hostAddrField = new JTextField();
		portField = new JTextField();
		closeButton = new JButton();
		registerButton = new JButton();
		goBackButton = new JButton();
		nameField = new JTextField();
		mobileNoField = new JTextField();
		emailField = new JTextField();
		addrField = new JTextField();
		userIDField = new JTextField();
		positionComboBox = new JComboBox();
		passField = new JPasswordField();
		confPassField = new JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Teacher Registration");

		nameTagLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
		nameTagLabel.setText("Name:");

		positionTagLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
		positionTagLabel.setText("Position:");

		contactNumTagLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
		contactNumTagLabel.setText("Mobile no.:");

		emailTagLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
		emailTagLabel.setText("Email Address:");

		addrTagLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
		addrTagLabel.setText("Address:");

		userIDTagLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
		userIDTagLabel.setText("User ID:");

		passTagLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
		passTagLabel.setText("Password:");

		confPassLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
		confPassLabel.setText("Confirm Password:");

		wcLabel.setFont(new java.awt.Font("Algerian", 0, 24));
		wcLabel.setText("Welcome!!!");

		youAreServedFromLabel.setText("You are being served from:");

		hostLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 14));
		hostLabel.setText("Host:");
		
		hostAddrField.setText(ipAddr);
		hostAddrField.setEditable(false);

		portLabel.setFont(new java.awt.Font("Trebuchet MS", 1, 14));
		portLabel.setText("Port:");
		
		portField.setText("30010");
		portField.setEditable(false);

		closeButton.setBackground(new java.awt.Color(255, 0, 51));
		closeButton.setFont(new java.awt.Font("Eras Medium ITC", 1, 14));
		closeButton.setText("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeButtonActionPerformed(e);
			}
		});

		registerButton.setBackground(new java.awt.Color(0, 255, 51));
		registerButton
				.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18));
		registerButton.setText("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerButtonActionPerformed(e);
			}
		});

		goBackButton.setBackground(new java.awt.Color(255, 102, 51));
		goBackButton.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18));
		goBackButton.setText("< Back");
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBackButtonActionPerformed(e);
			}
		});

		positionComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Lecturer", "Assistant Professor",
						"Associate Professor", "Professor" }));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(40, 40, 40)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(closeButton)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
																.addGroup(
																		layout.createSequentialGroup()
																				.addComponent(
																						hostLabel)
																				.addGap(18,
																						18,
																						18)
																				.addComponent(
																						hostAddrField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						259,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(72,
																						72,
																						72)
																				.addComponent(
																						portLabel)
																				.addGap(18,
																						18,
																						18)
																				.addComponent(
																						portField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						259,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING,
																		layout.createSequentialGroup()
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																								.addComponent(
																										wcLabel,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										139,
																										Short.MAX_VALUE)
																								.addComponent(
																										nameTagLabel,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										positionTagLabel,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										contactNumTagLabel,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										emailTagLabel,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										addrTagLabel,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										userIDTagLabel,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										passTagLabel,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										confPassLabel,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										youAreServedFromLabel,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE))
																				.addGap(18,
																						18,
																						18)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										nameField)
																								.addComponent(
																										mobileNoField)
																								.addComponent(
																										emailField)
																								.addComponent(
																										addrField)
																								.addComponent(
																										userIDField)
																								.addComponent(
																										positionComboBox,
																										0,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										passField)
																								.addComponent(
																										confPassField))
																				.addGap(93,
																						93,
																						93))
																.addGroup(
																		layout.createSequentialGroup()
																				.addComponent(
																						goBackButton)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						registerButton))))
								.addContainerGap(56, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(36, 36, 36)
								.addComponent(wcLabel)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(youAreServedFromLabel)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(hostLabel)
												.addComponent(portLabel)
												.addComponent(
														hostAddrField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														portField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(closeButton)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						nameTagLabel)
																				.addComponent(
																						nameField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						positionTagLabel)
																				.addComponent(
																						positionComboBox,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						contactNumTagLabel)
																				.addComponent(
																						mobileNoField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						emailTagLabel)
																				.addComponent(
																						emailField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						addrTagLabel)
																				.addComponent(
																						addrField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						userIDTagLabel)
																				.addComponent(
																						userIDField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						passTagLabel)
																				.addComponent(
																						passField,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		confPassLabel))
												.addComponent(
														confPassField,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(37, 37, 37)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(goBackButton)
												.addComponent(registerButton))
								.addGap(54, 54, 54)));

		pack();
	}
	
	private void registerButtonActionPerformed(ActionEvent e) {
		strings = new String[8];
        strings[0] = nameField.getText();
        strings[1] = positionComboBox.getSelectedItem().toString();
        strings[2] = mobileNoField.getText();
        strings[3] = emailField.getText();
        strings[4] = addrField.getText();
        strings[5] = userIDField.getText();
        strings[6] = passField.getText();
        strings[7] = confPassField.getText();
        int errorflag = 0;
        for (int i = 0; i < 8; ++i) {
            if (strings[i].length() == 0) {
                JOptionPane.showMessageDialog(null, "Please fill up all the Fields");
                errorflag = 1;
                break;
            }
        }
        if (errorflag == 0) {
            if (!strings[6].equals(strings[7])) {
                JOptionPane.showMessageDialog(null, "Passwords don't match!");
                errorflag = 1;
            }
        }
     
        if (errorflag == 0) {
            TeacherElements a = new TeacherElements(strings[0], strings[4], strings[3], strings[2], strings[5], strings[6], strings[1]);
            try {
                System.out.println(a);
                Socket clientsocket = new Socket(getglobal(), 12345);
                PrintWriter pw = new PrintWriter(clientsocket.getOutputStream());
                pw.println("teacherregister");
                pw.flush();
                Socket newclientsocket = new Socket(getglobal(), 30010);

                ObjectOutputStream oos = new ObjectOutputStream(newclientsocket.getOutputStream());
                oos.writeObject(a);
                oos.flush();
                Scanner sc = new Scanner(newclientsocket.getInputStream());
                String feedback;
                while (true) {
                    feedback = sc.nextLine();
                    if (feedback.equals("Registration successful") || feedback.equals("Registration failed")) {
                        break;
                    } else if (feedback.equals("Invalid ID, User already has an account")) {
                        errorflag=1;
                        break;
                    }
                }
                if(feedback.equals("Registration failed")){
                    errorflag=1;
                }
                JOptionPane.showMessageDialog(null, feedback);
                newclientsocket.close();
              
            } catch (Exception ex) {
                System.out.println("Exception during serialization: " + ex);
                
            }
        }
        
        if(errorflag==0){
			//username,pw,type,levelTerm,pos,mobile,mail,stNo,addr,Id
			
			Database db = new Database("D:/eclipseJavaLuna/Combine_Try/necessary/Data.xml");
			username = strings[0];
			pw = strings[6];
			type = "teacher";
			levelTerm = "NULL";
			pos = strings[1];
			mobile = strings[2];
			mail = strings[3];
			stNo = "NULL";
			addr = strings[4];
			Id = strings[5];
			db.addUser(username,pw,type,levelTerm,pos,mobile,mail,stNo,addr,Id);
		}

	}
	
	private void goBackButtonActionPerformed(ActionEvent e){
		TeacherLogin a = new TeacherLogin(ipAddr);
        a.setLocationRelativeTo(null);
        a.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        a.setVisible(true);
        setVisible(false);
	}
	
	private void closeButtonActionPerformed(ActionEvent e){
		System.exit(0);
	}
	
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TeacherRegistry.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TeacherRegistry.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TeacherRegistry.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TeacherRegistry.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TeacherRegistry().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private JTextField addrField;
	private JLabel addrTagLabel;
	private JButton closeButton;
	private JPasswordField confPassField;
	private JLabel confPassLabel;
	private JLabel contactNumTagLabel;
	private JTextField emailField;
	private JLabel emailTagLabel;
	private JButton goBackButton;
	private JTextField hostAddrField;
	private JLabel hostLabel;
	private JTextField mobileNoField;
	private JTextField nameField;
	private JLabel nameTagLabel;
	private JPasswordField passField;
	private JLabel passTagLabel;
	private JTextField portField;
	private JLabel portLabel;
	private JComboBox positionComboBox;
	private JLabel positionTagLabel;
	private JButton registerButton;
	private JTextField userIDField;
	private JLabel userIDTagLabel;
	private JLabel wcLabel;
	private JLabel youAreServedFromLabel;
	// End of variables declaration
}
