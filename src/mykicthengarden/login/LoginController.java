/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.login;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import mykicthengarden.signup.SignupModel;
import mykicthengarden.signup.SignupView;
import mykicthengarden.signup.SignupController;
import javafx.stage.Stage;
import mykicthengarden.mainMenu.MainMenuController;
import mykicthengarden.mainMenu.MainMenuModel;
import mykicthengarden.mainMenu.MainMenuView;

/**
 *
 * @author Kasper
 */
public class LoginController {
    


    public LoginController(LoginModel loginModel, LoginView loginView, Stage stage) {
       
        
        

        //get the loginButton. when clicked check if the user exist in the database, and check if the password matches
        loginView.getLogin_button().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
                String email_text = loginView.getEmail_text().getText();
                String pass = loginView.getPassword_text().getText();
                
                if(email_text.equals("") || loginView.getPassword_text().getText().equals("")) {
                    Alert(Alert.AlertType.ERROR, "Something");
                }
                
                if(loginModel.userValidated(email_text, pass)){
                    try {
                        MainMenuModel mainMenuModel = new MainMenuModel(loginModel.getUserId(email_text), loginModel.getUserName(email_text));
                        MainMenuView mainMenuView = new MainMenuView(loginModel.getUserName(email_text));
                        System.out.println("user has userID" + loginModel.getUserId(email_text) + "!");
                        stage.getScene().setRoot(mainMenuView);
                        MainMenuController mainMenuController = new MainMenuController(mainMenuModel, mainMenuView, stage);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else{
                    
                    System.out.println("Not validated");
                    
                }
            }
        });
        
        //get the esignup button and go the signupView when pushed.
        loginView.getSignup_button().setOnAction(e -> {
            SignupModel signupModel = new SignupModel();
            SignupView signupView = new SignupView();
            stage.getScene().setRoot(signupView);
            SignupController signupController = new SignupController(signupModel, signupView, stage);
        });
        
        //for easy access, development purpose, use the guest button to access the mainMenu.
        loginView.getGuest_button().setOnAction(e -> {
            
            String email_text = loginView.getEmail_text().getText();
            String pass = loginView.getPassword_text().getText();
            
            try {
                MainMenuModel mainMenuModel = new MainMenuModel(loginModel.getUserId(email_text), loginModel.getUserName(email_text));
                MainMenuView mainMenuView = new MainMenuView("Jacob");
                stage.getScene().setRoot(mainMenuView);
                MainMenuController mainMenuController = new MainMenuController(mainMenuModel, mainMenuView, stage);
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    
    }

    private void Alert(Alert.AlertType alertType, String string) {
        
    }
    
}
