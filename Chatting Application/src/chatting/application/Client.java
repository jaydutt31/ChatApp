package chatting.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  /* includes event listeners */
import java.net.*;
import java.io.*;



public class Client extends JFrame implements ActionListener{
	
	JPanel p1;
	JTextField t1;
	JButton b1;
	static JTextArea a1;
	
	static Socket s;
	static DataInputStream din; 
	static DataOutputStream dout;
	
	Client(){
		
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(7, 94, 84));
		p1.setBounds(0, 0, 450, 70);
		add(p1);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
		Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);  /* for image size */
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(5, 17, 30, 30);
		p1.add(l1);    /* pastes image on the layout*/	
		
		l1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae) {
				System.exit(0);
			}
		});
		
		
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/2.png"));
		Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);  /* for image size */
		ImageIcon i6 = new ImageIcon(i5);
		JLabel l2 = new JLabel(i6);
		l2.setBounds(40, 5, 60, 60);
		/*           (x-axis, y-axis, size-x, size y)*/
		p1.add(l2);    /* pastes image on the layout*/	
		
		ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
		Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);  /* for image size */
		ImageIcon i9 = new ImageIcon(i8);
		JLabel l5 = new JLabel(i9);
		l5.setBounds(290, 20, 30, 30);
		/*           (x-axis, y-axis, size-x, size y)*/
		p1.add(l5);    /* pastes image on the layout*/	
		
		ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
		Image i11 = i10.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);  /* for image size */
		ImageIcon i12 = new ImageIcon(i11);
		JLabel l6 = new JLabel(i12);
		l6.setBounds(350, 20, 35, 35);
		/*           (x-axis, y-axis, size-x, size y)*/
		p1.add(l6);    /* pastes image on the layout*/	
		
		ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
		Image i14 = i13.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);  /* for image size */
		ImageIcon i15 = new ImageIcon(i14);
		JLabel l7 = new JLabel(i15);
		l7.setBounds(410, 20, 13, 25);
		/*           (x-axis, y-axis, size-x, size y)*/
		p1.add(l7);    /* pastes image on the layout*/	
		
		JLabel l3 = new JLabel("Jay Dutt");
		l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
		l3.setForeground(Color.WHITE);
		l3.setBounds(110, 15, 100, 18);
		p1.add(l3);
		
		JLabel l4 = new JLabel("Active Now");
		l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
		l4.setForeground(Color.WHITE);
		l4.setBounds(110, 35, 100, 20);
		p1.add(l4);
		
		a1 = new JTextArea();
		a1.setBounds(5, 75, 425, 532);
		a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		a1.setEditable(false);
		a1.setLineWrap(true);
		a1.setWrapStyleWord(true);
		
		add(a1);
		
		t1 = new JTextField();
		t1.setBounds(5, 613, 310, 40);
		t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		add(t1);
		
		b1 = new JButton("Send");
		b1.setBounds(320, 613, 105, 40);
		b1.setBackground(new Color(7, 94, 84));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
		b1.addActionListener(this);
		add(b1);
		
		/*getContentPane().setBackground(Color.YELLOW);  colors whole backgorund */
		setLayout(null);
		setSize(450, 700);
		setLocation(900, 60);
		/* setUndecorated(true); */   /* to hide top bar */
		setVisible(true); /* changes frame, always write in end of program. */
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
		
			String out = t1.getText();
			a1.setText(a1.getText()+"\n\t\t\t"+out);
			dout.writeUTF(out);
			t1.setText("");
		
		}catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		new Client().setVisible(true);
		
		try {
			s = new Socket("127.0.0.1",6001);
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			String msginput = "";
			
			msginput = din.readUTF();
			a1.setText(a1.getText()+"\n"+msginput);
			
			
		}catch(Exception e) {
			
		}
	}

}


