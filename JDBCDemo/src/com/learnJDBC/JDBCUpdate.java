package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdate {

	public static void main(String[] args) {
		

		Connection con = null;
		Statement stmt =null;
     	ResultSet rs = null;
		
		
		
		String URL ="jdbc:mysql://localhost:3306/JDBCMySQL";
		// user name and password while  installing sql
		String Username = "root";
		String Password = "Kavya@6624";
		
		String UpdateRecord ="Update students set name = 'Ram' where id=2";
try {
			
			Class.forName("com.mysql.jdbc.driver");
			
		} catch(ClassNotFoundException e)
		
		{
			System.out.println("In catch"+e.getMessage());
		}

try {
	
	con = DriverManager.getConnection(URL,Username,Password);
	stmt =con.createStatement();
	stmt.execute(UpdateRecord);
	
	System.out.println("Successfull updated");
	
//	rs.close();
	stmt.close();
	con.close();

}catch(SQLException e)
{
	System.out.println("In catch"+e.getMessage());
}

finally
{ if(con != null)
{
	try {
//		rs.close();
		stmt.close();
		con.close();

	System.out.println("Terminated Successfully");

	}

	catch(Exception e)
	{
		System.out.println("oops ! some serious issue");
	}
}
}
		
		

	}

}
