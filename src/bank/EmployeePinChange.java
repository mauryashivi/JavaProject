package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class EmployeePinChange extends JFrame implements ActionListener {

	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;
	JButton b1,b2;
	
	public EmployeePinChange() {
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.YELLOW);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("CHANGE THE PIN");
		l1.setFont(new Font("Trebuchet MS ",1,18));
		l1.setForeground(new Color(102,51,0));
		l1.setBounds(240,60,210,30);
		add(l1);
		
		l2=new JLabel("Security Question Hobbies: ");
		l2.setFont(new Font("Trebuchet MS ",1,16));
		l2.setForeground(new Color(102,51,0));
		l2.setBounds(56,123,320,25);
		add(l2);
		
		t1=new JTextField();
	    t1.setBackground(Color.white);
	    t1.setBounds(350,123,167,25);
	    add(t1);
	    
	    l3=new JLabel("Enter OLD PIN: ");
		l3.setFont(new Font("Trebuchet MS ",1,16));
		l3.setForeground(new Color(102,51,0));
		l3.setBounds(56,182,250,25);
		add(l3);
		
		t2=new JTextField();
	    t2.setBackground(Color.white);
	    t2.setBounds(350,182,167,25);
	    add(t2);
	    
	    l4=new JLabel("Enter NEW PIN: ");
		l4.setFont(new Font("Trebuchet MS ",1,16));
		l4.setForeground(new Color(102,51,0));
		
		l4.setBounds(56,240,250,25);
		add(l4);
		
		t3=new JTextField();
	    t3.setBackground(Color.white);
	    t3.setBounds(350,240,167,25);
	    add(t3);
	    
	    l5=new JLabel("Re-Enter NEW PIN: ");
		l5.setFont(new Font("Trebuchet MS ",1,16));
		l5.setForeground(new Color(102,51,0));
		l5.setBounds(56,300,250,25);
		add(l5);
		
		t4=new JTextField();
	    t4.setBackground(Color.white);
	    t4.setBounds(350,300,167,25);
	    add(t4);
	    
	    b1= new JButton("CHANGE");
		b1.setBackground(Color.black);
		b1.setFont(new Font("Tahoma",1,16));
		b1.setForeground(Color.yellow);
		b1.setBounds(200,400,110,35);
		add(b1);
		b1.addActionListener(this);
		
		b2= new JButton("CANCEL");
		b2.setBackground(Color.black);
		b2.setFont(new Font("Tahoma",1,16));
		b2.setForeground(Color.yellow);
		b2.setBounds(350,400,110,35);
		add(b2);
		b2.addActionListener(this);
}
	public void actionPerformed(ActionEvent e) {
		try {
			Database c = new Database();
			String q ="select * from employeedata where pass='"+t2.getText() +"'";
			ResultSet rs= c.stm.executeQuery(q);
			
			String q2 = "select * from employeedata where hobbies='"+t1.getText()+"'";
			ResultSet r = c.st.executeQuery(q2);
			if(rs.next() && r.next()) {
			
			if(e.getSource()== b1) {
				String q3 ="update employeedata set pass ='"+t3.getText()+"'where pass = '"+t2.getText()+"'";
				c.st.executeUpdate(q3);
				
	        JOptionPane.showMessageDialog(null,"PIN Changed Successfully");
	        t1.setText("");
	        t2.setText("");
	        t3.setText("");
	        t4.setText("");
	        setVisible(false);
	        new EmployeeWork();
	  	}
			else {
				JOptionPane.showMessageDialog(null, "PIN is wrong ");
			}
		 	}
			else if(e.getSource()==b2){
				setVisible(false);
				new EmployeeWork();
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}	
	public static void main(String[] args) {
		new EmployeePinChange();
	}
}
	
