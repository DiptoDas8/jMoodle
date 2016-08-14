import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.ui.GuestLogin;

import static com.ui.generateIP.*;

public class StartUp extends JFrame {
	
	public String ipAddr;

	public StartUp() {
		super("Welcome to jMoodle");
		initComponents();
		teacherRadButton.setSelected(true);
		setResizable(false);
		IPokButton.setEnabled(false);
		IPokButton.setVisible(false);
		ipField.setText(getglobal());
		ipField.setEditable(false);
	}

	private void initComponents() {

		BUETlogoLabel = new JLabel();
		BUETnameLabel = new JLabel();
		CSEnameLabel = new JLabel();
		titleLabel = new JLabel();
		projectNameLabel = new JLabel();
		loginAccorPrivilegeLabel = new JLabel();
		teacherRadButton = new JRadioButton();
		studentRadButton = new JRadioButton();
		guestRadButton = new JRadioButton();
		proceedButton = new JButton();
		aboutButton = new JButton();
		closeButton = new JButton();
		ipLabel = new JLabel();
		ipField = new JTextField();
		changeIPButton = new JButton();
		IPokButton = new JButton();
		loginTypes = new ButtonGroup();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		BUETlogoLabel.setIcon(new javax.swing.ImageIcon(
				"C:\\Users\\DIPTO\\Downloads\\download.jpg"));

		BUETnameLabel.setFont(new Font("Old English Text MT", 0, 48));
		BUETnameLabel
				.setText("Bangladesh University of Engineering and Technology");

		CSEnameLabel.setFont(new Font("Cambria Math", 1, 36));
		CSEnameLabel.setText("Department of Computer Science and Engineering");

		titleLabel.setFont(new Font("Arial Unicode MS", 0, 25));
		titleLabel.setText("CSE 202 Term Project");

		projectNameLabel.setFont(new Font("Lucida Bright", 1, 24));
		projectNameLabel.setText("jMoodle");

		loginAccorPrivilegeLabel.setFont(new Font("Times New Roman", 1, 24));
		loginAccorPrivilegeLabel.setText("Login according to your privilege");

		loginTypes.add(teacherRadButton);
		teacherRadButton.setFont(new Font("Times New Roman", 0, 25));
		teacherRadButton.setText("Teacher");
		teacherRadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherRadButtonActionPerformed(e);
			}
		});

		loginTypes.add(studentRadButton);
		studentRadButton.setFont(new Font("Times New Roman", 0, 25));
		studentRadButton.setText("Student");
		studentRadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentRadButtonActionPerformed(e);
			}
		});

		loginTypes.add(guestRadButton);
		guestRadButton.setFont(new Font("Times New Roman", 0, 25));
		guestRadButton.setText("Guest");
		guestRadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guestRadButtonActionPerformed(e);
			}
		});

		proceedButton.setBackground(new Color(0, 255, 204));
		proceedButton.setFont(new Font("Calibri", 1, 24));
		proceedButton.setText("Proceed");
		proceedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proceedButtonActionPerformed(e);
			}
		});

		aboutButton.setBackground(new Color(153, 102, 255));
		aboutButton.setFont(new Font("Calibri", 1, 24));
		aboutButton.setText("About");

		closeButton.setBackground(new Color(255, 0, 0));
		closeButton.setFont(new Font("Calibri", 1, 24));
		closeButton.setText("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeButtonActionPerformed(e);
			}
		});

		ipLabel.setFont(new Font("Gadugi", 0, 24));
		ipLabel.setText("You are being served from");

		ipField.setFont(new Font("Courier New", 0, 18));
		ipField.setText("127.0.0.1");

		changeIPButton.setFont(new Font("AngsanaUPC", 1, 24));
		changeIPButton.setText("Change IP");
		changeIPButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeIPButtonActionPerformed(e);
			}
		});

		IPokButton.setFont(new Font("AngsanaUPC", 1, 24));
		IPokButton.setText("OK");
		IPokButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IPokButtonActionPerformed(e);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(19, 19, 19)
								.addComponent(BUETlogoLabel)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(123,
																		123,
																		123)
																.addComponent(
																		CSEnameLabel)
																.addGap(0,
																		0,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						BUETnameLabel,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						1090,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addGroup(
																																		layout.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.LEADING)
																																				.addComponent(
																																						loginAccorPrivilegeLabel,
																																						javax.swing.GroupLayout.PREFERRED_SIZE,
																																						410,
																																						javax.swing.GroupLayout.PREFERRED_SIZE)
																																				.addGroup(
																																						layout.createParallelGroup(
																																								javax.swing.GroupLayout.Alignment.TRAILING,
																																								false)
																																								.addComponent(
																																										guestRadButton,
																																										javax.swing.GroupLayout.DEFAULT_SIZE,
																																										javax.swing.GroupLayout.DEFAULT_SIZE,
																																										Short.MAX_VALUE)
																																								.addComponent(
																																										studentRadButton,
																																										javax.swing.GroupLayout.DEFAULT_SIZE,
																																										javax.swing.GroupLayout.DEFAULT_SIZE,
																																										Short.MAX_VALUE)
																																								.addComponent(
																																										teacherRadButton,
																																										javax.swing.GroupLayout.DEFAULT_SIZE,
																																										javax.swing.GroupLayout.DEFAULT_SIZE,
																																										Short.MAX_VALUE)))
																																.addPreferredGap(
																																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																																		javax.swing.GroupLayout.DEFAULT_SIZE,
																																		Short.MAX_VALUE))
																												.addGroup(
																														layout.createSequentialGroup()
																																.addComponent(
																																		closeButton,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		115,
																																		javax.swing.GroupLayout.PREFERRED_SIZE)
																																.addGap(212,
																																		212,
																																		212)
																																.addComponent(
																																		aboutButton,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		115,
																																		javax.swing.GroupLayout.PREFERRED_SIZE)
																																.addGap(192,
																																		192,
																																		192)))
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING,
																												false)
																												.addComponent(
																														ipLabel,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(
																														ipField)
																												.addGroup(
																														layout.createSequentialGroup()
																																.addGroup(
																																		layout.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.LEADING,
																																				false)
																																				.addComponent(
																																						proceedButton,
																																						javax.swing.GroupLayout.DEFAULT_SIZE,
																																						javax.swing.GroupLayout.DEFAULT_SIZE,
																																						Short.MAX_VALUE)
																																				.addComponent(
																																						changeIPButton,
																																						javax.swing.GroupLayout.DEFAULT_SIZE,
																																						javax.swing.GroupLayout.DEFAULT_SIZE,
																																						Short.MAX_VALUE))
																																.addGap(54,
																																		54,
																																		54)
																																.addComponent(
																																		IPokButton,
																																		javax.swing.GroupLayout.PREFERRED_SIZE,
																																		115,
																																		javax.swing.GroupLayout.PREFERRED_SIZE)))
																								.addGap(214,
																										214,
																										214))))
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(417,
																										417,
																										417)
																								.addComponent(
																										titleLabel))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(493,
																										493,
																										493)
																								.addComponent(
																										projectNameLabel)))
																.addContainerGap()))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(26, 26, 26)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		BUETnameLabel,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		65,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		CSEnameLabel)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		titleLabel)
																.addGap(18, 18,
																		18)
																.addComponent(
																		projectNameLabel,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		34,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(31, 31,
																		31))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		BUETlogoLabel)
																.addGap(24, 24,
																		24)))
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														ipLabel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														loginAccorPrivilegeLabel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(teacherRadButton)
												.addComponent(
														ipField,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														37,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														IPokButton,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						changeIPButton,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						41,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						studentRadButton))
																.addGap(0,
																		0,
																		Short.MAX_VALUE)))
								.addGap(18, 18, 18)
								.addComponent(guestRadButton)
								.addGap(67, 67, 67)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(closeButton)
												.addComponent(
														proceedButton,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														43,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														aboutButton,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														43,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		pack();
	}

	private void teacherRadButtonActionPerformed(ActionEvent e) {

	}

	private void studentRadButtonActionPerformed(ActionEvent e) {

	}

	private void guestRadButtonActionPerformed(ActionEvent e) {

	}

	private void proceedButtonActionPerformed(ActionEvent e) {
		if (teacherRadButton.isSelected() == true) {
			ipAddr = ipField.getText();
			TeacherLogin a = new TeacherLogin(ipAddr);
			a.setVisible(true);
			a.setLocationRelativeTo(null);
			a.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			dispose();
		} else if (studentRadButton.isSelected() == true) {
			ipAddr = ipField.getText();
			StudentLogin a = new StudentLogin(ipAddr);
			a.setVisible(true);
			a.setLocationRelativeTo(null);
			a.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			dispose();
		} else if (guestRadButton.isSelected() == true) {
			GuestLogin a = new GuestLogin();
			a.setVisible(true);
			a.setLocationRelativeTo(null);
			a.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			dispose();
		}
	}

	private void closeButtonActionPerformed(ActionEvent e) {
		System.exit(0);
	}

	private void changeIPButtonActionPerformed(ActionEvent e) {
		ipField.setEditable(true);
		changeIPButton.setEnabled(false);
		closeButton.setEnabled(false);
		proceedButton.setEnabled(false);
		aboutButton.setEnabled(false);
		IPokButton.setEnabled(true);
		IPokButton.setVisible(true);
	}

	private void IPokButtonActionPerformed(ActionEvent e) {
		IPokButton.setEnabled(false);
		IPokButton.setVisible(false);
		setglobal(ipField.getText());
		ipField.setText(getglobal());
		ipField.setEditable(false);
		changeIPButton.setEnabled(true);
		proceedButton.setEnabled(true);
		closeButton.setEnabled(true);
		aboutButton.setEnabled(true);
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
			java.util.logging.Logger.getLogger(StartUp.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(StartUp.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(StartUp.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(StartUp.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new StartUp().setVisible(true);
			}
		});
	}

	private JLabel BUETlogoLabel;
	private JLabel BUETnameLabel;
	private JLabel CSEnameLabel;
	private JButton aboutButton;
	private JButton changeIPButton;
	private JButton closeButton;
	private JRadioButton guestRadButton;
	private JTextField ipField;
	private JLabel ipLabel;
	private JLabel loginAccorPrivilegeLabel;
	private JButton IPokButton;
	private JButton proceedButton;
	private JLabel projectNameLabel;
	private JRadioButton studentRadButton;
	private JRadioButton teacherRadButton;
	private JLabel titleLabel;

	private ButtonGroup loginTypes;
}
