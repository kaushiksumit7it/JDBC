package com.onlinetutorialspoint;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
 
public class Jdbc_Select_Example { 
 
    public static void main(String[] args) throws Exception { 
        
        Connection con = DriverManager.getConnection( 
                "jdbc:mysql://localhost:3306/onlinetutorialspoint", "root", ""); 
        Statement stmt = con.createStatement(); 
        ResultSet rs = stmt.executeQuery("select * from student"); 
        while (rs.next()) { 
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " 
                    + rs.getString(3)); 
        } 
    }
}
