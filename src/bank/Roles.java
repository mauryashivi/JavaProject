package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class Roles extends JFrame implements ActionListener {
	JLabel l1;
	JButton b1,b2,b3,b4;
	public Roles() {
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.cyan);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("Greetings !");
		l1.setFont(new Font("Tahoma",1,30));
		l1.setForeground(new Color(242,29,6));
		l1.setBounds(200,30,350,40);
		add(l1);
		
		b1=new JButton("Admin");
		b1.setBackground(Color.black);
		b1.setFont(new Font("Tahoma",1,16));
		b1.setForeground(Color.cyan);
		b1.setBounds(80,130,200,30);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("Employee");
		b2.setBackground(Color.black);
		b2.setFont(new Font("Tahoma",1,16));
		b2.setForeground(Color.cyan);
		b2.setBounds(80,210,200,30);
		add(b2);
		b2.addActionListener(this);
		
		b3=new JButton("Customer");
		b3.setBackground(Color.black);
		b3.setFont(new Font("Tahoma",1,16));
		b3.setForeground(Color.cyan);
		b3.setBounds(80,290,200,30);
		add(b3);
		b3.addActionListener(this);
		
		b4=new JButton("Exit");
		b4.setBackground(Color.black);
		b4.setFont(new Font("Tahoma",1,16));
		b4.setForeground(Color.cyan);
		b4.setBounds(80,370,200,30);
		add(b4);
		b4.addActionListener(this);
		
	}
	
public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			setVisible(false);
			new AdminWork();		
			}
		if(e.getSource()==b2) {
			setVisible(false);
			new EmployeeHomePage();		
			}
		if(e.getSource()==b3) {
			setVisible(false);
			new CustomerHomePage();		
			}
		if(e.getSource()==b4) {
			System.exit(0);		
			}
     }
	
	public static void main(String args[]) {
		new Roles();
	}
	

}
