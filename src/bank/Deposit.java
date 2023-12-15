package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener {

	JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2,b3;
	
	public Deposit() {
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.pink);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("PIN :");
		l1.setFont(new Font("Trebuchet MS ",1,14));
		l1.setForeground(new Color(102,51,0));
		l1.setBounds(460,10,90,20);
		add(l1);
		
		t1=new JTextField();
	    t1.setBackground(Color.white);
	    t1.setBounds(550,10,70,20);
	    add(t1);
	    
	    l2=new JLabel("Enter Amount you Want To Deposit");
		l2.setFont(new Font("Trebuchet MS ",1,18));
		l2.setForeground( Color.black);
		l2.setBounds(150,40,400,40);
		add(l2);
		
		t2=new JTextField();
	    t2.setBackground(Color.white);
	    t2.setBounds(155,130,350,40);
	    add(t2);
	    
	    b1= new JButton("DEPOSIT");
		b1.setBackground(Color.black);
		b1.setFont(new Font("Tahoma",1,16));
		b1.setForeground(Color.pink);
		b1.setBounds(180,220,120,30);
		add(b1);
		b1.addActionListener(this);
		
		b2= new JButton("BACK");
		b2.setBackground(Color.black);
		b2.setFont(new Font("Tahoma",1,16));
		b2.setForeground(Color.pink);
		b2.setBounds(330,220,130,30);
		add(b2);
		b2.addActionListener(this);
		
		b3= new JButton("EXIT");
		b3.setBackground(Color.black);
		b3.setFont(new Font("Tahoma",1,16));
		b3.setForeground(Color.pink);
		b3.setBounds(250,290,130,30);
		add(b3);
		b3.addActionListener(this);
	   
}
	public void actionPerformed(ActionEvent e) {
		try {
			Database c = new Database();
			String type = "Deposit";
			String pin=t1.getText();
			
			int bal = Integer.parseInt(t2.getText());
			if(e.getSource()==b1) {
				String q1="update login set bal=bal+'"+bal +"' where pin='"+t1.getText()+"'";
				int result = c.stm.executeUpdate(q1);
				
				String q ="insert into passbook values('"+pin+"','"+bal+"','"+type+"')";
				c.stm.executeUpdate(q);
				if(result == 1) {
					JOptionPane.showMessageDialog(null,"Amount deposited successfully");
				}
				else {
					JOptionPane.showMessageDialog(null,"Please check your PIN or Amount");
				}
			}
	}
		catch(Exception ex){
			ex.printStackTrace();
		}
		if(e.getSource()== b2) {
			setVisible(false);
			// new ToDo();
		}
		if(e.getSource()== b3) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Deposit();
	}
}
	
