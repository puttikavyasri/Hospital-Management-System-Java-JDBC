package com.learnJDBC;
//import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatementJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCMySQL", "root", "Kavya@6624");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from students");
		
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
	}

}