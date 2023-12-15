package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class CustomerHomePage extends JFrame implements ActionListener {

	JLabel l1,l2,l3;
	JTextField t1,t3;
	JButton b1,b2,b3;

	public CustomerHomePage() {
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.pink);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("Welcome To Bank");
		l1.setFont(new Font("Trebuchet MS ",1,18));
		l1.setForeground(new Color(102,51,0));
		l1.setBounds(240,60,210,30);
		add(l1);
		
		l2=new JLabel("CARD NO. ");
		l2.setFont(new Font("Trebuchet MS ",1,16));
		l2.setForeground(new Color(102,51,0));
		l2.setBounds(50,130,160,30);
		add(l2);
		
		t1=new JTextField();
	    t1.setBackground(Color.white);
	    t1.setBounds(240,130,320,30);
	    add(t1);
	    
	    l3=new JLabel("PIN ");
		l3.setFont(new Font("Trebuchet MS ",1,16));
		l3.setForeground(new Color(102,51,0));
		l3.setBounds(50,180,170,30);
		add(l3);
		
		t3=new JTextField();
	    t3.setBackground(Color.white);
	    t3.setBounds(240,180,320,30);
	    add(t3);
	    
	    b1= new JButton("SIGN IN");
		b1.setBackground(Color.black);
		b1.setFont(new Font("Tahoma",1,16));
		b1.setForeground(Color.pink);
		b1.setBounds(240,250,110,30);
		add(b1);
		b1.addActionListener(this);
		
		b2= new JButton("CLEAR");
		b2.setBackground(Color.black);
		b2.setFont(new Font("Tahoma",1,16));
		b2.setForeground(Color.pink);
		b2.setBounds(380,250,110,30);
		add(b2);
		b2.addActionListener(this);
		
		b3= new JButton("BACK");
		b3.setBackground(Color.black);
		b3.setFont(new Font("Tahoma",1,16));
		b3.setForeground(Color.pink);
		b3.setBounds(240,300,110,30);
		add(b3);
		b3.addActionListener(this);
	
}
	public void actionPerformed(ActionEvent e) {
		Database obj = new Database();
		if(e.getSource()== b1) {
			try {
				String q ="select * from login where card ='"+t1.getText()+"' and pin='"+ t3.getText()+"' ";		
				ResultSet rs = obj.stm.executeQuery(q);
				if(rs.next()) {
					setVisible(false);
					new Roles();
				}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect Data");
					t1.setText("");
					t3.setText("");
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}

	if(e.getSource()== b3) {
		setVisible(false);
		new Roles();
	}
	else if(e.getSource()==b2){
		t1.setText("");
		t3.setText("");
	}
}
	public static void main(String[] args) {
		new CustomerHomePage();
	}
}
