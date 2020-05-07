/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import mykicthengarden.Views.DatabaseConnection;

/**
 *
 * @author Kasper
 */
public class LoginModel {
    
    DatabaseConnection dbc;

//    public LoginModel(DatabaseConnection dbc) {
    public LoginModel() {
//        this.dbc = dbc;
        dbc = new DatabaseConnection();
    }
    
//    public boolean createUser(String email, String password){
//        if (emailExists(email) || !passwordMatches(password)) {
//            return false;//inform email exists
//        } else {
//            //create user in db
//            return true;
//        }
//    }
    
    public boolean userValidated(String email, String password){
        String query = "Select pass from users where email = '" + email + "'";
        ResultSet myRs = dbc.executeQuery(query);
        try {
            while (myRs.next()){
                if(myRs.getString("pass").equals(password)){
                    myRs.close();
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
}