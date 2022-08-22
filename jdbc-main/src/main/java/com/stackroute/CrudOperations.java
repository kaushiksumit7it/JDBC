package com.stackroute;

import java.sql.*;

public class CrudOperations {
    private Connection connection;

    //insert customer
    public void insertCustomer() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbctest", "root", "");
            System.out.println("got connected");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Customer (customer_id, customer_name) VALUES (?, ?)");
            statement.setInt(1, 2);
            statement.setString(2, "Jaswanth");

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Customer inserted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // Read data
    public void displayCustomers() {
        try {
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            //create connection
            //here customerDB is database name, root is username and root is password
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbctest", "root", "");
            System.out.println("Connected");

            //create statement object
            Statement stmt = connection.createStatement();

            //execute query
            ResultSet rs = stmt.executeQuery("select * from Customer");
            //process result
            while (rs.next())
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //update operation
    public void updateCustomer() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbctest", "root", "");
            System.out.println("got connected");

            PreparedStatement stmnt = connection.prepareStatement("UPDATE Customer SET customer_name=? WHERE customer_id=?");
            stmnt.setString(1, "Jaswanth Sai");
            stmnt.setInt(2, 2);

            int rowsUpdated = stmnt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Customer updated successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //    delete operation
    public void deleteCustomer() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbctest", "root", "");
            System.out.println("got connected");

            PreparedStatement stmnt = connection.prepareStatement("DELETE FROM Customer WHERE customer_id=?");
            stmnt.setString(1, "1");

            int rowsDeleted = stmnt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Customer deleted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}