/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden;
import java.sql.*;
/**
 *
 * @author Kasper jacob
 */
public class MyKitchenGarden {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = "kitchengardener";
        String pass = "greenfingers";

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitchengarden?serverTimezone=UTC", user, pass);

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select * from plants");

            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("common_name") + ", " + myRs.getString("latin_name"));
            } 

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        
    }
    
}
