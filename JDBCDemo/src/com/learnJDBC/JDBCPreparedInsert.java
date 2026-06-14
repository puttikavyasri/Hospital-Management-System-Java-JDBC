package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;

public class JDBCPreparedInsert {

	public static void main(String[] args) {
		Connection con = null;
//		Statement stmt =null;
//     	ResultSet rs = null;
		

		String URL ="jdbc:mysql://localhost:3306/JDBCMySQL";
		// user name and password while  installing sql
		String Username = "root";
		String Password = "Kavya@6624";
		
		String Query = "insert into students(id,name,dept) values (?,?,?)";
		
		try {
			
			con = DriverManager.getConnection(URL,Username,Password);
//			stmt =con.createStatement();
//			stmt.execute(DeleteRecord);
			
			PreparedStatement preparedStatement = con.prepareStatement(Query);
			preparedStatement.setInt(1,9);
			preparedStatement.setString(2,"Srii");
			preparedStatement.setString(3,"Biotechnology");
			
			preparedStatement.execute();
			
			
//			rs.close();
//			stmt.close();
			con.close();
			System.out.println("Insereted Successfull");

		}catch(SQLException e)
		{
			System.out.println("In catch"+e.getMessage());
		}

		
		finally
		{ if(con != null)
		{
			try {
//				rs.close();
			//	stmt.close();
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
