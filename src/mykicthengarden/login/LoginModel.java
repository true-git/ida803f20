
package mykicthengarden.login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.CallableStatement;

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
    ResultSet myRs;
    private String dbName = "kitchengarden";
    private String user = "kitchengardener";
    private String pass = "greenfingers";
    

//    public LoginModel(DatabaseConnection dbc) {
    public LoginModel() {
//        this.dbc = dbc;
        dbc = new DatabaseConnection();
    }

    public boolean userValidated(String user_email, String pass_word) throws SQLException {
        String query =  "{call loginRead(?, ?) }"; //"Select pass from users where email = '" + email + "'";
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?serverTimezone=UTC", user, pass);
        CallableStatement stmt =  conn.prepareCall(query);
        try {
 
            stmt.setString(1, user_email);
            stmt.setString(2, pass_word);
            myRs = stmt.executeQuery();
            while (myRs.next()) {
                if (myRs.getString("pass").equals(pass_word)) {
                    myRs.close();
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public String getUserName(String email) throws SQLException{
        String query = "Select firstname from users where email = '" + email + "'";
        dbc.getConnection();
        try {
            ResultSet myRs = dbc.getMyStmt().executeQuery(query);
            while (myRs.next()) {
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
    
    public int getUserId(String email) throws SQLException {
        String query = "Select user_id from users where email = '" + email + "'";
        dbc.getConnection();
        try{
            ResultSet myRs = dbc.getMyStmt().executeQuery(query);
            while (myRs.next()){
                user_id = myRs.getInt("user_id");
                dbc.getMyConn().close();
                return user_id;
            }
        } finally {
            dbc.getMyConn().close();
            
        } return 0;
    }

    
}
