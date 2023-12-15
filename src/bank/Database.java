package bank;
import java.sql.*;

public class Database {
	Connection con;
	 Statement stm;
	 Statement st;
	 Statement st2;
	 Statement st3;
	 Database(){
		 try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","2301");
			 stm=con.createStatement();
			 st=con.createStatement();
			}
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }

}
