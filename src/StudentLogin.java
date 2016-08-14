import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import static com.ui.generateIP.*;

public class StudentLogin extends javax.swing.JFrame {
	public String ipAddr;

	public StudentLogin() {
		initComponents();
		invalidLabel.setVisible(false);
	}

	public StudentLogin(String ipAddr) {
		this.ipAddr = ipAddr;
		initComponents();
		invalidLabel.setVisible(false);
	}

	private void initComponents() {

		studentLoginLabel = new JLabel();
		serverHostNPortLabel = new JLabel();
		hostAddrField = new JTextField();
		hostLabel = new JLabel();
		portLabel = new JLabel();
		portField = new JTextField();
		userIDLabel = new JLabel();
		userIDField = new JTextField();
		passwordLabel = new JLabel();
		passwordField = new JPasswordField();
		signinButton = new JButton();
		donthaveAccLabel = new JLabel();
		signUpButton = new JButton();
		goBackButton = new JButton();
		closeButton = new JButton();
		invalidLabel = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});
		setTitle("Student Login");

		studentLoginLabel.setFont(new Font("Calibri", 0, 36));
		studentLoginLabel.setText("Hello !!!");

		serverHostNPortLabel.setFont(new Font("Times New Roman", 0, 14));
		serverHostNPortLabel.setText("You are being served from: ");

		hostLabel.setFont(new Font("Times New Roman", 1, 14));
		hostLabel.setText("Host: ");

		hostAddrField.setText(ipAddr);
		hostAddrField.setEditable(false);

		portLabel.setFont(new Font("Times New Roman", 1, 14));
		portLabel.setText("Port:");

		portField.setText("30011");
		portField.setEditable(false);

		userIDLabel.setFont(new Font("Cambria Math", 0, 18));
		userIDLabel.setText("User ID:");

		passwordLabel.setFont(new Font("Cambria Math", 0, 18));
		passwordLabel.setText("Password:");

		signinButton.setFont(new Font("Arial Rounded MT Bold", 0, 18));
		signinButton.setText("Sign in");
		signinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signinButtonActionPerformed(e);
			}
		});

		invalidLabel.setForeground(new Color(255, 12, 45));
		invalidLabel.setFont(new Font("Courier new", 0, 14));
		invalidLabel.setText("Wrong ID or password! Try again");

		donthaveAccLabel.setFont(new Font("Bell MT", 1, 24));
		donthaveAccLabel.setText("Don't have an account?");

		signUpButton.setFont(new Font("Tahoma", 1, 11));
		signUpButton.setText("Sign Up");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUpButtonActionPerformed(e);
			}
		});

		goBackButton.setFont(new Font("David", 0, 18));
		goBackButton.setText("<<< Go Back");
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBackButtonActionPerformed(e);
			}
		});

		closeButton.setBackground(new Color(255, 0, 0));
		closeButton.setFont(new Font("Cambria", 1, 20));
		closeButton.setText("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeButtonActionPerformed(e);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(71, 71, 71)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(goBackButton)
												.addComponent(studentLoginLabel)
												.addComponent(
														serverHostNPortLabel,
														GroupLayout.PREFERRED_SIZE,
														171,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(invalidLabel)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.TRAILING,
																				false)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										userIDLabel,
																										GroupLayout.PREFERRED_SIZE,
																										74,
																										GroupLayout.PREFERRED_SIZE)
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										userIDField))
																				.addGroup(
																						GroupLayout.Alignment.LEADING,
																						layout.createSequentialGroup()
																								.addComponent(
																										hostLabel,
																										GroupLayout.PREFERRED_SIZE,
																										60,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										hostAddrField,
																										GroupLayout.PREFERRED_SIZE,
																										231,
																										GroupLayout.PREFERRED_SIZE)
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										portLabel,
																										GroupLayout.PREFERRED_SIZE,
																										60,
																										GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										passwordLabel)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										passwordField,
																										GroupLayout.PREFERRED_SIZE,
																										282,
																										GroupLayout.PREFERRED_SIZE))
																				.addComponent(
																						donthaveAccLabel,
																						GroupLayout.Alignment.LEADING,
																						GroupLayout.PREFERRED_SIZE,
																						258,
																						GroupLayout.PREFERRED_SIZE))
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										portField,
																										GroupLayout.PREFERRED_SIZE,
																										224,
																										GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addGap(65,
																										65,
																										65)
																								.addGroup(
																										layout.createParallelGroup(
																												GroupLayout.Alignment.LEADING,
																												false)
																												.addComponent(
																														signUpButton,
																														GroupLayout.DEFAULT_SIZE,
																														GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(
																														signinButton,
																														GroupLayout.DEFAULT_SIZE,
																														165,
																														Short.MAX_VALUE)))))
												.addComponent(
														closeButton,
														GroupLayout.Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE,
														165,
														GroupLayout.PREFERRED_SIZE))
								.addContainerGap(54, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(53, 53, 53)
								.addComponent(studentLoginLabel)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(serverHostNPortLabel,
										GroupLayout.PREFERRED_SIZE, 27,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(
														portField,
														GroupLayout.PREFERRED_SIZE,
														29,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														portLabel,
														GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(
														layout.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
																.addComponent(
																		hostAddrField,
																		GroupLayout.PREFERRED_SIZE,
																		29,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		hostLabel,
																		GroupLayout.PREFERRED_SIZE,
																		29,
																		GroupLayout.PREFERRED_SIZE)))
								.addGap(18, 18, 18)
								.addComponent(closeButton,
										GroupLayout.PREFERRED_SIZE, 46,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						userIDField,
																						GroupLayout.PREFERRED_SIZE,
																						29,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						userIDLabel,
																						GroupLayout.PREFERRED_SIZE,
																						29,
																						GroupLayout.PREFERRED_SIZE))
																.addGap(16, 16,
																		16)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.BASELINE)
																				.addComponent(
																						passwordField,
																						GroupLayout.PREFERRED_SIZE,
																						30,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						passwordLabel,
																						GroupLayout.PREFERRED_SIZE,
																						30,
																						GroupLayout.PREFERRED_SIZE)))
												.addComponent(
														signinButton,
														GroupLayout.PREFERRED_SIZE,
														76,
														GroupLayout.PREFERRED_SIZE))
								.addGap(10, 10, 10)
								.addComponent(invalidLabel)
								.addGap(39, 39, 39)
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(
														donthaveAccLabel,
														GroupLayout.PREFERRED_SIZE,
														38,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(
														signUpButton,
														GroupLayout.PREFERRED_SIZE,
														38,
														GroupLayout.PREFERRED_SIZE))
								.addGap(36, 36, 36)
								.addComponent(goBackButton,
										GroupLayout.PREFERRED_SIZE, 38,
										GroupLayout.PREFERRED_SIZE)
								.addGap(45, 45, 45)));

		pack();
	}

	private void closeButtonActionPerformed(ActionEvent e) {
		System.exit(0);
	}

	private void signinButtonActionPerformed(ActionEvent e) {
		StudentElements a = new StudentElements(" ", " ", " ", " ",
				userIDField.getText(), " ", " ", passwordField.getText());
		try {
			Socket clientsocket = new Socket(getglobal(), 12345);
			PrintWriter pw = new PrintWriter(clientsocket.getOutputStream());
			pw.println("studentlogin");
			pw.flush();
			Socket newclientsocket = new Socket(getglobal(), 30011);
			ObjectOutputStream oos = new ObjectOutputStream(
					newclientsocket.getOutputStream());
			oos.writeObject(a);
			oos.flush();
			Scanner sc = new Scanner(newclientsocket.getInputStream());
			String feedback;
			while (true) {
				feedback = sc.nextLine();
				if (feedback.equals("Right") || feedback.equals("Wrong")) {
					break;
				}
			}
			newclientsocket.close();
			if (feedback.equals("Right")) {
				StudentInfo p = new StudentInfo(userIDField.getText());
				p.setLocationRelativeTo(null);
				p.setVisible(true);
				p.setSize(500, 350);
				p.setResizable(false);
				p.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				setVisible(false);
			} else {
				invalidLabel.setVisible(true);
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	private void signUpButtonActionPerformed(ActionEvent e) {
		StudentRegistry a = new StudentRegistry(ipAddr);
		this.setVisible(false);
		a.setVisible(true);
		a.setLocationRelativeTo(null);
		a.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	private void goBackButtonActionPerformed(ActionEvent e) {
		StartUp a = new StartUp();
		a.setVisible(true);
		a.setLocationRelativeTo(null);
		a.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(false);
	}

	private void formWindowClosed(java.awt.event.WindowEvent evt) {
		System.out.println("bondho hoisi");
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
			java.util.logging.Logger.getLogger(StudentLogin.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(StudentLogin.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(StudentLogin.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(StudentLogin.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new StudentLogin().setVisible(true);
			}
		});
	}

	private JButton closeButton;
	private JLabel donthaveAccLabel;
	private JButton goBackButton;
	private JTextField hostAddrField;
	private JLabel hostLabel;
	private JPasswordField passwordField;
	private JLabel passwordLabel;
	private JTextField portField;
	private JLabel portLabel;
	private JLabel serverHostNPortLabel;
	private JButton signUpButton;
	private JButton signinButton;
	private JLabel studentLoginLabel;
	private JTextField userIDField;
	private JLabel userIDLabel;
	private JLabel invalidLabel;
}
