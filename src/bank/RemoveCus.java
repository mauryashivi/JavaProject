package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class RemoveCus extends JFrame implements ActionListener {
	JLabel l1,l2,l3;
	JTextField t1,t3;
	JButton b1,b2,b3;

	public RemoveCus() {
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.pink);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("REMOVE CUSTOMER");
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
	    
	    b1= new JButton("REMOVE");
		b1.setBackground(Color.black);
		b1.setFont(new Font("Tahoma",1,16));
		b1.setForeground(Color.pink);
		b1.setBounds(240,250,110,30);
		add(b1);
		b1.addActionListener(this);
		
		b2= new JButton("BACK");
		b2.setBackground(Color.black);
		b2.setFont(new Font("Tahoma",1,16));
		b2.setForeground(Color.pink);
		b2.setBounds(380,250,110,30);
		add(b2);
		b2.addActionListener(this);
 
}
	public void actionPerformed(ActionEvent e) {
		Database obj = new Database();
		if(e.getSource()==b1) {
			try {
				String q1="delete from customerdata where user='"+t1.getText()+"'";
				obj.stm.executeUpdate(q1);
				String q2="delete from login where pin='"+t3.getText()+"'";
				obj.stm.executeUpdate(q2);
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Customer Removed Successfully");
				new EmployeeWork();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else {
			setVisible(false);
			new EmployeeWork();
		}
		
	}
	public static void main(String[] args) {
		new RemoveCus();
	}
}

