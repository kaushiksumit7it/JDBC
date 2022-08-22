package com.onlinetutorialspoint;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.util.Scanner; 
 
public class Jdbc_PreparedStatement_Example { 
 
    public static void main(String[] args) throws Exception { 

        Connection connection = null; 
        PreparedStatement pstatement = null; 
        Scanner scanner = null; 
 
        try { 
             
            scanner = new Scanner(System.in); 
            int n = 0; 
            System.out.println("Enter no. of Students to insert"); 
            n = scanner.nextInt(); 
         //   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinetutorialspoint", "root", ""); 
            if (connection != null) 
            pstatement = connection.prepareStatement("insert into student values(?,?,?,?)"); 
            if (pstatement != null) { 
                for (int i = 1; i <= n; i++) { 
                    System.out.println("Enter " + i + " Student Details"); 
                    System.out.println("Enter Student No : "); 
                    int studentNo = scanner.nextInt(); 
                    System.out.println("Enter Student Name : "); 
                    String studentName = scanner.next(); 
                    System.out.println("Enter Student Address : "); 
                    String studentAddress = scanner.next(); 
                    System.out.println("Enter Student Age : "); 
                    int studentAge = scanner.nextInt(); 
                    pstatement.setInt(1, studentNo); 
                    pstatement.setString(2, studentName); 
                    pstatement.setString(3, studentAddress); 
                    pstatement.setInt(4, studentAge); 
                    int result = pstatement.executeUpdate(); 
                    if (result == 0) { 
                        System.out.println("Student details: are not inserted"); 
                    } else { 
                        System.out.println(result + " records(s) are  inserted"); 
                    } 
                } 
            } 
         } catch (SQLException se) { 
            se.printStackTrace(); 
          } catch (Exception ex) { 
            ex.printStackTrace(); 
         } finally { 
            try { 
                if (pstatement != null) { 
                    pstatement.close(); 
                } 
            } catch (SQLException se) { 
                se.printStackTrace(); 
            } 
            try { 
                if (connection != null) { 
                    connection.close(); 
                } 
            } catch (SQLException se) { 
                se.printStackTrace(); 
            } 
        } 
    } 
 
}
