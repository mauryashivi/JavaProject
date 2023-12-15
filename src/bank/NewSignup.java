package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class NewSignup extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t3,t4,t5,t7,t8;
	JRadioButton r1,r2;
	ButtonGroup bg;
	JComboBox c1,c2,c3,c4,c5,c6;
	String day[]=new String[31];
	String month[]=new String[12];
	String year[]=new String[26];
	String age[]=new String[60];
	JTextArea tal;
	JButton b1,b2;
	Random R1,R2,R3;
	int n1,n2, pass;
	String user;
	
	public NewSignup() {
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
		
		t3= new JTextField();
		t3.setBackground(Color.white);
		t3.setBounds(194,360,180,25);
		add(t3);
		
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
		
		
		
		b1= new JButton("ADD");
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
		
		R1=new Random();
		n1=1000+R1.nextInt(9999-1000);
		
		R2=new Random();
		n2=1000+R2.nextInt(9999-1000);
		
		R3=new Random();
		pass=1000+R3.nextInt(9999-1000);

		
		user = String.valueOf(n1)+ "-" + String.valueOf(n2);
		
		
	}
	
public void actionPerformed(ActionEvent e) {
	String name,phone,gender="",address,age="",education="",Email,dob="",Favcolor="",aadhar;
	
	name=t1.getText();
	
	if(r1.isSelected()) {
		gender="Male";
	}
	else if(r2.isSelected()) {
		gender="Female";
	}
	age=String.valueOf(c4.getSelectedItem());
	
	Email=t3.getText();
	
	Favcolor=String.valueOf(c5.getSelectedItem());
	
	phone=t5.getText();
	
	address=tal.getText();
	
	education=String.valueOf(c6.getSelectedItem());
	
	dob= String.valueOf(c1.getSelectedItem())+ "-" + String.valueOf(c2.getSelectedItem())+ "-" + String.valueOf(c3.getSelectedItem());
	
	aadhar=t7.getText();
	
	
	
	if(e.getSource()== b1) {
		Database obj = new Database();
		
		String q = "insert into customerdata value('"+ name +"','"+ user +"','"+ pass +"','"+ gender +"','"+ age +"','"+ Email +"','"+ Favcolor+"','"+ phone +"','"+ address +"','"+ education +"','"+ dob +"','"+ aadhar +"')";
		 try {
			 obj.stm.executeUpdate(q);
			 int bal=0;
			 String q2="insert into login(card,pin,bal) value('"+user+"','"+pass+"','"+bal+"')";
			 obj.stm.executeUpdate(q2);
			 JOptionPane.showMessageDialog(null,"Your Employee ID is :"+ user + "\n your pin is: "+ pass);
			 setVisible(false);
			  new AdminWork();
		 }
		 catch(Exception ex) {
			 ex.printStackTrace();
			 JOptionPane.showMessageDialog(null,"Error");
		 }
	}
	else {
		setVisible(false);
		// new AdminWork();
	}
		
}

public static void main(String[] args) {
	new NewSignup();
}


}

