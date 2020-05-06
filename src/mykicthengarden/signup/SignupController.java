/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.signup;

import javafx.stage.Stage;
import mykicthengarden.login.LoginController;
import mykicthengarden.login.LoginModel;
import mykicthengarden.login.LoginView;

/**
 *
 * @author Kasper
 */
public class SignupController {
    
//    private Stage stage;
//    private SignupModel signupModel;
//    private SignupView signupView;

    public SignupController(SignupModel signupModel, SignupView signupView, Stage stage) {
//        this.stage = stage;
//        this.signupModel = signupModel;
//        this.signupView = signupView;
        signupView.getBack_button().setOnAction(e -> {
            LoginModel loginModel = new LoginModel();
            LoginView loginView = new LoginView();
            stage.getScene().setRoot(loginView);
            LoginController loginController = new LoginController(loginModel, loginView, stage);
            });
        signupView.getSignup_button().setOnAction(e -> {
            
//            LoginModel loginModel = new LoginModel();
//            LoginView loginView = new LoginView();
//            stage.getScene().setRoot(loginView);
//            LoginController loginController = new LoginController(loginModel, loginView, stage);
            });
    }
    
}
