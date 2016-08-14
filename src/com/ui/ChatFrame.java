package com.ui;

import com.socket.History;
import com.socket.Message;
import com.socket.SocketClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class ChatFrame extends JFrame {

	public SocketClient client;
	public int port;
	public String serverAddr, username, password;
	public Thread clientThread;
	public DefaultListModel model;
	public File file;
	public String historyFile = "X:/History.xml";
	public HistoryFrame historyFrame;
	public History hist;
	public String passedUserID, passedUserPass;
	public boolean enabler;
	
	public ChatFrame(String Id, String pw) {
		passedUserID = Id;
		passedUserPass = pw;
		
		initComponents();
		this.setTitle("jMessenger");
		model.addElement("All");
		recipientList.setSelectedIndex(0);

		historyfileField.setEditable(false);

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					client.send(new Message("message", username, ".bye",
							"SERVER"));
					clientThread.stop();
				} catch (Exception ex) {

				}
			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}
		});

		hist = new History(historyFile);
	}

	public ChatFrame() {
		initComponents();
		this.setTitle("jMessenger");
		model.addElement("All");
		recipientList.setSelectedIndex(0);

		historyfileField.setEditable(true);

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					client.send(new Message("message", username, ".bye",
							"SERVER"));
					clientThread.stop();
				} catch (Exception ex) {

				}
			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}
		});

		hist = new History(historyFile);
	}

	public boolean isWin32() {
		return System.getProperty("os.name").startsWith("Windows");
	}
	
	public void setIdPass(String UserID,String UserPass,boolean enabler)
	{
		passedUserID = UserID;
		passedUserPass = UserPass;
		this.enabler = enabler;
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		hostAddressLabel = new JLabel();
		hostNameField = new JTextField();
		hostPortLabel = new JLabel();
		portField = new JTextField();
		connectButton = new JButton();
		userNameField = new JTextField();
		passwordLabel = new JLabel();
		usernameLabel = new JLabel();
		signupButton = new JButton();
		passwordField = new JPasswordField();
		jSeparator1 = new JSeparator();
		jScrollPane1 = new JScrollPane();
		messageArea = new JTextArea();
		recipientPane = new JScrollPane();
		recipientList = new JList();
		writeMessageLabel = new JLabel();
		newMessageField = new JTextField();
		sendMessageButton = new JButton();
		loginButton = new JButton();
		jSeparator2 = new JSeparator();
		filepathField = new JTextField();
		fileBrowseButton = new JButton();
		fileSendButton = new JButton();
		filepathLabel = new JLabel();
		historyFileLabel = new JLabel();
		historyfileField = new JTextField();
		historyfileBrowseButton = new JButton();
		historyfileShowButton = new JButton();

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		hostAddressLabel.setText("Host Address : ");

		hostNameField.setText("localhost");
		hostNameField.setEnabled(true);

		hostPortLabel.setText("Host Port : ");

		portField.setText("13000");
		portField.setEnabled(true);

		connectButton.setText("Connect");
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				connectButtonActionPerformed(evt);
			}
		});

		usernameLabel.setText("Username :");
		userNameField.setText(passedUserID);
		userNameField.setToolTipText("Your username");
		userNameField.setEnabled(false);

		passwordLabel.setText("Password :");
		passwordField.setText(passedUserPass);
		passwordField.setToolTipText("Your password");
		passwordField.setEnabled(false);

		signupButton.setText("SignUp");
		signupButton.setEnabled(true);
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				signupButtonActionPerformed(evt);
			}
		});
		signupButton.setVisible(false);

		messageArea.setColumns(20);
		messageArea.setFont(new java.awt.Font("Consolas", 0, 12));
		messageArea.setRows(5);
		jScrollPane1.setViewportView(messageArea);

		recipientList.setModel((model = new DefaultListModel()));
		recipientPane.setViewportView(recipientList);

		writeMessageLabel.setText("Message : ");

		sendMessageButton.setText("Send Message ");
		sendMessageButton.setEnabled(false);
		sendMessageButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						sendMessageButtonActionPerformed(evt);
					}
				});

		loginButton.setText("Login");
		loginButton.setEnabled(true);
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginButtonActionPerformed(evt);
			}
		});

		fileBrowseButton.setText("...");
		fileBrowseButton.setEnabled(false);
		fileBrowseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fileBrowseButtonActionPerformed(evt);
			}
		});

		fileSendButton.setText("Send");
		fileSendButton.setEnabled(false);
		fileSendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fileSendButtonActionPerformed(evt);
			}
		});

		filepathLabel.setText("File :");

		historyFileLabel.setText("History File :");

		historyfileBrowseButton.setText("...");
		historyfileBrowseButton.setEnabled(false);
		historyfileBrowseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				historyfileBrowseButtonActionPerformed(evt);
			}
		});

		historyfileShowButton.setText("Show");
		historyfileShowButton.setEnabled(false);
		historyfileShowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				historyfileShowButtonActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addComponent(jSeparator2)
												.addComponent(
														jSeparator1,
														GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.TRAILING)
																				.addComponent(
																						hostAddressLabel)
																				.addComponent(
																						usernameLabel)
																				.addComponent(
																						historyFileLabel))
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												GroupLayout.Alignment.LEADING)
																												.addComponent(
																														userNameField)
																												.addComponent(
																														hostNameField))
																								.addGap(18,
																										18,
																										18)
																								.addGroup(
																										layout.createParallelGroup(
																												GroupLayout.Alignment.TRAILING)
																												.addComponent(
																														hostPortLabel)
																												.addComponent(
																														passwordLabel))
																								.addPreferredGap(
																										LayoutStyle.ComponentPlacement.UNRELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												GroupLayout.Alignment.LEADING)
																												.addComponent(
																														portField)
																												.addComponent(
																														passwordField)))
																				.addComponent(
																						historyfileField))
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						connectButton,
																						GroupLayout.Alignment.TRAILING,
																						GroupLayout.DEFAULT_SIZE,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addGroup(
																						GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												GroupLayout.Alignment.TRAILING)
																												.addComponent(
																														loginButton,
																														GroupLayout.PREFERRED_SIZE,
																														70,
																														GroupLayout.PREFERRED_SIZE)
																												.addComponent(
																														historyfileBrowseButton,
																														GroupLayout.PREFERRED_SIZE,
																														70,
																														GroupLayout.PREFERRED_SIZE))
																								.addPreferredGap(
																										LayoutStyle.ComponentPlacement.RELATED)
																								.addGroup(
																										layout.createParallelGroup(
																												GroupLayout.Alignment.LEADING,
																												false)
																												.addComponent(
																														historyfileShowButton,
																														GroupLayout.DEFAULT_SIZE,
																														GroupLayout.DEFAULT_SIZE,
																														Short.MAX_VALUE)
																												.addComponent(
																														signupButton,
																														GroupLayout.DEFAULT_SIZE,
																														81,
																														Short.MAX_VALUE)))))
												.addGroup(
														GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jScrollPane1)
																.addGap(18, 18,
																		18)
																.addComponent(
																		recipientPane,
																		GroupLayout.PREFERRED_SIZE,
																		108,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(23, 23,
																		23)
																.addComponent(
																		filepathLabel)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		filepathField,
																		GroupLayout.PREFERRED_SIZE,
																		378,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		fileBrowseButton,
																		GroupLayout.PREFERRED_SIZE,
																		27,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		fileSendButton,
																		GroupLayout.PREFERRED_SIZE,
																		77,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		writeMessageLabel)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		newMessageField)
																.addGap(18, 18,
																		18)
																.addComponent(
																		sendMessageButton,
																		GroupLayout.PREFERRED_SIZE,
																		108,
																		GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(hostAddressLabel)
										.addComponent(hostNameField,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(hostPortLabel)
										.addComponent(portField,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(connectButton))
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(userNameField,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordLabel)
										.addComponent(usernameLabel)
										.addComponent(signupButton)
										.addComponent(passwordField,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(loginButton))
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(historyFileLabel)
										.addComponent(historyfileField,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(historyfileBrowseButton)
										.addComponent(historyfileShowButton))
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE,
								10, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.LEADING, false)
										.addComponent(jScrollPane1)
										.addComponent(recipientPane,
												GroupLayout.DEFAULT_SIZE, 264,
												Short.MAX_VALUE))
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(sendMessageButton)
										.addComponent(writeMessageLabel)
										.addComponent(newMessageField,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE,
								10, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE, false)
										.addComponent(fileSendButton,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(fileBrowseButton,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(filepathLabel)
										.addComponent(filepathField,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		pack();
	}

	private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_connectButtonActionPerformed
		serverAddr = hostNameField.getText();
		port = Integer.parseInt(portField.getText());

		if (!serverAddr.isEmpty() && !portField.getText().isEmpty()) {
			try {
				client = new SocketClient(this);
				clientThread = new Thread(client);
				clientThread.start();
				client.send(new Message("test", "testUser", "testContent",
						"SERVER"));
			} catch (Exception ex) {
				messageArea.append("[Application > Me] : Server not found\n");
			}
		}
	}

	private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
		username = userNameField.getText();
		password = passwordField.getText();

		if (!username.isEmpty() && !password.isEmpty()) {
			client.send(new Message("login", username, password, "SERVER"));
		}
	}

	private void sendMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String msg = newMessageField.getText();
		String target = recipientList.getSelectedValue().toString();

		if (!msg.isEmpty() && !target.isEmpty()) {
			newMessageField.setText("");
			client.send(new Message("message", username, msg, target));
		}
	}

	private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {
		username = userNameField.getText();
		password = passwordField.getText();

		if (!username.isEmpty() && !password.isEmpty()) {
			client.send(new Message("signup", username, password, "SERVER"));
		}
	}

	private void fileBrowseButtonActionPerformed(ActionEvent evt) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showDialog(this, "Select File");
		file = fileChooser.getSelectedFile();

		if (file != null) {
			if (!file.getName().isEmpty()) {
				fileSendButton.setEnabled(true);
				String str;

				if (filepathField.getText().length() > 30) {
					String t = file.getPath();
					str = t.substring(0, 20) + " [...] "
							+ t.substring(t.length() - 20, t.length());
				} else {
					str = file.getPath();
				}
				filepathField.setText(str);
			}
		}
	}

	private void fileSendButtonActionPerformed(ActionEvent evt) {
		long size = file.length();
		if (size < 120 * 1024 * 1024) {
			client.send(new Message("upload_req", username, file.getName(),
					recipientList.getSelectedValue().toString()));
		} else {
			messageArea.append("[Application > Me] : File is size too large\n");
		}
	}

	private void historyfileBrowseButtonActionPerformed(ActionEvent evt) {
		JFileChooser jf = new JFileChooser();
		jf.showDialog(this, "Select File");

		if (!jf.getSelectedFile().getPath().isEmpty()) {
			historyFile = jf.getSelectedFile().getPath();
			if (this.isWin32()) {
				historyFile = historyFile.replace("/", "\\");
			}
			historyfileField.setText(historyFile);
			historyfileField.setEditable(false);
			historyfileBrowseButton.setEnabled(false);
			historyfileShowButton.setEnabled(true);
			hist = new History(historyFile);

			historyFrame = new HistoryFrame(hist);
			historyFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			historyFrame.dispose();
		}
	}

	private void historyfileShowButtonActionPerformed(ActionEvent evt) {
		historyFrame.setLocation(this.getLocation());
		historyFrame.setVisible(true);
	}

	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			System.out.println("Look & Feel exception");
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ChatFrame().setVisible(true);
			}
		});
	}

	public JButton connectButton;
	public JButton loginButton;
	public JButton signupButton;
	public JButton sendMessageButton;
	public JButton fileBrowseButton;
	public JButton fileSendButton;
	public JButton historyfileBrowseButton;
	public JButton historyfileShowButton;
	private JLabel hostAddressLabel;
	private JLabel hostPortLabel;
	private JLabel passwordLabel;
	private JLabel usernameLabel;
	private JLabel writeMessageLabel;
	private JLabel filepathLabel;
	private JLabel historyFileLabel;
	public JList recipientList;
	public JPasswordField passwordField;
	private JScrollPane jScrollPane1;
	private JScrollPane recipientPane;
	private JSeparator jSeparator1;
	private JSeparator jSeparator2;
	public JTextArea messageArea;
	public JTextField hostNameField;
	public JTextField portField;
	public JTextField userNameField;
	public JTextField newMessageField;
	public JTextField filepathField;
	public JTextField historyfileField;

}
