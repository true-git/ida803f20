/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.signup;


import java.sql.ResultSet;
import java.sql.SQLException;
import mykicthengarden.Views.DatabaseConnection;

/**
 *
 * @author Kasper
 */
public class SignupModel {
    
    private DatabaseConnection dbc;
    int user_id;
    String userName;
    
    public SignupModel() {
        dbc = new DatabaseConnection();
    }
    
    // Evaluate if the email exists in the database
    public boolean emailExists(String email) throws SQLException {
        // SQL query as a string that selects the emails from the users table that matches the email to be evaluated
        String query = "Select email from users where email = '" + email + "'";
        // Establish connection to the database
        dbc.getConnection();
        try {
            // Execute the query and put the result in myRs
            ResultSet myRs = dbc.getMyStmt().executeQuery(query);
            // Go through the result that matched the query
            while (myRs.next()){
                // If the email is matched to an email in the users table return true
                if(myRs.getString("email").equals(email)){
                    // Close the connection to the database
                    dbc.getMyConn().close();
                    return true;
                }
            }
        } finally {
            // Make sure the connection to the database has been closed
            dbc.getMyConn().close();
        }
        // If no emails from users table matched the email, retrun false
        return false;
    }
    
    // Inserts user to database
    public void createUser(String firstName, String lastName, String email, String password, String city) throws SQLException{
        // Establish connection to the database
        dbc.getConnection();
        // SQL query as a string that updates the users table by inserting the arguments in a new record
        String query = "INSERT INTO users (firstname, lastname, email, pass, city) VALUES "
                + "('" + firstName + 
                "', '" + lastName + 
                "', '" + email + 
                "', '" + password + 
                "', '" + city +
                "')";
        // Execute the query
        dbc.getMyStmt().executeUpdate(query);
        dbc.getMyConn().close();
    }
    
}