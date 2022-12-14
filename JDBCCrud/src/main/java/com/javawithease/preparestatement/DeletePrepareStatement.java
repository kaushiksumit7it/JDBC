package com.javawithease.preparestatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class DeletePrepareStatement {
	public static void main(String args[]){
		Connection conn = null;
		PreparedStatement preparedStatement = null;
 
		String query = "delete from EMPLOYEE " + 
		"where EMPLOYEE_ID = 1 ";
 
		try{
			//get connection
			conn = JDBCUtil.getConnection();
 
			//create preparedStatement
			preparedStatement = conn.prepareStatement(query);
 
			//execute query
			preparedStatement.executeUpdate();
 
			//close connection
			preparedStatement.close();
			conn.close();
 
		     System.out.println("Record deleted successfully.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}	

}
