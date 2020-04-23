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
    
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    private String dbName = "kitchengarden";
    private String user = "kitchengardener";
    private String pass = "greenfingers";
    
    public DatabaseConnection() {
        initiate();   
    }
    
    public DatabaseConnection(String databaseName, String username, String password) {
        dbName = databaseName;
        user = username;
        pass = password;
        
        initiate();   
    }
    
    public ResultSet executeQuery(String query) {
        try {
            // 3. Execute SQL query
            myRs = myStmt.executeQuery(query);
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return myRs;
    } 
    
    private void initiate() {
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?serverTimezone=UTC", user, pass);

            // 2. Create a statement
            myStmt = myConn.createStatement();
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
