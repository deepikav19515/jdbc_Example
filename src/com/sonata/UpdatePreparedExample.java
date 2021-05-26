package com.sonata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePreparedExample {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/JDBCExample", "root", "admin@123");
			PreparedStatement ps=con.prepareStatement("update emp set empSal=? where empId=?");
			ps.setDouble(1, 7000);
			ps.setInt(2, 2);
			int a = ps.executeUpdate();
			System.out.println("The number of records updated are "+a);
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
