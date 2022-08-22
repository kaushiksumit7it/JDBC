package com.stackroute;

import java.sql.SQLException;

public class JdbcDemo {
    public static void main(String[] args) throws SQLException {
        CrudOperations crudOperations = new CrudOperations();

//        perform these operation logically to view results

        // check insertion
        crudOperations.insertCustomer();
        // check read of data
        crudOperations.displayCustomers();
        // check update of data
    //    crudOperations.updateCustomer();
        // check read of data
    //    crudOperations.displayCustomers();
        //delete
    //    crudOperations.deleteCustomer();



    }
}
