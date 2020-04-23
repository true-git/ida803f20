/*
 This is the model class.
The model makes the calls to the databse and perform the CRUD actions in the database.
The model is connected to the database.
The model doesnt know the VIEW exists.
 */
package mykitchengarden;

import mykicthengarden.Views.DatabaseConnection;

/**
 *
 * @author jacobchristensen
 */
public class MyKitchenGardenModel {
    
    
    private String user;
    
    
    //connnecting to the database
    DatabaseConnection dbc = new DatabaseConnection();
    
    //login to the app
    public void userLogin(String email, String password) {
        
        
        dbc.executeQuery("select something");
        //TODO code
        // Make a user table in MySQL to store the users inforamtion after registrering
        
    }
    
  
    
    
    
}
