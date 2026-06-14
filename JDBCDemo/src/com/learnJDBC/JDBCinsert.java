//package com.learnJDBC;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
////import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class JDBCInsertRecord {
//
//	public static void main(String[] args) {
//
//		Connection con = null;
//		Statement stmt =null;
////     	ResultSet rs = null;
//		
//     	
//
//		String URL ="jdbc:mysql://localhost:3306/JDBCMySQL";
//		// user name and password while  installing sql
//		String Username = "root";
//		String Password = "Kavya@6624";
//		
//try {
//			
//			Class.forName("com.mysql.jdbc.driver");
//			
//		} catch(ClassNotFoundException e)
//		
//		{
//			System.out.println("In catch"+e.getMessage());
//		}
//
//
//try {
//	
//	con = DriverManager.getConnection(URL,Username,Password);
//	stmt =con.createStatement();
//	stmt.execute("insert into Students values (3,'Sangeetha', 'IT')");
//	stmt.execute("insert into Students values (4,'Kavya sri', 'ECE')");
//	stmt.execute("insert into Students values (5,'Rachan', 'EEE')");
//	stmt.execute("insert into Students values (6,'Nakshatra', 'MECH')");
//	
//	System.out.println("Successfull Inserted");
//	
////	rs.close();
//	stmt.close();
//	con.close();
//
//}catch(SQLException e)
//{
//	System.out.println("In catch"+e.getMessage());
//}
//
//finally
//{ if(con != null)
//{
//	try {
////		rs.close();
//		stmt.close();
//		con.close();
//
//	System.out.println("Terminated Successfully");
//
//	}
//
//	catch(Exception e)
//	{
//		System.out.println("oops ! some serious issue");
//	}
//}
//}
//		
//		
//
//
//	}
//
//}
package com.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCinsert {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        String URL = "jdbc:mysql://localhost:3306/JDBCMySQL";
        String username = "root";
        String password = "Kavya@6624";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            con = DriverManager.getConnection(URL, username, password);
            stmt = con.createStatement();

            // Execute insert queries
            stmt.execute("insert into students values(2,'Sravanthi','CSE')");
            stmt.execute("insert into students values(3,'Anusha','CSM')");
            stmt.execute("insert into students values(4,'Mythili','CSE')");
            stmt.execute("insert into students values(5,'Kavya sri','CSM')");

            System.out.println("Successfully updated");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                System.out.println("Terminated successfully");
            } catch (Exception e) {
                System.out.println("Oops! Some issue during closing: " + e.getMessage());
            }
        }
    }
}
