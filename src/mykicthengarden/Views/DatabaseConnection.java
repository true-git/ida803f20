package mykicthengarden.Views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Team PlantLet
 * 
 * 4. Process the result set
         while (myRs.next()) {
             myRs.getString("column_name");
         } 
 */
public class DatabaseConnection {
    
    private Connection myConn = null;
    private Statement myStmt = null;

    private String dbName = "kitchengarden";
    private String user = "kitchengardener";
    private String pass = "greenfingers";

//    public Connection getConnection() {
    public void getConnection() {
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?serverTimezone=UTC", user, pass);

            // 2. Create a statement
            myStmt = myConn.createStatement();

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public Connection getMyConn() {
        return myConn;
    }

    public Statement getMyStmt() {
        return myStmt;
    }
}

