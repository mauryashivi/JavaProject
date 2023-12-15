package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class ToDo extends JFrame implements ActionListener {
	JLabel l1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	public ToDo(){
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.pink);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("Please Select");
		l1.setFont(new Font("Tahoma",1,30));
		l1.setForeground(new Color(242,29,6));
		l1.setBounds(230,30,500,30);
		add(l1);
		
		b1=new JButton("PIN CHANGE");
		b1.setBackground(Color.black);
		b1.setFont(new Font("Tahoma",1,16));
		b1.setForeground(Color.pink);
		b1.setBounds(80,130,200,30);
		add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("BALANCE ENQUIRY");
		b2.setBackground(Color.black);
		b2.setFont(new Font("Tahoma",1,16));
		b2.setForeground(Color.pink);
		b2.setBounds(350,130,200,30);
		add(b2);
		b2.addActionListener(this);
		
		b3=new JButton("DEPOSIT");
		b3.setBackground(Color.black);
		b3.setFont(new Font("Tahoma",1,16));
		b3.setForeground(Color.pink);
		b3.setBounds(80,200,200,30);
		add(b3);
		b3.addActionListener(this);
		
		b4=new JButton("CASH WITHDRAWL");
		b4.setBackground(Color.black);
		b4.setFont(new Font("Tahoma",1,16));
		b4.setForeground(Color.pink);
		b4.setBounds(350,200,200,30);
		add(b4);
		b4.addActionListener(this);
		
		b5=new JButton("FUND TRANSFER");
		b5.setBackground(Color.black);
		b5.setFont(new Font("Tahoma",1,16));
		b5.setForeground(Color.pink);
		b5.setBounds(80,270,200,30);
		add(b5);
		b5.addActionListener(this);
		
		b6=new JButton("EXIT");
		b6.setBackground(Color.black);
		b6.setFont(new Font("Tahoma",1,16));
		b6.setForeground(Color.pink);
		b6.setBounds(350,270,200,30);
		add(b6);
		b6.addActionListener(this);
		
		b7=new JButton("STATEMENT");
		b7.setBackground(Color.black);
		b7.setFont(new Font("Tahoma",1,16));
		b7.setForeground(Color.pink);
		b7.setBounds(80,340,200,30);
		add(b7);
		b7.addActionListener(this);
		
		b8=new JButton("UPDATE");
		b8.setBackground(Color.black);
		b8.setFont(new Font("Tahoma",1,16));
		b8.setForeground(Color.pink);
		b8.setBounds(350,340,200,30);
		add(b8);
		b8.addActionListener(this);

}
	
public void actionPerformed(ActionEvent e) {
	 if(e.getSource()==b1) {
   	  setVisible(false);
   	  new PinChange();
     }
	 if(e.getSource()==b2) {
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
     if(e.getSource()==b3) {
   	  setVisible(false);
   	  new Deposit();
     }
     if(e.getSource()==b4) {
   	  setVisible(false);
   	  new Withdrawl();
     }
     if(e.getSource()==b5) {
   	  setVisible(false);
   	  new FundTransfer();
     }
     if(e.getSource()==b6) {
   	  setVisible(false);
   	  new Roles();
     }
     if(e.getSource()==b7) {
      	  setVisible(false);
      	  new Passbook();
        }
     if(e.getSource()==b8) {
    	 try {
	    		String id=JOptionPane.showInputDialog("enter your Customer Id") ;
	    		Database c=new Database();
	    		String q="Select * from Customerdata where user='"+id+"'";
	    				ResultSet r=c.stm.executeQuery(q);
	    		if(r.next()) {
	    			setVisible(false);
	    			new UpdateCus(id);
	    		}	else {
	    				JOptionPane.showInputDialog("enter your Customer Id") ;
	    			}
	  
	    			
	    		}catch(Exception ex) {
	    			ex.printStackTrace();
	    		}
      	 
        }
		
	}
	public static void main(String args[]) {
		new ToDo();
	}
	

}

