package com.javawithease;

import java.sql.Connection;
import java.sql.Statement;

 
/**
 * This class is used to insert a record in DB table.
 * @author w3spoint
 */
public class InsertStatement {
	public static void main(String args[]){
		Connection conn = null;
		Statement statement = null;
 
		String query = "insert into EMPLOYEE " +
		"(EMPLOYEE_ID, NAME, SALARY) " +
		"values (3, 'Sumit', 675500)";
 
		try{			
			//get connection
			conn = JDBCUtil.getConnection();
 
			//create statement
			statement = conn.createStatement();
 
			//execute query
			statement.executeUpdate(query);
 
			//close connection
			statement.close();
			conn.close();
 
	              System.out.println("Record inserted successfully.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
}
