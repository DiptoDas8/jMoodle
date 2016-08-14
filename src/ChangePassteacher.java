

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import static com.ui.generateIP.*;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ChangePassteacher extends JFrame {
	JLabel oldpass;
	JPasswordField oldp;
	JLabel newpass;
	JPasswordField newp;
	JLabel conpass;
	JPasswordField confirm;
	JButton save;
	public TeacherElements temp;
	private int fontsize = 18;
	public Font f1 = new Font("Serif", Font.BOLD, fontsize);

	public ChangePassteacher(TeacherElements std) {
		super("Password Change");
		temp = std;
		Container c = getContentPane();
		GroupLayout layout = new GroupLayout(c);
		c.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		oldpass = new JLabel("Old Password");
		oldpass.setFont(f1);
		newpass = new JLabel("New Password");
		newpass.setFont(f1);
		conpass = new JLabel("Confirm New Password");
		conpass.setFont(f1);
		newp = new JPasswordField();
		newp.setFont(f1);
		oldp = new JPasswordField();
		oldp.setFont(f1);
		confirm = new JPasswordField();
		confirm.setFont(f1);
		save = new JButton("Save");
		save.setSize(100, 30);
		layout.setHorizontalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING)
								.addComponent(oldpass).addComponent(newpass)
								.addComponent(conpass))

				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING)
								.addComponent(oldp).addComponent(newp)
								.addComponent(confirm).addComponent(save)));
		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(oldpass).addComponent(oldp))
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(newpass).addComponent(newp))
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(conpass).addComponent(confirm))
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE).addComponent(
								save))

		);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int errorflag = 0;
				if (!temp.getPass().equals(oldp.getText())) {
					JOptionPane.showMessageDialog(null,
							"Hey man!! Forgotten your old buddy, ya mad bro??");
					errorflag = 1;
				}
				if (errorflag == 0) {
					if (!newp.getText().equals(confirm.getText())) {
						JOptionPane
								.showMessageDialog(null,
										"DAPUQ!! You just typed it, do u have amnesia??");
						errorflag = 1;
					}
				}
				if (errorflag == 0) {
					temp.setPass(newp.getText());

					try {
						/* eikhane 1 */Socket clientsocket = new Socket(
								getglobal(), 12345);
						PrintWriter pw = new PrintWriter(clientsocket
								.getOutputStream());
						pw.println("changepassteacher");
						pw.flush();
						Socket newclientsocket = new Socket(getglobal(), 30002);

						/*
						 * client obj pathabe ouyputstream e, seita server
						 * inputstream e paia file e write korbe
						 */
						ObjectOutputStream oos = new ObjectOutputStream(
								newclientsocket.getOutputStream());
						oos.writeObject(temp);
						oos.flush();

						JOptionPane.showMessageDialog(null,
								"New Password saved!!");
						newclientsocket.close();
					} catch (Exception e) {
						System.out.println("Error Connecting with Server"
								);
						
					}
					TeacherInfo a = new TeacherInfo(temp.getUserID());
					a.setSize(500, 350);
					a.setVisible(true);
					a.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					setVisible(false);
				}

			}
		});

	}
}
