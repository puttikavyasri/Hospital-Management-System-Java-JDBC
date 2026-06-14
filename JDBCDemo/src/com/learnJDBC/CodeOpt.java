package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CodeOpt {

	public static void main(String[] args) {
		
//		Connection con = null;
//		Statement stmt =null;
//		ResultSet rs = null;
		
		
		
		String URL ="jdbc:mysql://localhost:3306/JDBCMySQL";
		// user name and password while  installing sql
		String Username = "root";
		String Password = "Kavya@6624";
		
		//query that we want to execute
		String query ="select * from Students";
		try {
			
			Class.forName("com.mysql.jdbc.driver");
			
		} catch(ClassNotFoundException e)
		
		{
			System.out.println("In catch"+e.getMessage());
		}
		 
		try {
			
			Connection con = DriverManager.getConnection(URL,Username,Password);
			Statement stmt =con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
	
			while(rs.next())
			{
				System.out.println("______________________________________________");
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String dept = rs.getString("dept");
			
			System.out.println("stubent ID :"+id);
			System.out.println("stubent Name :"+name);
			System.out.println("stubent Department :"+dept);
			
			System.out.println("______________________________________________");
			
			}
			rs.close();
			stmt.close();
			con.close();
			
		}catch(SQLException e)
		{
			System.out.println("In catch"+e.getMessage());
		}

//		finally
//		{ if(con != null)
//		{
//			try {
//				rs.close();
//				stmt.close();
//				con.close();
//				
//				System.out.println("succ");
//				
//			}
//			
//			catch(Exception e)
//			{
//				System.out.println("nosucc");
//			}
//		}
//		}
	}

}

