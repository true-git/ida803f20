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
 * @author Team PlantLet
 */
public class MyKitchenGardenModel {
    
    private DatabaseConnection dbc;
    
    public MyKitchenGardenModel(){
        //open db connection setup
        dbc = new DatabaseConnection();
    }
    
//    private String email;
//    private String password; // guardedstring oracle
    
    
//    //connnecting to the database
//    DatabaseConnection dbc = new DatabaseConnection();
//    
//    //login to the app
//    public void userLogin(String email, String password) {
//        
//        
//        dbc.executeQuery("select something");
//        //TODO code
//        // Make a user table in MySQL to store the users inforamtion after registrering
//        
//    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//    
//    public boolean emailEntryMatches(String email_text){
//        return email_text.equals(email);
//    }
    
    public boolean createUser(String email, String password){
        if (emailExists(email) || !passwordMatches(password)) {
            return false;//inform email exists
        } else {
            //create user in db
            return true;
        }
    }
    
    public boolean userValidated(String email, String password){
        if (emailExists(email) && passwordMatches(password)) {
            return true;//inform email exists
        } else return false;
    }
    
    private boolean emailExists(String email){
        if (email.equals("")){ // replace "" with db search result
            return true;
        } else return false;
    }
    
    private boolean passwordMatches(String password){
        return true;
    }
  
    
    
    
}
