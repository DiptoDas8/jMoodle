
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import static com.ui.generateIP.*;
import com.socket.Message;
import com.ui.ChatFrame; //notun

import java.io.ObjectOutputStream;

public class StudentInfo extends JFrame {

    public ChatFrame chatFrameObj = new ChatFrame();

    JLabel namelabel;
    JLabel name;
    JLabel LTlabel;
    JLabel LT;
    JLabel Mobilelabel;
    JLabel Mobile;
    JLabel Emaillabel;
    JLabel Email;
    JLabel StdNolabel;
    JLabel StdNo;
    JLabel Addresslabel;
    JLabel Address;

    private int fontsize = 24;
    public Font f1 = new Font("Serif", Font.BOLD, fontsize);
    private final Color[] colorValues = {Color.BLACK, Color.BLUE, Color.RED,
        Color.GREEN, Color.YELLOW, Color.ORANGE, Color.GRAY, Color.WHITE,
        Color.CYAN, Color.MAGENTA, Color.PINK};
    private JRadioButtonMenuItem[] fcolor;
    private JRadioButtonMenuItem[] bcolor;
    private JCheckBoxMenuItem[] style;
    private JRadioButtonMenuItem[] font;
    public StudentElements std;
    String[] fontnames = {"Serif", "Monospaced", "SansSerif"};
    public String userId, userPass;

    public StudentInfo(String s) {
        super("Student Info");

        try {
            // StudentElements std=new StudentElements("","","","","","","","");
            Socket clientsocket = new Socket(getglobal(), 12345);
            PrintWriter pw = new PrintWriter(clientsocket.getOutputStream());
            pw.println("studentinfo");
            pw.flush();
            Socket newclientsocket = new Socket(getglobal(), 30007);
            PrintWriter pa = new PrintWriter(newclientsocket.getOutputStream());
            pa.println(s);
            pa.flush();
            ObjectInputStream ois = new ObjectInputStream(
                    newclientsocket.getInputStream());
            while (true) {
                std = (StudentElements) ois.readObject();
                if ((std.getStndID()).equals(s)) {
                    break;
                }
            }
            newclientsocket.close();
            Container c = getContentPane();
            GroupLayout layout = new GroupLayout(c);
            c.setLayout(layout);
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);
            namelabel = new JLabel("Name:");
            namelabel.setFont(f1);
            LTlabel = new JLabel("Level/Term:");
            LTlabel.setFont(f1);
            Mobilelabel = new JLabel("Mobile Number:");
            Mobilelabel.setFont(f1);
            Emaillabel = new JLabel("Email Address:");
            Emaillabel.setFont(f1);
            StdNolabel = new JLabel("Student No:");
            StdNolabel.setFont(f1);
            Addresslabel = new JLabel("Address:");
            Addresslabel.setFont(f1);
            name = new JLabel();
            name.setFont(f1);
            LT = new JLabel();
            LT.setFont(f1);
            Mobile = new JLabel();
            Mobile.setFont(f1);
            Email = new JLabel();
            Email.setFont(f1);
            StdNo = new JLabel();
            StdNo.setFont(f1);
            Address = new JLabel();
            Address.setFont(f1);
            layout.setHorizontalGroup(layout
                    .createSequentialGroup()
                    .addGroup(
                            layout.createParallelGroup(
                                    GroupLayout.Alignment.LEADING)
                            .addComponent(namelabel)
                            .addComponent(LTlabel)
                            .addComponent(Mobilelabel)
                            .addComponent(Emaillabel)
                            .addComponent(StdNolabel)
                            .addComponent(Addresslabel))
                    .addGap(30)
                    .addGroup(
                            layout.createParallelGroup(
                                    GroupLayout.Alignment.LEADING)
                            .addComponent(name).addComponent(LT)
                            .addComponent(Mobile).addComponent(Email)
                            .addComponent(StdNo).addComponent(Address)));
            layout.setVerticalGroup(layout
                    .createSequentialGroup()
                    .addGroup(
                            layout.createParallelGroup(
                                    GroupLayout.Alignment.BASELINE)
                            .addComponent(namelabel).addComponent(name))
                    .addGroup(
                            layout.createParallelGroup(
                                    GroupLayout.Alignment.BASELINE)
                            .addComponent(LTlabel).addComponent(LT))
                    .addGroup(
                            layout.createParallelGroup(
                                    GroupLayout.Alignment.BASELINE)
                            .addComponent(Mobilelabel)
                            .addComponent(Mobile))
                    .addGroup(
                            layout.createParallelGroup(
                                    GroupLayout.Alignment.BASELINE)
                            .addComponent(Emaillabel)
                            .addComponent(Email))
                    .addGroup(
                            layout.createParallelGroup(
                                    GroupLayout.Alignment.BASELINE)
                            .addComponent(StdNolabel)
                            .addComponent(StdNo))
                    .addGroup(
                            layout.createParallelGroup(
                                    GroupLayout.Alignment.BASELINE)
                            .addComponent(Addresslabel)
                            .addComponent(Address)));
            name.setText(std.getName());
            LT.setText(std.getLT());
            Mobile.setText(std.getContactNo());
            Email.setText(std.getEmail());
            StdNo.setText(std.getStndID());
            Address.setText(std.getAddress());
            JMenu filemenu = new JMenu("File");
            filemenu.setMnemonic('F');
            JMenuItem about = new JMenuItem("About...");
            JMenuItem refresh = new JMenuItem("Refresh");
            JMenuItem Logout = new JMenuItem("Logout");
            JMenuItem upimg = new JMenuItem("Upload a Image");
            filemenu.add(about);
           // filemenu.add(upimg);
            filemenu.add(refresh);
            filemenu.add(Logout);
            JMenu Editmenu = new JMenu("Edit");
            Editmenu.setMnemonic('E');
            JMenuItem Info = new JMenuItem("Information");
            JMenuItem Pass = new JMenuItem("Password");
            Editmenu.add(Info);
            Editmenu.add(Pass);
            Info.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    EditStudentInfo a = new EditStudentInfo(std);
                    a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    a.setLocationRelativeTo(null);
                    a.setVisible(true);
                    a.setSize(500, 300);
                    dispose();
                }
            });
            Pass.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ChangePass a = new ChangePass(std);
                    a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    a.setSize(500, 200);
                    a.setLocationRelativeTo(null);
                    a.setVisible(true);
                    dispose();
                }
            });
            about.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null,
                            "eikhane habijabi onek kisu lekha jabe\n", "About",
                            JOptionPane.PLAIN_MESSAGE);

                }
            });
            refresh.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        StudentElements temp = std;
                        Socket clientsocket = new Socket(getglobal(), 12345);
                        PrintWriter pw = new PrintWriter(clientsocket.getOutputStream());
                        pw.println("studentinfo");
                        pw.flush();
                        Socket newclientsocket = new Socket(getglobal(), 30007);
                        PrintWriter pa = new PrintWriter(newclientsocket.getOutputStream());
                        pa.println(temp.getStndID());
                        pa.flush();
                        ObjectInputStream ois = new ObjectInputStream(
                                newclientsocket.getInputStream());
                        while (true) {
                            std = (StudentElements) ois.readObject();
                            if ((std.getStndID()).equals(temp.getStndID())) {
                                break;
                            }
                        }
                        newclientsocket.close();
                        name.setText(std.getName());
                        LT.setText(std.getLT());
                        Mobile.setText(std.getContactNo());
                        Email.setText(std.getEmail());
                        StdNo.setText(std.getStndID());
                        Address.setText(std.getAddress());
                    } catch (Exception er) {
                        System.out.println("Error connecting with server");
                        er.printStackTrace();
                    }
                }
            });
            Logout.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (chatFrameObj.isDisplayable()) {
                        JOptionPane.showMessageDialog(null,
                                "You have to close the chat frame first");
                        try {
                            chatFrameObj.client.send(new Message("message",
                                    userId, ".bye", "SERVER"));
                            chatFrameObj.clientThread.stop();
                            chatFrameObj.dispose();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        dispose();
                        StudentLogin a = new StudentLogin();
                        a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        a.setLocationRelativeTo(null);
                        a.setVisible(true);
                    } else {
                        dispose();
                        StudentLogin a = new StudentLogin();
                        a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        a.setLocationRelativeTo(null);
                        a.setVisible(true);
                    }

                }
            });
            JMenuBar bar = new JMenuBar();
            setJMenuBar(bar);
            bar.add(filemenu);
            bar.add(Editmenu);
            JMenu Format = new JMenu("Format");
            Format.setMnemonic('r');
            String[] colors = {"BLACK", "BLUE", "RED", "GREEN", "YELLOW",
                "ORANGE", "GRAY", "WHITE", "CYAN", "MAGENTA", "PINK"};
            JMenu colormenu = new JMenu("Color");
            JMenu forecolor = new JMenu("Set Font Color");
            JMenu backcolor = new JMenu("Set Back Color");
            fcolor = new JRadioButtonMenuItem[colors.length];
            bcolor = new JRadioButtonMenuItem[colors.length];
            ButtonGroup fgroup = new ButtonGroup();
            ButtonGroup bgroup = new ButtonGroup();
            ItemHandler item = new ItemHandler();
            for (int cc = 0; cc < colors.length; cc++) {
                fcolor[cc] = new JRadioButtonMenuItem(colors[cc]);
                bcolor[cc] = new JRadioButtonMenuItem(colors[cc]);
                forecolor.add(fcolor[cc]);
                backcolor.add(bcolor[cc]);
                fgroup.add(fcolor[cc]);
                bgroup.add(bcolor[cc]);
                fcolor[cc].addActionListener(item);
                bcolor[cc].addActionListener(item);

            }
            fcolor[0].setSelected(true);
            bcolor[7].setSelected(true);
            colormenu.add(forecolor);
            colormenu.add(backcolor);
            Format.add(colormenu);
            Format.addSeparator();

            JMenu FontMenu = new JMenu("Font");
            font = new JRadioButtonMenuItem[fontnames.length];
            ButtonGroup fontgrp = new ButtonGroup();
            for (int d = 0; d < fontnames.length; d++) {
                font[d] = new JRadioButtonMenuItem(fontnames[d]);
                fontgrp.add(font[d]);
                FontMenu.add(font[d]);
                font[d].addActionListener(item);

            }

            font[0].setSelected(true);
            FontMenu.addSeparator();

            String[] styles = {"Bold", "Italic"};
            style = new JCheckBoxMenuItem[styles.length];
            StyleHandler styleHandler = new StyleHandler();
            for (int cc = 0; cc < styles.length; ++cc) {
                style[cc] = new JCheckBoxMenuItem(styles[cc]);
                FontMenu.add(style[cc]);
                style[cc].addItemListener(styleHandler);
            }
            style[0].setSelected(true);
            Format.add(FontMenu);
            bar.add(Format);
            JMenu notification = new JMenu("Notifications");
            notification.setMnemonic('N');
            JMenuItem view = new JMenuItem("View All Notifications");
            JMenuItem clear = new JMenuItem("Clear All Notifications");
            notification.add(view);
            notification.add(clear);
            bar.add(notification);
            if (std.getUnreadnoti() >= 1) {
                notification.setText("Notification (" + std.getUnreadnoti()
                        + ")");
            }
            view.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    notification.setText("Notification");
                    StudentElements temp2 = std;
                    ShowNotice show = new ShowNotice(temp2);
                    show.setVisible(true);
                    show.setLocationRelativeTo(null);
                    show.setResizable(false);
                    std.setUnreadnoti(0);
                    try {
                        /* eikhane 1 */
                        Socket clientsocket = new Socket(
                                getglobal(), 12345);
                        PrintWriter pw = new PrintWriter(clientsocket
                                .getOutputStream());
                        pw.println("editstudent");
                        pw.flush();
                        Socket newclientsocket = new Socket(getglobal(), 30003);

                        /*
                         * client obj pathabe ouyputstream e, seita server
                         * inputstream e paia file e write korbe
                         */
                        ObjectOutputStream oos = new ObjectOutputStream(
                                newclientsocket.getOutputStream());
                        oos.writeObject(std);
                        oos.flush();

						// JOptionPane.showMessageDialog(null,
                        // "Profile Updated!");
                        newclientsocket.close();
                    } catch (Exception p) {
                        p.printStackTrace();
                    }
                }
            });
            clear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    notification.setText("Notification");
                    std.setUnreadnoti(0);
                    try {
                        /* eikhane 1 */
                        Socket clientsocket = new Socket(
                                getglobal(), 12345);
                        PrintWriter pw = new PrintWriter(clientsocket
                                .getOutputStream());
                        pw.println("editstudent");
                        pw.flush();
                        Socket newclientsocket = new Socket(getglobal(), 30003);

                        /*
                         * client obj pathabe ouyputstream e, seita server
                         * inputstream e paia file e write korbe
                         */
                        ObjectOutputStream oos = new ObjectOutputStream(
                                newclientsocket.getOutputStream());
                        oos.writeObject(std);
                        oos.flush();

						// JOptionPane.showMessageDialog(null,
                        // "Profile Updated!");
                        newclientsocket.close();
                    } catch (Exception p) {
                        p.printStackTrace();

                    }
                }
            });
            // notun
            JMenu chatmenu = new JMenu("Chat");
            chatmenu.setMnemonic('C');
            JMenuItem connectChat = new JMenuItem("Connect");
            JMenuItem setOffline = new JMenuItem("Stay offline");
            chatmenu.add(connectChat);
            chatmenu.add(setOffline);
            bar.add(chatmenu);
            connectChat.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    userId = std.getName();
                    userPass = std.getPass();
                    chatFrameObj = new ChatFrame(userId, userPass);
                   // chatFrameObj.setIdPass(userId, userPass, true);
                    chatFrameObj.setLocationRelativeTo(null);
                    chatFrameObj.setVisible(true);
                    chatFrameObj.setResizable(false);
                    chatFrameObj
                            .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                }
            });
            setOffline.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if (chatFrameObj.isDisplayable()) {
                        chatFrameObj.client.send(new Message("message", userId,
                                ".bye", "SERVER"));
                        chatFrameObj.clientThread.stop();
                        chatFrameObj.dispose();
                        JOptionPane.showMessageDialog(null,
                                "You are set offline");
                    } else {
                        JOptionPane.showMessageDialog(null, "You are offline");
                    }
                }
            });
            // notun
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocation(300, 300);
            setVisible(true);
            setResizable(true);
            ois.close();
        } catch (Exception e) {
            System.out.println("Exception during deserialization: " + e);
            System.exit(0);
        }

    }

    private class ItemHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            for (int cc = 0; cc < bcolor.length; ++cc) {
                if (bcolor[cc].isSelected()) {
                    getContentPane().setBackground(colorValues[cc]);
                    break;
                }

            }
            for (int cc = 0; cc < fcolor.length; ++cc) {
                if (fcolor[cc].isSelected()) {
                    name.setForeground(colorValues[cc]);
                    namelabel.setForeground(colorValues[cc]);
                    LT.setForeground(colorValues[cc]);
                    LTlabel.setForeground(colorValues[cc]);
                    Addresslabel.setForeground(colorValues[cc]);
                    Address.setForeground(colorValues[cc]);
                    Emaillabel.setForeground(colorValues[cc]);
                    Email.setForeground(colorValues[cc]);
                    Mobile.setForeground(colorValues[cc]);
                    Mobilelabel.setForeground(colorValues[cc]);
                    StdNo.setForeground(colorValues[cc]);
                    StdNolabel.setForeground(colorValues[cc]);
                    break;
                }

            }
            for (int cc = 0; cc < font.length; ++cc) {
                int i = name.getFont().getStyle();
                if (e.getSource() == font[cc]) {
                    name.setFont(new Font(font[cc].getText(), i, fontsize));
                    namelabel
                            .setFont(new Font(font[cc].getText(), i, fontsize));
                    LT.setFont(new Font(font[cc].getText(), i, fontsize));
                    LTlabel.setFont(new Font(font[cc].getText(), i, fontsize));
                    Addresslabel.setFont(new Font(font[cc].getText(), i,
                            fontsize));
                    Address.setFont(new Font(font[cc].getText(), i, fontsize));
                    Emaillabel
                            .setFont(new Font(font[cc].getText(), i, fontsize));
                    Email.setFont(new Font(font[cc].getText(), i, fontsize));
                    Mobile.setFont(new Font(font[cc].getText(), i, fontsize));
                    Mobilelabel.setFont(new Font(font[cc].getText(), i,
                            fontsize));
                    StdNo.setFont(new Font(font[cc].getText(), i, fontsize));
                    StdNolabel
                            .setFont(new Font(font[cc].getText(), i, fontsize));
                }
            }
            repaint();
        }
    }

    private class StyleHandler implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            String n = name.getFont().getName();
            Font f;
            if (style[0].isSelected() && style[1].isSelected()) {
                f = new Font(n, Font.BOLD + Font.ITALIC, fontsize);
            } else if (style[0].isSelected()) {
                f = new Font(n, Font.BOLD, fontsize);
            } else if (style[1].isSelected()) {
                f = new Font(n, Font.ITALIC, fontsize);
            } else {
                f = new Font(n, Font.PLAIN, fontsize);
            }
            f1 = f;
            name.setFont(f1);
            namelabel.setFont(f1);
            LT.setFont(f1);
            LTlabel.setFont(f1);
            Addresslabel.setFont(f1);
            Address.setFont(f1);
            Emaillabel.setFont(f1);
            Email.setFont(f1);
            Mobile.setFont(f1);
            Mobilelabel.setFont(f1);
            StdNo.setFont(f1);
            StdNolabel.setFont(f1);
            repaint();
        }
    }

    public static void main(String[] args) {
        StudentInfo a = new StudentInfo("1205112");
        a.setSize(500, 350);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
