package com.onlinetutorialspoint;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.Statement; 
 
public class Jdbc_Update_Example { 
 
    public static void main(String[] args) throws Exception { 
        Connection connection = null; 
 
       
        connection = DriverManager.getConnection( 
                "jdbc:mysql://localhost:3306/onlinetutorialspoint", "root", 
                ""); 
 
        Statement stmt = connection.createStatement(); 
        int count = stmt 
                .executeUpdate("update student set studentName='suresh' where studentNo=1"); 
        System.out.println(count + " Record(s) updated."); 
 
    } 
 
}
