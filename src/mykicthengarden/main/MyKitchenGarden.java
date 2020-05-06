/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.main;

import mykicthengarden.login.LoginController;
import mykicthengarden.login.LoginView;
import mykicthengarden.login.LoginModel;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mykicthengarden.Views.DatabaseConnection;


/**
 *
 * @author Team PlantLet
 */
public class MyKitchenGarden extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        LoginModel loginModel = new LoginModel();
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginModel, loginView, primaryStage);
        
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(new Scene(loginView, 357, 667));
        primaryStage.getScene().getStylesheets().add("mykitchengarden/layoutstyles.css");
        primaryStage.show();
        primaryStage.setResizable(false);

    }
    
    public static void main(String[] args) {
        launch(args);
        // TODO code application logic here
    }
    
}
