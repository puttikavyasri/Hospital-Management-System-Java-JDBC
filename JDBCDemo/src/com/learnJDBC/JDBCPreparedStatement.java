package com.learnJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPreparedStatement {

    public static void main(String[] args) {
        Connection con = null;
        ResultSet rs = null;

        String URL = "jdbc:mysql://localhost:3306/JDBCMySQL";
        String Username = "root";
        String Password = "Kavya@6624";
        String Query = "SELECT * FROM students WHERE name = ?";

        try {
            con = DriverManager.getConnection(URL, Username, Password);

            PreparedStatement preparedStatement = con.prepareStatement(Query);
            preparedStatement.setString(1, "Gita");

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println("______________________________________________");
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("dept");

                System.out.println("Student ID: " + id);
                System.out.println("Student Name: " + name);
                System.out.println("Student Department: " + dept);
                System.out.println("______________________________________________");
            }

        } catch (SQLException e) {
            System.out.println("Driver not loaded or SQL error occurred");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (con != null) con.close();
                System.out.println("Terminated Successfully");
            } catch (Exception e) {
                System.out.println("Oops! Some serious issue during closing");
            }
        }
    }
}
