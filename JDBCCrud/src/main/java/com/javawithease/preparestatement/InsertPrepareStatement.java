package com.javawithease.preparestatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertPrepareStatement {
	public static void main(String args[]){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
 
		String query = "insert into EMPLOYEE " +
			"(EMPLOYEE_ID, NAME, SALARY) " +
			"values (?,?,?)";
 
		try{
			//get connection
			conn = JDBCUtil.getConnection();
 
			//create preparedStatement
			preparedStatement = conn.prepareStatement(query);
 
			//set values
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "Bharat");
			preparedStatement.setInt(3, 62000);
 
			//execute query
			preparedStatement.executeUpdate();
 
			//close connection
			preparedStatement.close();
			conn.close();
 
		      System.out.println("Record inserted successfully.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
}
