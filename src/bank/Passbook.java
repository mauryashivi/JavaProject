package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class Passbook extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2;
	JButton b1,b2;
	
	public Passbook() {
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.pink);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("STATEMENT");
		l1.setFont(new Font("Trebuchet MS ",1,18));
		l1.setForeground(new Color(102,51,0));
		l1.setBounds(200,50,460,50);
		add(l1);
		
		l2=new JLabel("CARD NO. ");
		l2.setFont(new Font("Trebuchet MS ",1,16));
		l2.setForeground(new Color(102,51,0));
		l2.setBounds(50,130,160,30);
		add(l2);
		
		t1=new JTextField();
	    t1.setBackground(Color.white);
	    t1.setBounds(200,123,300,25);
	    add(t1);
	    
	    l3=new JLabel("PIN: ");
		l3.setFont(new Font("Trebuchet MS ",1,16));
		l3.setForeground(new Color(102,51,0));
		l3.setBounds(50,180,170,30);
		add(l3);
		
		t2=new JTextField();
	    t2.setBackground(Color.white);
	    t2.setBounds(200,182,300,25);
	    add(t2);
	    
	    l4=new JLabel();
		l4.setBounds(50,300,400,200);
		add(l4);
	    
	    l5=new JLabel("CURRENT BALANCE: ");
		l5.setFont(new Font("Trebuchet MS ",1,16));
		l5.setForeground(new Color(102,51,0));
		l5.setBounds(310,290,600,30);
		add(l5);
		
		  b1= new JButton("BACK");
			b1.setBackground(Color.black);
			b1.setFont(new Font("Tahoma",1,16));
			b1.setForeground(Color.pink);
			b1.setBounds(400,700,150,45);
			add(b1);
			b1.addActionListener(this);
			
			b2= new JButton("GO");
			b2.setBackground(Color.black);
			b2.setFont(new Font("Tahoma",1,16));
			b2.setForeground(Color.pink);
			b2.setBounds(200,700,150,45);
			add(b2);
			b2.addActionListener(this);
	   
}
	public void actionPerformed(ActionEvent e) {
		Database obj=new Database();
		if(e.getSource()== b2) {
			String q1="select * from passbook where pin='"+t2.getText()+"'";
			String q2="select * from login where pin='"+t2.getText()+"'";
			try {
				ResultSet rs=obj.stm.executeQuery(q1);
				while(rs.next()) {
					l4.setText(l4.getText()+"<html>"+rs.getString("bal")+"&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;"+"<br><br><html>");
				    
				}
				ResultSet rss=obj.stm.executeQuery(q2);
				while(rss.next()) {
					l5.setText(l5.getText()+rss.getString("bal"));
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		if(e.getSource()==b1) {
			setVisible(false);
			// new ToDo;
		}
	}

	public static void main(String[] args) {
		new Passbook();
	}
}