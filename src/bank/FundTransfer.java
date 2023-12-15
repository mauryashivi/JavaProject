package bank;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
public class FundTransfer extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3;
	JButton b1,b2;
	
	public FundTransfer() {
		setBounds(150,80,678,560);
		getContentPane().setBackground(Color.pink);
		setVisible(true);
		setLayout(null);
		
		l1=new JLabel("TRANSFER");
		l1.setFont(new Font("Trebuchet MS ",1,18));
		l1.setForeground(new Color(102,51,0));
		l1.setBounds(260,60,210,30);
		add(l1);
		
		l2=new JLabel("ENTER PIN ");
		l2.setFont(new Font("Trebuchet MS ",1,16));
		l2.setForeground(new Color(102,51,0));
		l2.setBounds(56,123,320,25);
		add(l2);
		
		t1=new JTextField();
	    t1.setBackground(Color.white);
	    t1.setBounds(345,123,260,25);
	    add(t1);
	    
	    l3=new JLabel("Enter AMOUNT ");
		l3.setFont(new Font("Trebuchet MS ",1,16));
		l3.setForeground(new Color(102,51,0));
		l3.setBounds(56,182,250,25);
		add(l3);
		
		t2=new JTextField();
	    t2.setBackground(Color.white);
	    t2.setBounds(345,182,260,25);
	    add(t2);
	    
	    l4=new JLabel("TRANSFER TO CARD NO. ");
		l4.setFont(new Font("Trebuchet MS ",1,16));
		l4.setForeground(new Color(102,51,0));
		
		l4.setBounds(56,240,250,25);
		add(l4);
		
		t3=new JTextField();
	    t3.setBackground(Color.white);
	    t3.setBounds(345,240,260,25);
	    add(t3);
	    
	    
	    b1= new JButton("TRANSFER");
		b1.setBackground(Color.black);
		b1.setFont(new Font("Tahoma",1,16));
		b1.setForeground(Color.pink);
		b1.setBounds(340,290,130,35);
		add(b1);
		b1.addActionListener(this);
		
		b2= new JButton("CANCEL");
		b2.setBackground(Color.black);
		b2.setFont(new Font("Tahoma",1,16));
		b2.setForeground(Color.pink);
		b2.setBounds(500,290,110,35);
		add(b2);
		b2.addActionListener(this);

}
public void actionPerformed(ActionEvent e) {
	if(e.getSource()== b1) {
		try {
			Database obj = new Database();
			String p ="select * from login where pin ='"+t1.getText()+"'";		
			ResultSet rs = obj.stm.executeQuery(p);
			String a ="select * from login where card ='"+t3.getText()+"'";
			ResultSet b = obj.st.executeQuery(a);
			if(rs.next()) {
				if(b.next()) {
					int bal= rs.getInt(3);
					int money = b.getInt(3);
					int amount = Integer.parseInt(t2.getText());
					int remaining = bal-amount;
					int current = money+amount;
					String type1="Debit";
					String type2="Credit";
					String pin1= t1.getText();
					String pin2 = t3.getText();
					
			if(bal>amount) {
						String r = "update login set bal='"+remaining +"' where pin ='"+t1.getText()+"'";
						obj.stm.executeUpdate(r);
						String q1= "insert into passbook values('"+pin1+"','"+amount+"','"+type1+"')";
						obj.stm.executeUpdate(q1);
						String q = "update login set bal='"+current+"' where card='"+t3.getText()+"'";
						obj.stm.executeUpdate(q);
						String q2= "insert into passbook values('"+pin1+"','"+amount+"','"+type2+"')";
						obj.stm.executeUpdate(q2);
						JOptionPane.showMessageDialog(null,"Money Transfered Successfully ");
						t1.setText("");
						t2.setText("");
						t3.setText("");		
					}
		else {
				JOptionPane.showMessageDialog(null,"Insufficient balance");
		}
		}
		else {
			JOptionPane.showMessageDialog(null,"Error");
		}
	}
 }			
			
		catch(Exception ex) {
			ex.printStackTrace();
		}
		}
		else {
			setVisible(false);
		//	 new ToDo();
				}
}

public static void main(String[] args) {
		new FundTransfer();
	}


	}
	
