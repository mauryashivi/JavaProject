package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class EmployeeWork extends JFrame implements ActionListener {
	JLabel l1;
	JButton b1,b2,b3,b4,b5;
	public EmployeeWork(){
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.yellow);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("EMPLOYEE FUNCTIONALITY");
		l1.setFont(new Font("Tahoma",1,30));
		l1.setForeground(new Color(242,29,6));
		l1.setBounds(150,30,500,30);
		add(l1);
		
		b1=new JButton("ADD CUSTOMER");
		b1.setBackground(Color.black);
		b1.setFont(new Font("Tahoma",1,16));
		b1.setForeground(Color.yellow);
		b1.setBounds(80,130,200,30);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("FORGOT PIN");
		b2.setBackground(Color.black);
		b2.setFont(new Font("Tahoma",1,16));
		b2.setForeground(Color.yellow);
		b2.setBounds(350,130,200,30);
		add(b2);
		b2.addActionListener(this);
		
		b3=new JButton("REMOVE CUSTOMER");
		b3.setBackground(Color.black);
		b3.setFont(new Font("Tahoma",1,16));
		b3.setForeground(Color.yellow);
		b3.setBounds(80,180,200,30);
		add(b3);
		b3.addActionListener(this);
		
		b4=new JButton("UPDATE YOURSELF");
		b4.setBackground(Color.black);
		b4.setFont(new Font("Tahoma",1,16));
		b4.setForeground(Color.yellow);
		b4.setBounds(350,180,200,30);
		add(b4);
		b4.addActionListener(this);
		
		b5=new JButton("BACK");
		b5.setBackground(Color.black);
		b5.setFont(new Font("Tahoma",1,16));
		b5.setForeground(Color.yellow);
		b5.setBounds(200,250,200,30);
		add(b5);
		b5.addActionListener(this);
}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
              setVisible(false);
	    	  new NewSignup();
	      }
	      if(e.getSource()==b2) {
	    	  setVisible(false);
	    	  new PinChange();
	      }
	      if(e.getSource()==b3) {
	    	  try {
	    		String id=JOptionPane.showInputDialog("enter your Employee Id") ;
	    		Database c=new Database();
	    		String q="Select * from Employeedata where user='"+id+"'";
	    		ResultSet r=c.stm.executeQuery(q);
	    		if(r.next()) {
	    			setVisible(false);
	    			 new RemoveCus();
	    		}	else {
	    				JOptionPane.showInputDialog("enter your Employee Id") ;
	    			}
	  
	    			
	    		}catch(Exception ex) {
	    			ex.printStackTrace();
	    		}
	    	  }


	      if(e.getSource()==b4) {
	    	  try {
		    		String id=JOptionPane.showInputDialog("enter your Employee Id") ;
		    		Database c=new Database();
		    		String q="Select * from Employeedata where user='"+id+"'";
		    				ResultSet r=c.stm.executeQuery(q);
		    		if(r.next()) {
		    			setVisible(false);
		    			new UpdateEmp2(id);
		    		}	else {
		    				JOptionPane.showInputDialog("enter your Employee Id") ;
		    			}
		  
		    			
		    		}catch(Exception ex) {
		    			ex.printStackTrace();
		    		}
		    	  }


	     
	      if(e.getSource()==b5) {
	    	  setVisible(false);
	    	  new Roles();
	      }
}
	
	public static void main(String args[]) {
		new EmployeeWork();
	}
	

}
