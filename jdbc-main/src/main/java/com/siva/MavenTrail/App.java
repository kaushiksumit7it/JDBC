package com.siva.MavenTrail;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//import org.graalvm.compiler.lir.alloc.SaveCalleeSaveRegisters;

public class App {

	public static void main(String[] args) throws SQLException {

		try {
			// save();
			update();
			getAllStud();
			//update();
			//delete();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("```````````````````````````");
			System.out.println("Connection Closed");
			Utility.closeConnection();
		}
	}

	private static void save() throws SQLException {

		Scanner scanner = new Scanner(System.in);
		Student student = new Student();
		System.out.println("Stud ID: ");
		student.setStudId(scanner.nextInt());
		System.out.println("Stud Name: ");
		student.setStudName(scanner.next());
		scanner.close();
		DAO.saveStud(student);

	}

	private static void getAllStud() throws SQLException {
		DAO.getAllStud();
	}

	private static void update() throws SQLException {

		Scanner scanner = new Scanner(System.in);
		Student student = new Student();
		System.out.println("Stud ID: ");
		student.setStudId(scanner.nextInt());
		System.out.println("Stud Name: ");
		student.setStudName(scanner.next());
		scanner.close();
		DAO.updateStud(student);
	}
	private static void delete() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		
		int studentid =scanner.nextInt();
		scanner.close();
		DAO.deleteStud(studentid);
		
	}
}
