package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class AdminWork extends JFrame implements ActionListener{
	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6;
	public AdminWork(){
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.GRAY);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("Please Select");
		l1.setFont(new Font("Tahoma",1,30));
		l1.setForeground(Color.pink);
		l1.setBounds(200,30,350,40);
		add(l1);
		
		b1=new JButton("BALANCE");
		b1.setBackground(Color.black);
		b1.setFont(new Font("Tahoma",1,16));
		b1.setForeground(Color.pink);
		b1.setBounds(80,130,200,30);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("REMOVE EMPLOYEE");
		b2.setBackground(Color.black);
		b2.setFont(new Font("Tahoma",1,16));
		b2.setForeground(Color.pink);
		b2.setBounds(310,130,210,30);
		add(b2);
		b2.addActionListener(this);
		
		b3=new JButton("ADD EMPLOYEE");
		b3.setBackground(Color.black);
		b3.setFont(new Font("Tahoma",1,16));
		b3.setForeground(Color.pink);
		b3.setBounds(80,200,200,30);
		add(b3);
		b3.addActionListener(this);
		
		b4=new JButton("ADD CUSTOMER");
		b4.setBackground(Color.black);
		b4.setFont(new Font("Tahoma",1,16));
		b4.setForeground(Color.pink);
		b4.setBounds(310,200,210,30);
		add(b4);
		b4.addActionListener(this);
		
		b5=new JButton("REMOVE CUSTOMER");
		b5.setBackground(Color.black);
		b5.setFont(new Font("Tahoma",1,16));
		b5.setForeground(Color.pink);
		b5.setBounds(80,270,200,30);
		add(b5);
		b5.addActionListener(this);
		
		b6=new JButton("BACK");
		b6.setBackground(Color.black);
		b6.setFont(new Font("Tahoma",1,16));
		b6.setForeground(Color.pink);
		b6.setBounds(310,270,200,30);
		add(b6);
		b6.addActionListener(this);
		
}
	
public void actionPerformed(ActionEvent e) {
      if(e.getSource()==b1) {
    	  try {
    		  Database c=new Database();
    		  String q="select Sum(bal)as total from login";
    		  ResultSet r=c.stm.executeQuery(q);
    		  if(r.next()) {
    			  String sum=r.getString("total");
    			  JOptionPane.showMessageDialog(null, "YOur Balance is : "+sum);
    		  }
    		  
    	  }
    	  catch(Exception ex) {
    		  ex.printStackTrace();
    	  }
      }
      if(e.getSource()==b2) {
    	  setVisible(false);
    	  new RemoveEmp();
      }
      if(e.getSource()==b3) {
    	  setVisible(false);
    	  new EmployeesSignup();
      }
      if(e.getSource()==b4) {
    	  setVisible(false);
    	  new NewSignup();
      }
      if(e.getSource()==b5) {
    	  setVisible(false);
    	  new EmployeeWork();
      }
      if(e.getSource()==b6) {
    	  setVisible(false);
    	  new Roles();
      }
		
	}
	public static void main(String args[]) {
		new AdminWork();
	}
	

}


