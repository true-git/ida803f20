/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.signup;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import mykicthengarden.login.LoginController;
import mykicthengarden.login.LoginModel;
import mykicthengarden.login.LoginView;
import mykicthengarden.mainMenu.MainMenuController;
import mykicthengarden.mainMenu.MainMenuModel;
import mykicthengarden.mainMenu.MainMenuView;

/**
 *
 * @author Kasper
 */
public class SignupController {
    
    public SignupController(SignupModel signupModel, SignupView signupView, Stage stage) {

        //When back button is clicked, go to login view
        signupView.getBack_button().setOnAction(e -> {
            LoginModel loginModel = new LoginModel();
            LoginView loginView = new LoginView();
            stage.getScene().setRoot(loginView);
            LoginController loginController = new LoginController(loginModel, loginView, stage);
        });

        //When signup button is clicked
        signupView.getSignup_button().setOnAction(e -> {
            try {
                //If email exists in database
                if (signupModel.emailExists(signupView.getEmail_text().getText())) {
                    // Update view to inform user
                    System.out.println("Email already exists");
                } else {
                    
                    //Create user and update database
                    signupModel.createUser(signupView.getFirst_name_text().getText(), signupView.getLast_name_text().getText(),
                            signupView.getEmail_text().getText(), signupView.getPassword_text().getText(),
                            signupView.getCity_textfield().getText());
                    //Inform user that account has been created
                    System.out.println("New user created");
                    
                    //Go to mainmenu
                    MainMenuModel mainMenuModel = new MainMenuModel();
                    MainMenuView mainMenuView = new MainMenuView();
                    stage.getScene().setRoot(mainMenuView);
                    MainMenuController mainMenuController = new MainMenuController(mainMenuModel, mainMenuView, stage);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
