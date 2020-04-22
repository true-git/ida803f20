/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden;

import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Team PlantLet
 */
public class Login_GUI extends Application {
    
    private Button guest_button;
    private Button signup_button;
    private Button login_button;

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
        Image enter_image = new Image("https://img.icons8.com/ios/60/ok.png");
        ImageView enter_view = new ImageView();
        enter_view.setImage(enter_image);
        
        //Setting the fit height and width of the login image
        enter_view.setFitHeight(40); 
        enter_view.setFitWidth(40);
        
        //Button to log in
        Button login_button = new Button("Log på",enter_view);
        login_button.setId("buttons");
        
        //Button to sign up
        Button signup_button = new Button("Tilmeld"); 
        signup_button.setId("menu_button_small");
        
        //Button to access the app as a guest
        Button guest_button = new Button("Gæst");
        guest_button.setId("menu_button_small");
        
        
        //Text field for email
        TextField email_text= new TextField();
        email_text.setPromptText("E-mail");
        email_text.setId("textfield");
        email_text.setFocusTraversable(false);
        
        //Password field for password
        PasswordField password_text = new PasswordField();
        password_text.setPromptText("Kodeord");
        password_text.setId("textfield");
        password_text.setFocusTraversable(false);
        
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
        primaryStage.setResizable(false);
        
        //--------------------- Here is button events ---------------------
        
        //Button to change to MyKitchenGarden_GUI scene 
        MyKitchenGarden_GUI instance_MyKitchenGarden_GUI = new MyKitchenGarden_GUI ();
        guest_button.setOnAction(e -> {
            try {
                instance_MyKitchenGarden_GUI.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Login_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
       
        //Button to change to Signup_GUI scene 
        Signup_GUI instance_Signup_GUI = new Signup_GUI ();
        signup_button.setOnAction(e -> {
            try {
                instance_Signup_GUI.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Login_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);        
    }
    

}
