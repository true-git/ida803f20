
package mykicthengarden.login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import mykicthengarden.Views.DatabaseConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class LoginModel {
    
    
    DatabaseConnection dbc;
    private String userName;
    private int user_id;

    public LoginModel() {
        dbc = new DatabaseConnection();
    }

    // Check if the user is in the system, by the email and password
    public boolean userValidated(String email, String password) {
        
        // SQL statement to send to the database
        String query = "Select pass from users where email = '" + email + "'";
        dbc.getConnection();
        try {
            //Get the result of the query in the database, and see if it matches with the password input
            ResultSet myRs = dbc.getMyStmt().executeQuery(query);
            while (myRs.next()) {
                if (myRs.getString("pass").equals(password)) {
                    myRs.close();
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //get the username from the database, using the email input.
    public String getUserName(String email) throws SQLException{
        String query = "Select firstname from users where email = '" + email + "'";
        dbc.getConnection();
        try {
            //store the result from the query
            ResultSet myRs = dbc.getMyStmt().executeQuery(query);
            while (myRs.next()) {
                
                //save the result into a variable "username", and return the username
                userName = myRs.getString("firstname");
                dbc.getMyConn().close();
                return userName;
            }
        } catch (Exception e) {
        }
{           
            
            ResultSet myRs = dbc.getMyStmt().executeQuery(query);
            while (myRs.next()) {
                userName = myRs.getString("firstname");
                dbc.getMyConn().close();
                return userName;
            } 
                    
        } 

        
        return null;
    }    
    
    //get the userid from the database
    public int getUserId(String email) throws SQLException {
        String query = "Select user_id from users where email = '" + email + "'";
        dbc.getConnection();
        try{
            
            ResultSet myRs = dbc.getMyStmt().executeQuery(query);
            while (myRs.next()){
                
                //store the userid in a variable user_id
                user_id = myRs.getInt("user_id");
                dbc.getMyConn().close();
                return user_id;
            }
        } finally {
            dbc.getMyConn().close();
            
        } return 0;
    }

    
}
