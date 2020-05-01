/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.stage.Stage;
import signup.*;

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
        
        loginView.getLogin_button().setOnAction(e -> {
            if(loginModel.userValidated(loginView.getEmail_text().getText(), loginView.getPassword_text().getText())){
                //goToMainMenuView();
                System.out.println("Validated");
            } else{
                System.out.println("Not validated");
                //update gui med "email or password is incorrect". Evt 3 forsøg.
            }
                });
        
        loginView.getSignup_button().setOnAction(e -> {
            SignupModel signupModel = new SignupModel();
            SignupView signupView = new SignupView();
            stage.getScene().setRoot(signupView);
            SignupController signupController = new SignupController(signupModel, signupView, stage);
            });
//        stage.getScene().setRoot(loginView);
        
    }
    
}
