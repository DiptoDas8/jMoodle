package com.socket;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;

public class ServerFrame extends JFrame {

	public SocketServer server;
	public Thread serverThread;
	public String filePath = "Data.xml";
	public JFileChooser fileChooser;

	public ServerFrame() {
		initComponents();
		databaseNameField.setEditable(false);
		databaseNameField.setBackground(Color.WHITE);

		fileChooser = new JFileChooser();
		statusArea.setEditable(false);
	}

	public boolean isWin32() {
		return System.getProperty("os.name").startsWith("Windows");
	}

	private void initComponents() {

		startServerButton = new JButton();
		jScrollPane1 = new JScrollPane();
		statusArea = new JTextArea();
		databaseFileLabel = new JLabel();
		databaseNameField = new JTextField();
		fileBrowseButton = new JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("jServer");

		startServerButton.setText("Start Server");
		startServerButton.setEnabled(false);
		startServerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				startServerButtonActionPerformed(evt);
			}
		});

		statusArea.setColumns(20);
		statusArea.setFont(new Font("Consolas", 0, 12));
		statusArea.setRows(5);
		jScrollPane1.setViewportView(statusArea);

		databaseFileLabel.setText("Database File : ");

		fileBrowseButton.setText("Browse...");
		fileBrowseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				fileBrowseButtonActionPerformed(evt);
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
												.addComponent(jScrollPane1)
												.addGroup(
														GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		databaseFileLabel)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(
																		databaseNameField,
																		GroupLayout.DEFAULT_SIZE,
																		282,
																		Short.MAX_VALUE)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		fileBrowseButton,
																		GroupLayout.PREFERRED_SIZE,
																		91,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		startServerButton)))
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(databaseNameField,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(databaseFileLabel)
										.addComponent(fileBrowseButton)
										.addComponent(startServerButton))
						.addPreferredGap(
								LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE,
								287, Short.MAX_VALUE).addContainerGap()));

		pack();
	}

	private void startServerButtonActionPerformed(ActionEvent evt) {
		server = new SocketServer(this);
		startServerButton.setEnabled(false);
		fileBrowseButton.setEnabled(false);
	}

	public void RetryStart(int port) {
		if (server != null) {
			server.stop();
		}
		server = new SocketServer(this, port);
	}

	private void fileBrowseButtonActionPerformed(ActionEvent evt) {
		fileChooser.showDialog(this, "Select");
		File file = fileChooser.getSelectedFile();

		if (file != null) {
			filePath = file.getPath();
			if (this.isWin32()) {
				filePath = filePath.replace("\\", "/");
			}
			databaseNameField.setText(filePath);
			startServerButton.setEnabled(true);
		}
	}

	public static void main(String args[]) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			System.out.println("Look & Feel Exception");
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ServerFrame serverFrameObj = new ServerFrame();
				serverFrameObj.setVisible(true);
			}
		});
	}

	private JButton startServerButton;
	private JButton fileBrowseButton;
	private JLabel databaseFileLabel;
	private JScrollPane jScrollPane1;
	public JTextArea statusArea;
	private JTextField databaseNameField;

}
