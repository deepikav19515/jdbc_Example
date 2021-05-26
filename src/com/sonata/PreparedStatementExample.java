package com.sonata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PreparedStatementExample {

	public static void main(String[] args) {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/JDBCExample", "root", "admin@123");
			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));
			}
		}
		catch(ClassNotFoundException e1)
		{
			System.out.println(e1);
		}
		catch(SQLException e2)
		{
			System.out.println(e2);
		}
	}

}
