/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.login;

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
    
//    Stage stage;
//    LoginModel loginModel;
//    LoginView loginView;

    public LoginController(LoginModel loginModel, LoginView loginView, Stage stage) {
//        this.loginModel = loginModel;
//        this.loginView = loginView;
//        this.stage = stage;
        

        //get the loginButton. when clicked check if the user exist in the database, and check if the password matches
        loginView.getLogin_button().setOnAction(e -> {
            if(loginModel.userValidated(loginView.getEmail_text().getText(), loginView.getPassword_text().getText())){
                //goToMainMenuView();
                System.out.println("Validated");
            } else{
                System.out.println("Not validated");
                //update gui med "email or password is incorrect". Evt 3 forsøg.
            }
                });
        
        //get th esignup button and go the signupView when pushed.
        loginView.getSignup_button().setOnAction(e -> {
            SignupModel signupModel = new SignupModel();
            SignupView signupView = new SignupView();
            stage.getScene().setRoot(signupView);
            SignupController signupController = new SignupController(signupModel, signupView, stage);
            });
        
        //for easy access, development purpose, use the guest button to access the mainMenu.
        loginView.getGuest_button().setOnAction(e -> {
            MainMenuModel mainMenuModel = new MainMenuModel();
            MainMenuView mainMenuView = new MainMenuView();
            stage.getScene().setRoot(mainMenuView);
            MainMenuController mainMenuController = new MainMenuController(mainMenuModel, mainMenuView, stage);
            
        });

    
    }
    
}
