package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class UpdateCus extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1,t5,t7,t8;
	JRadioButton r1,r2;
	ButtonGroup bg;
	JComboBox c1,c2,c3,c4,c5,c6;
	String day[]=new String[31];
	String month[]=new String[12];
	String year[]=new String[26];
	String age[]=new String[99];
	JTextArea tal;
	JButton b1,b2;
	String user;
	
	public UpdateCus(String id) {
		user=id;
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.pink);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("Welcome!");
		l1.setFont(new Font("Trebuchet MS ",1,18));
		l1.setForeground(new Color(102,51,0));
		l1.setBounds(297,26,263,40);
		add(l1);
		
		l2=new JLabel("* Name: ");
		l2.setFont(new Font("Trebuchet MS ",1,16));
		l2.setForeground(new Color(102,51,0));
		l2.setBounds(56,123,100,25);
		add(l2);
		
		t1=new JTextField();
	    t1.setBackground(Color.white);
	    t1.setBounds(194,123,167,25);
	    add(t1);
	    
	    l3=new JLabel("* Gender: ");
		l3.setFont(new Font("Trebuchet MS ",1,16));
		l3.setForeground(new Color(102,51,0));
		l3.setBounds(56,182,100,25);
		add(l3);
	    
		r1=new JRadioButton("Male");
		r1.setBackground(Color.pink);
		r1.setBounds(194,182,70,25);
		add(r1);
		
		r2=new JRadioButton("Female");
		r2.setBackground(Color.pink);
		r2.setBounds(274,182,70,25);
		add(r2);
		
		bg= new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		
		l4=new JLabel("* Age: ");
		l4.setFont(new Font("Trebuchet MS ",1,16));
		l4.setForeground(new Color(102,51,0));
		l4.setBounds(56,241,100,25);
		add(l4);
		 
		for(int i=21;i<=60;i++) {
			 age[i-21]=String.valueOf(i);
		 }
		 
		c4= new JComboBox(age);
		c4.setBounds(194,241,117,25);
		add(c4);
		
		
		l5= new JLabel("* Email ID: ");
		l5.setFont(new Font("Trebuchet Ms", 1,16));
		l5.setForeground(new Color(102,51,0));
		l5.setBounds(56,359,100,25);
		add(l5);
		
		t8= new JTextField();
		t8.setBackground(Color.white);
		t8.setBounds(194,360,180,25);
		add(t8);
		
		l6=new JLabel("* Fav. Color: ");
		l6.setFont(new Font("Trebuchet MS ",1,16));
		l6.setForeground(new Color(102,51,0));
		l6.setBounds(56,300,100,25);
		add(l6);
		
		String FavColor[] = {"Yellow","Green","Blue","Black","Red"};
		
		c5= new JComboBox(FavColor);
		c5.setBounds(195,300,100,25);
		add(c5);
		
		
	    l7=new JLabel("* Phone: ");
		l7.setFont(new Font("Trebuchet MS ",1,16));
		l7.setForeground(new Color(102,51,0));
		l7.setBounds(418,123,100,25);
		add(l7);
		
		t5=new JTextField();
	    t5.setBackground(Color.white);
	    t5.setBounds(560,123,167,25);
	    add(t5);
	    
	    l8=new JLabel("* Address: ");
		l8.setFont(new Font("Trebuchet MS ",1,16));
		l8.setForeground(new Color(102,51,0));
		l8.setBounds(418,182,100,25);
		add(l8);
		
		tal= new JTextArea();
		tal.setBackground(Color.white);
		tal.setBounds(560,170,180,55);
		add(tal);
		
		l9=new JLabel("* Education: ");
		l9.setFont(new Font("Trebuchet MS ",1,16));
		l9.setForeground(new Color(102,51,0));
		l9.setBounds(418,241,100,25);
		add(l9);
	    
		String Education[]= {"12th","Graduation","Post-Graduation","Other"};
		
		c6= new JComboBox(Education);
		c6.setBounds(560,241,167,25);
		add(c6);
		
		l10=new JLabel("* D.O.B: ");
		l10.setFont(new Font("Trebuchet MS ",1,16));
		l10.setForeground(new Color(102,51,0));
		l10.setBounds(418,300,100,25);
		add(l10);
		
		for(int i=1;i<=31;i++) {
			day[i-1]=String.valueOf(i);
		}
		
		c1= new JComboBox(day);
		c1.setBounds(560,300,50,25);
		add(c1);
		
		for(int i=1;i<=12;i++) {
			month[i-1]=String.valueOf(i);
		}
		
		c2= new JComboBox(month);
		c2.setBounds(610,300,50,25);
		add(c2);
		
		for(int i=1990;i<=2015;i++) {
			year[i-1990]=String.valueOf(i);
		}
		
		c3= new JComboBox(year);
		c3.setBounds(666,300,80,25);
		add(c3);
		
		l11= new JLabel("* Aadhar Number: ");
		l11.setFont(new Font("Trebuchet Ms", 1,16));
		l11.setForeground(new Color(102,51,0));
		l11.setBounds(418,359,190,25);
		add(l11);
		
		t7= new JTextField();
		t7.setBackground(Color.white);
		t7.setBounds(560,359,167,25);
		add(t7);
		
		
		
		b1= new JButton("Update");
		b1.setBackground(Color.black);
		b1.setFont(new Font("Tahoma",1,16));
		b1.setForeground(Color.pink);
		b1.setBounds(283,450,110,35);
		add(b1);
		b1.addActionListener(this);
		
		b2= new JButton("CANCEL");
		b2.setBackground(Color.black);
		b2.setFont(new Font("Tahoma",1,16));
		b2.setForeground(Color.pink);
		b2.setBounds(470,450,110,35);
		add(b2);
		b2.addActionListener(this);
		
try {
			
			Database obj =new Database();
			String str="select * from customerdata where user='"+user+"'";
			ResultSet rs=obj.stm.executeQuery(str);
			
			
			if(rs.next()) {
				
				
				t1.setText(rs.getString(1));
				t8.setText(rs.getString(6));
				t5.setText(rs.getString(8));
				tal.setText(rs.getString(9));
				t7.setText(rs.getString(12));
				c4.setSelectedItem(rs.getString(5));
				c5.setSelectedItem(rs.getString(7));
				c6.setSelectedItem(rs.getString(10));
				
			}
			else {
				JOptionPane.showMessageDialog(null,"CARD NO. WRONG");
				setVisible(false);
				new ToDo();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

public void actionPerformed(ActionEvent e)

{
	

try {
	String gender="",dob="";
	dob= String.valueOf(c1.getSelectedItem()) + "-" + String.valueOf(c2.getSelectedItem()) + "-" + String.valueOf(c3.getSelectedItem()) ;
	
	if(r1.isSelected()) {
		gender= "Male";
	}
	else if(r2.isSelected()){
		gender= "Female";
	}
	if(e.getSource()==b1 ) {
		
		if(t1.getText().matches("[a-zA-Z]+")== false || t8.getText().contains("@") == false || t5.getText().matches("[0-9]+") == false || t7.getText().matches("[0-9]+") == false || t8.getText().equals("") || t1.getText().equals("") || tal.equals("")|| t5.getText().equals("")||t7.getText().equals("") || t5.getText().length()!=10|| t7.getText().length()!=12) {
			
			if(t8.getText().equals("") ) {
				JOptionPane.showMessageDialog(null,"EMAIL ID should not be empty");
			}
			else if (t8.getText().contains("@") == false){
			
				JOptionPane.showMessageDialog(null,"INVALID EMAIL ID ");
			}
			else {
				
			}
			
		
		if(t1.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"NAME should not be empty");
		}
		else if(t1.getText().matches("[a-zA-Z]+")== false) {
		
				JOptionPane.showMessageDialog(null,"ENTER ONLY LETTERS IN NAME ");
			}
		else {
			
		}
		
		if(tal.equals("")) {
			JOptionPane.showMessageDialog(null,"ADDRESS should not be empty");
		}
		
		if(t5.getText().equals("") ){
			JOptionPane.showMessageDialog(null,"PHONE NUMBER should not be empty ");
		}
		else if(t5.getText().matches("[0-9]+") == false) {
			 
			JOptionPane.showMessageDialog(null,"ENTER ONLY DIGITS IN PHONE NUMBER ");
		}
		else if( t5.getText().length()<10 ) {
			JOptionPane.showMessageDialog(null,"PHONE NUMBER length should be 10");
		}
		else if( t5.getText().length()>10 ) {
			JOptionPane.showMessageDialog(null,"PHONE NUMBER length should be 10");
		}
		
		
		else {
			
		}
		
		
		if(t7.getText().equals("") ) {
			JOptionPane.showMessageDialog(null,"AADHAR NUMBER should not be empty and length should be 12");
		}
		else if( t7.getText().matches("[0-9]+") == false) {
			 
			JOptionPane.showMessageDialog(null,"ENTER ONLY DIGITS IN AADHAR NUMBER ");
		}
		else if(t7.getText().length()<12 ) {
			JOptionPane.showMessageDialog(null,"AADHAR NUMBER length should be 12");
		}
		else if(t7.getText().length()>12 ) {
			JOptionPane.showMessageDialog(null,"AADHAR NUMBER length should be 12");
		}
		
		else {
			
		}
		
		
		}
	
	else{
        Database obj = new Database();
		String s="update customerdata set name='"+t1.getText()+"',gender='"+gender+"',age='"+c4.getSelectedItem()+"',email='"+t8.getText()+"',favcolor='"+c5.getSelectedItem()+"',phone='"+t5.getText()+"',address='"+tal.getText()+"',education='"+c6.getSelectedItem()+"',dob='"+dob+"',aadhar='"+t7.getText()+"' where user='"+user+"'";
		obj.stm.executeUpdate(s);
		setVisible(false);
		new ToDo();
		JOptionPane.showMessageDialog(null,"UPDATED");
		
		
	}
	}
	else if(e.getSource()==b2) {
		setVisible(false);
		new ToDo();
	}
}catch(Exception ex) {
	ex.printStackTrace();
}
}
public static void main(String[] args) {
      
}

}
		
			
		
	
	
