package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {
	JLabel l1,l2,l3;
	JTextField t1,t3;
	JButton b1,b2,b3;

	public Withdrawl() {
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.pink);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("WITHDRAWL");
		l1.setFont(new Font("Trebuchet MS ",1,18));
		l1.setForeground(new Color(102,51,0));
		l1.setBounds(240,60,210,30);
		add(l1);
		
		l2=new JLabel("Enter PIN ");
		l2.setFont(new Font("Trebuchet MS ",1,16));
		l2.setForeground(new Color(102,51,0));
		l2.setBounds(50,130,160,30);
		add(l2);
		
		t1=new JTextField();
	    t1.setBackground(Color.white);
	    t1.setBounds(240,130,320,30);
	    add(t1);
	    
	    l3=new JLabel("Enter Amount");
		l3.setFont(new Font("Trebuchet MS ",1,16));
		l3.setForeground(new Color(102,51,0));
		l3.setBounds(50,180,170,30);
		add(l3);
		
		t3=new JTextField();
	    t3.setBackground(Color.white);
	    t3.setBounds(240,180,320,30);
	    add(t3);
	    
	    b1= new JButton("WITHDRAWL");
		b1.setBackground(Color.black);
		b1.setFont(new Font("Tahoma",1,16));
		b1.setForeground(Color.pink);
		b1.setBounds(240,250,160,30);
		add(b1);
		b1.addActionListener(this);
		
		b2= new JButton("BACK");
		b2.setBackground(Color.black);
		b2.setFont(new Font("Tahoma",1,16));
		b2.setForeground(Color.pink);
		b2.setBounds(430,250,110,30);
		add(b2);
		b2.addActionListener(this);

}
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1) {
		try {
			Database c =new Database();
			String p="select  * from login where pin='"+t1.getText()+"'";
			ResultSet rs=c.stm.executeQuery(p);
			if(rs.next()) {
				int bal=rs.getInt(3);
				int amount=Integer.parseInt(t3.getText());
				int remaining=bal-amount;
				String type="withdrawl";
				String pin=t1.getText();
			      if(bal>amount){
					String r="Update login set bal='"+remaining+"' where pin='"+t1.getText()+"'";
					c.stm.executeUpdate(r);
					String q="insert into passbook values('"+pin+"','"+amount+"','"+type+"')";
					c.stm.executeUpdate(q);
					JOptionPane.showMessageDialog(null, "Money withdrawl successfully ");
				    t1.setText("");
				    t3.setText("");
				}
			      else {
			    	  JOptionPane.showMessageDialog(null, "Please Recheck");
			      }
			      
			}
			
			
		}
		catch(Exception ex) {
	    	  ex.printStackTrace();
	      }
	}
	 if(e.getSource()==b2) {
   	  setVisible(false);
   	  new Roles();
     }
}

public static void main(String args[]) {
	new Withdrawl();
}


}
