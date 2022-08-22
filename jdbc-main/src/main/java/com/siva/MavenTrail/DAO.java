package com.siva.MavenTrail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

	static Connection conn = null;

	static void saveStud(Student student) throws SQLException {
		int count;
	//	conn = Utility.createConnection();
		conn=Utility.createConnection();
	//	Statement st1=conn.createStatement();
		Statement statement = conn.createStatement();
		count = statement
				.executeUpdate("insert into student values(" + student.getStudId() + ",'" + student.getStudName() + "')");
		System.out.println("stud added" + count);
	}

	static void getAllStud() throws SQLException {
		ResultSet resultset = null;
		conn = Utility.createConnection();
		Statement statement = conn.createStatement();
		resultset = statement.executeQuery("select * from student");
		while (resultset.next()) {
			System.out.println(
					"Stud Id: " + resultset.getInt("studId") + " Stud Name " + resultset.getString("studName"));
		}
	}

	static void updateStud(Student student) throws SQLException {
		// TODO Auto-generated method stub
		conn = Utility.createConnection();
		Statement statement = conn.createStatement();
		statement.executeUpdate(
				"Update student set studName='" + student.getStudName() + "' where studId =" + student.getStudId());
	}

	public static void deleteStud(int studentId) throws SQLException {
		conn = Utility.createConnection();
		Statement statement = conn.createStatement();
		statement.executeUpdate("Delete from student where studId =" + studentId);
	}

}