package com.ui;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.socket.SyllabusView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DIPTO
 */
public class GuestMenu extends JFrame {

	/**
	 * Creates new form GuestMenu
	 */
	
	public int selectedLevelTermSerial;
	
	private static String[] LevelTermArray = { "Level-1,Term-1",
		"Level-1,Term-2", "Level-2,Term-1", "Level-2,Term-2",
		"Level-3,Term-1", "Level-3,Term-2", "Level-4,Term-1",
		"Level-4,Term-2" };
	
	public GuestMenu(int i) {
		selectedLevelTermSerial = i;
		initComponents();
	}

	public GuestMenu() {
		// TODO Auto-generated constructor stub
	}

	private void initComponents() {
		//System.out.println(selectedLevelTerm);
		syllabusButton = new javax.swing.JButton();
		routineButton = new javax.swing.JButton();
		overviewButton = new javax.swing.JButton();
		goBackButton = new javax.swing.JButton();
		guestMenuHolaLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Guest Menu");

		syllabusButton.setText("Syllabus");
		syllabusButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				syllabusButtonActionPerformed(evt);
			}
		});

		routineButton.setText("Routine");

		overviewButton.setText("Overview");
		overviewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				overviewButtonActionPerformed(evt);
			}
		});

		goBackButton.setText("<<<Go Back");

		guestMenuHolaLabel.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
		//setLT(String s);
		guestMenuHolaLabel.setText("Guest view for "+LevelTermArray[selectedLevelTermSerial]);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(45, 45, 45)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														guestMenuHolaLabel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						overviewButton,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						113,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																								.addComponent(
																										routineButton,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										syllabusButton,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										113,
																										Short.MAX_VALUE)))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		98,
																		Short.MAX_VALUE)
																.addComponent(
																		goBackButton)))
								.addGap(49, 49, 49)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(60, 60, 60)
								.addComponent(guestMenuHolaLabel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(19, 19,
																		19)
																.addComponent(
																		syllabusButton,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		41,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		routineButton,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		41,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18,
																		18)
																.addComponent(
																		overviewButton,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		41,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addContainerGap(
																		57,
																		Short.MAX_VALUE))
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		goBackButton,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		31,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(28, 28,
																		28)))));

		pack();
	}// </editor-fold>

	private void overviewButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		JOptionPane
				.showMessageDialog(
						null,
						"The department of Computer Science and Engineering (CSE)\n"
								+ " of Bangladesh University of Engineering and Technology (BUET) \n"
								+ "is the first department of its kind in Bangladesh.\n"
								+ "BUET offers Bachelors, Masters, and Ph.D. Degree in Computer Science and Engineering.\n"
								+ "The Education of CSE BUET is world class in both the Curricula and Research activity.\n"
								+ "\n"
								+ "\n"
								+ "The best students from all over Bangladesh join this prestigious department.\n"
								+ "The highly competitive environment,\n"
								+ "world-class facilities and the hard working faculties nourish every student to be a prime of the field.\n"
								+ "Currently there are about 700 students studying in Undergraduate Program and about 40 students in Graduate Program.");

	}

	private void syllabusButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        SyllabusView syllobj = new SyllabusView(selectedLevelTermSerial);
        syllobj.setVisible(true);
        syllobj.setSize(696, 486);
		syllobj.setLocationRelativeTo(null);
		syllobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
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
			java.util.logging.Logger.getLogger(GuestMenu.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GuestMenu.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GuestMenu.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GuestMenu.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GuestMenu().setVisible(true);
			}
		});
		
	}

	// Variables declaration - do not modify
	private javax.swing.JButton goBackButton;
	private javax.swing.JLabel guestMenuHolaLabel;
	private javax.swing.JButton overviewButton;
	private javax.swing.JButton routineButton;
	private javax.swing.JButton syllabusButton;
	// End of variables declaration

}
