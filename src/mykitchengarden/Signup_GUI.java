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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author bruger
 */
public class Signup_GUI extends Application {
    
    private Button back_button;
    private Button signup_button;
    
    @Override
    public void start (Stage primaryStage) throws Exception {        
        //Creating user logo
        Image user_image = new Image("https://i.imgur.com/6XzpWst.png");
        ImageView user_view = new ImageView();
        user_view.setImage(user_image);
        
        //Setting the fit height and width of the user logo 
        user_view.setFitHeight(60); 
        user_view.setFitWidth(60);
        
        //Label as the scene's title
        Label label_title = new Label("Opret bruger");
        label_title.setId("titles");
        
        //Back icon for the back button
        Image back_image = new Image("https://img.icons8.com/ios/40/000000/circled-left-2.png");
        ImageView back_view = new ImageView();
        back_view.setImage(back_image);
        
        //Setting the fit height and width of the login image
        back_view.setFitHeight(40); 
        back_view.setFitWidth(40);
        
        //Button to go back
        Button back_button = new Button("",back_view);
        back_button.setAlignment(Pos.TOP_LEFT);
        back_button.setId("buttons");
        
        //Enter icon for the signup button
        Image enter_image = new Image("https://img.icons8.com/ios/40/ok.png");
        ImageView enter_view = new ImageView();
        enter_view.setImage(enter_image);
        
        //Setting the fit height and width of the login image
        enter_view.setFitHeight(40); 
        enter_view.setFitWidth(40);
        
        //Button to sign up
        Button signup_button = new Button("Tilmeld");
        signup_button.setId("menu_button_small");
        
        //Text field for first name
        TextField first_name_text= new TextField();
        first_name_text.setPromptText("Fornavn");
        first_name_text.setId("textfield_small");
        
        //Text field for last name
        TextField last_name_text= new TextField();
        last_name_text.setPromptText("Efternavn");
        last_name_text.setId("textfield_small");
        
        //Text field for e-mail
        TextField email_text= new TextField();
        email_text.setPromptText("E-mail");
        email_text.setId("textfield_small");
        
        //Password field for password
        PasswordField password_text = new PasswordField();
        password_text.setPromptText("Kodeord");
        password_text.setId("textfield_small");
        
        
        //DatePicker for birthday
        DatePicker birthday_picker = new DatePicker();
        birthday_picker.setPromptText("Vælg fødselsdag");
        birthday_picker.setId("textfield_small");
         birthday_picker.setStyle("-fx-pref-width: 300;");
        
        //ComboBox for city
        TextField city_textfield = new TextField();
        city_textfield.setId("textfield_small");
        city_textfield.setPromptText("By");
        
        
        //Radio button for female
        RadioButton female_button = new RadioButton("Kvinde");
        female_button.setId("radio_buttons");
        
        //Radio button for male
        RadioButton male_button = new RadioButton("Mand");
        male_button.setId("radio_buttons");
        
        //Radio button for other
        RadioButton other_button = new RadioButton("Andet");
        other_button.setId("radio_buttons");
        
        //Toggle group for the radio buttons
        ToggleGroup radioGroup = new ToggleGroup();
        female_button.setToggleGroup(radioGroup);
        male_button.setToggleGroup(radioGroup);
        other_button.setToggleGroup(radioGroup);
        
        
        //Putting text fields first name and last name in a HBox
        
        HBox icon_label_box = new HBox(20);
        icon_label_box.getChildren().addAll(user_view, label_title);
        icon_label_box.setAlignment(Pos.CENTER);
        
        HBox name_box = new HBox();
        name_box.setSpacing(10);
        name_box.setAlignment(Pos.CENTER);
        name_box.getChildren().addAll(first_name_text,last_name_text);
        
        //Putting text fields email and password in a HBox
        VBox user_box = new VBox();
        user_box.setSpacing(10);
        user_box.setAlignment(Pos.CENTER);
        user_box.getChildren().addAll(email_text,password_text);
        
        //Putting radio buttons in a HBox
        HBox radiobutton_box = new HBox();
        radiobutton_box.setSpacing(10);
        radiobutton_box.setPadding(new Insets(20,0,20,0));
        radiobutton_box.setAlignment(Pos.CENTER);
        radiobutton_box.getChildren().addAll(female_button,male_button,other_button);
        
        //Putting user info in VBox
        VBox info_box = new VBox();
        info_box.setSpacing(10);
        info_box.setAlignment(Pos.TOP_CENTER);
        info_box.setPadding( new Insets(30,0,0,0));
        info_box.getChildren().addAll(icon_label_box,user_box,name_box,birthday_picker,city_textfield,radiobutton_box,signup_button);
        
        
        //The BorderPane is created called layout
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(30, 30, 30, 30));
        layout.setTop(back_button);
        layout.setCenter(info_box);
        
        //Scene is created and put inside the primaryStage
        Scene signup_scene = new Scene(layout, 357, 667);
        signup_scene.getStylesheets().add("mykitchengarden/layoutstyles.css");
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(signup_scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        
         //--------------------- Here is button events ---------------------
        
        //Button to change to Login_GUI scene 
        Login_GUI instance_Login_GUI = new Login_GUI ();
        back_button.setOnAction(e -> {
            try {
                instance_Login_GUI.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(Signup_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
}
