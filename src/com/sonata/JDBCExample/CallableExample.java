package com.sonata.JDBCExample;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableExample {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/JDBCExample", "root", "admin@123");
			CallableStatement cs = con.prepareCall("{call UPDTE(?,?)}");
			cs.setInt(1, 8);
			cs.setString(2, "Gagan");
			//cs.setDouble(3, 2000);
			
			int rs=cs.executeUpdate();
			System.out.println("The number of record inserted is "+ rs);
			
		}
		catch(ClassNotFoundException e1)
		{
			System.out.println(e1);
		}
		catch(SQLException e2)
		{
			e2.printStackTrace();
		}
	}

}

//mysql> DELIMITER //
//mysql> create procedure saveProduct(IN pid int, IN pname varchar(30), IN pprice double)
//    -> begin
//    -> insert into product values(productId, productName, productPrice);
//    -> END //

/*mysql> DELIMITER //
mysql> CREATE PROCEDURE UPDTE(IN EID INT, IN ENAME VARCHAR(20))
    -> BEGIN
    -> UPDATE EMP
    -> SET
    -> empName=ENAME WHERE empId=EID;
    -> END //
    */

/*
mysql> DELIMITER //
mysql> CREATE PROCEDURE DEL(IN EMPLOYEEID INT)
    -> BEGIN
    -> DELETE FROM EMP
    -> WHERE empId=EMPLOYEEID;
    -> END //
    */
