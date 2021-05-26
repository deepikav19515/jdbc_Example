package com.sonata.JDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertPreparedExample {

	public static void main(String[] args) {
		List<Employee> l1 = new ArrayList<>();
		Employee e=new Employee();
		e.setEmpId(6);
		e.setEmpName("Ramya");
		e.setEmpSal(2000.0);
		l1.add(e);
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection
		("jdbc:mysql://localhost:3306/JDBCExample", "root", "admin@123");
		PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
		for(Employee es : l1)
		{
			ps.setInt(1, es.getEmpId());
			ps.setString(2, es.getEmpName());
			ps.setDouble(3, es.getEmpSal());
			int a = ps.executeUpdate();
			System.out.println("Rows Updated: "+a);
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
