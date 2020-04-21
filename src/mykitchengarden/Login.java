/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author bruger
 */
public class Login extends Application {

    @Override
    public void start (Stage primaryStage) throws Exception {
        
        //Creating logo
        Image logo_image = new Image("https://i.imgur.com/cvhMPnE.png");
        ImageView logo_view = new ImageView();
        logo_view.setImage(logo_image);
        
        //Setting the fit height and width of the logo
        logo_view.setFitHeight(178); 
        logo_view.setFitWidth(205);
        
        //Enter icon for the login button
        Image enter_image = new Image("https://i.imgur.com/NgAYbPw.png");
        ImageView enter_view = new ImageView();
        enter_view.setImage(enter_image);
        
        //Setting the fit height and width of the login image
        enter_view.setFitHeight(20); 
        enter_view.setFitWidth(20);
        
        //Button to log in
        Button login_button = new Button("Log på",enter_view);
        login_button.setId("button_logo");
        
        //Button to sign up
        Button signup_button = new Button("Tilmeld dig"); 
        
        //Button to access the app as a guest
        Button guest_button = new Button("Gæst");
        
        //Text field for email
        TextField email_text= new TextField();
        email_text.setPromptText("E-mail");
        email_text.setPrefWidth(250);
        email_text.setMaxWidth(250);
        
        //Password field for password
        PasswordField password_text = new PasswordField();
        password_text.setPromptText("Kodeord");
        password_text.setPrefWidth(250);
        password_text.setMaxWidth(250);
        
        //Putting text fields in a vbox
        VBox login_text_box = new VBox();
        login_text_box.setSpacing(10);
        login_text_box.setAlignment(Pos.CENTER);
        login_text_box.getChildren().addAll(email_text,password_text);
        
        //Putting the text vbox and login button in vbox
        VBox login_box = new VBox();
        login_box.setSpacing(30);
        login_box.setAlignment(Pos.CENTER);
        login_box.getChildren().addAll(logo_view,login_text_box,login_button);
        
        //Putting signup button and guest button in a vbox
        VBox buttons_box = new VBox();
        buttons_box.setSpacing(20);
        buttons_box.setAlignment(Pos.CENTER);
        buttons_box.getChildren().addAll(signup_button,guest_button);
        
        //The BorderPane is created called layout
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(30, 30, 100, 30));
        layout.setCenter(login_box);
        layout.setBottom(buttons_box);
        
        //scene is created and put inside the primaryStage
        Scene login_scene = new Scene(layout, 357, 667);
        login_scene.getStylesheets().add("mykitchengarden/layoutstyles.css");
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(login_scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
