package com.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SyllabusView extends javax.swing.JFrame {

	private String[] CSEterms = { "CSE11.txt", "CSE12.txt", "CSE21.txt",
			"CSE22.txt", "CSE31.txt", "CSE32.txt", "CSE41.txt", "CSE42.txt" };

	private String[] CSELT = { "Level 1 Term 1", "Level 1 Term 2",
			"Level 2 Term 1", "Level 2 Term 2", "Level 3 Term 1",
			"Level 3 Term 2", "Level 4 Term 1", "Level 4 Term 2" };
	private int selectedLT;

	public SyllabusView() {

	}

	public SyllabusView(int selectedLevelTermSerial) {
		// TODO Auto-generated constructor stub
		selectedLT = selectedLevelTermSerial;
		initComponents();
	}

	private void initComponents() {

		syllabusForLabel = new JLabel();
		syllTxtPane = new JScrollPane();
		syllTextArea = new JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("CSE syllabus");

		//syllabusForLabel.setVer
		syllabusForLabel.setFont(new java.awt.Font("Tahoma", 0, 32));
		syllabusForLabel.setText("Study Plan for " + CSELT[selectedLT]);

		try {
			FileInputStream fstream = new FileInputStream("D:\\eclipseJavaLuna\\Combine_Try\\Syllabus\\"
					+ CSEterms[selectedLT]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			syllTextArea = new JTextArea(20, 50);
			syllTextArea.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14));
			try {
				syllTextArea.read(br, null);
				syllTextArea.setEditable(false);
				syllTxtPane = new JScrollPane(syllTextArea,
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// Doesn't iterate VAAB

			syllTxtPane = new JScrollPane(syllTextArea,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			syllTextArea.setColumns(20);
			syllTextArea.setRows(5);
			syllTextArea.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14));
			syllTextArea.setEditable(false);
			syllTxtPane.setViewportView(syllTextArea);
			e.printStackTrace();
		}

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(49, 49, 49)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING,
												false)
												.addComponent(
														syllTxtPane,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														591, Short.MAX_VALUE)
												.addComponent(
														syllabusForLabel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addContainerGap(56, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(30, 30, 30)
						.addComponent(syllabusForLabel,
								javax.swing.GroupLayout.PREFERRED_SIZE, 31,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(51, 51, 51)
						.addComponent(syllTxtPane,
								javax.swing.GroupLayout.PREFERRED_SIZE, 327,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(47, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

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
			java.util.logging.Logger.getLogger(SyllabusView.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SyllabusView.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SyllabusView.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SyllabusView.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SyllabusView().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private JScrollPane syllTxtPane;
	private JTextArea syllTextArea;
	private JLabel syllabusForLabel;
	// End of variables declaration
}
