package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class RemoveEmp extends JFrame implements ActionListener {
	JLabel l1,l2;
	JTextField t1;
	JButton b1,b2;
	
	public RemoveEmp() {
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.cyan);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("REMOVE EMPLOYEE");
		l1.setFont(new Font("Trebuchet MS ",1,18));
		l1.setForeground(new Color(102,51,0));
		l1.setBounds(240,60,210,30);
		add(l1);
		
		l2=new JLabel("EMPLOYEE ID:");
		l2.setFont(new Font("Trebuchet MS ",1,16));
		l2.setForeground(new Color(102,51,0));
		l2.setBounds(50,130,160,30);
		add(l2);
		
		t1=new JTextField();
	    t1.setBackground(Color.white);
	    t1.setBounds(240,130,320,30);
	    add(t1);
	    
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
			String q1="delete from employeedata where user='"+t1.getText()+"'";
			obj.stm.executeUpdate(q1);
			
			setVisible(false);
			JOptionPane.showMessageDialog(null, "Employee Removed Successfully");
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
	new RemoveEmp();
}
}
	