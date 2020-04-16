/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden;

import java.io.FileInputStream;
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
public class Signup extends Application {
    
    @Override
    public void start (Stage primaryStage) throws Exception {
        
        //Creating logo
        FileInputStream inputstream1 = new FileInputStream("C:\\Users\\bruger\\Desktop\\plant.png");
        Image logo_image = new Image(inputstream1);
        ImageView logo_view = new ImageView(logo_image);
        
        //Setting the fit height and width of the logo 
        logo_view.setFitHeight(150); 
        logo_view.setFitWidth(150);
        
        //Creating user logo
        FileInputStream inputstream2 = new FileInputStream("C:\\Users\\bruger\\Desktop\\user.png");
        Image user_image = new Image(inputstream2);
        ImageView user_view = new ImageView(user_image);
        
        //Setting the fit height and width of the user logo 
        user_view.setFitHeight(50); 
        user_view.setFitWidth(50);
        
        //Back icon for the back button
        FileInputStream back_stream = new FileInputStream("C:\\Users\\bruger\\Desktop\\back.png");
        Image back_image = new Image(back_stream);
        ImageView back_icon = new ImageView(back_image);
        
        //Setting the fit height and width of the login image
        back_icon.setFitHeight(30); 
        back_icon.setFitWidth(30);
        
        //Button to go back
        Button back_button = new Button("",back_icon);
        back_button.setAlignment(Pos.TOP_LEFT);
        back_button.setStyle("-fx-background-color: transparent;");
        
        //Enter icon for the signup button
        FileInputStream enter_stream = new FileInputStream("C:\\Users\\bruger\\Desktop\\enter.png");
        Image enter_image = new Image(enter_stream);
        ImageView enter_icon = new ImageView(enter_image);
        
        //Setting the fit height and width of the login image
        enter_icon.setFitHeight(30); 
        enter_icon.setFitWidth(30);
        
        //Button to sign up
        Button signup_button = new Button("Tilmeld",enter_icon);
        signup_button.setAlignment(Pos.CENTER);
        signup_button.setStyle("-fx-background-color: transparent;");
        
        //Text field for first name
        TextField first_name_text= new TextField();
        first_name_text.setPromptText("Fornavn");
        first_name_text.setPrefWidth(250);
        first_name_text.setMaxWidth(250);
        
        //Text field for last name
        TextField last_name_text= new TextField();
        last_name_text.setPromptText("Efternavn");
        last_name_text.setPrefWidth(250);
        last_name_text.setMaxWidth(250);
        
        //Text field for e-mail
        TextField email_text= new TextField();
        email_text.setPromptText("E-mail");
        email_text.setPrefWidth(250);
        email_text.setMaxWidth(250);
        
        //Password field for password
        PasswordField password_text = new PasswordField();
        password_text.setPromptText("Kodeord");
        password_text.setPrefWidth(250);
        password_text.setMaxWidth(250);
        
        //Label for birthday
        Label birthday_label = new Label("Fødselsdag");
        
        //Label for city
        Label city_label = new Label("By");
        
//        //ComboBox for birthday
//        ComboBox date_combo = new ComboBox();
//        ComboBox month_combo = new ComboBox();
//        ComboBox year_combo = new ComboBox();
        //Birthday calendar
        DatePicker birthday_picker = new DatePicker();
        
        //Putting birthday label and comboBoxes in a HBox
        HBox birthday_box = new HBox();
        birthday_box.setSpacing(20);
        birthday_box.setAlignment(Pos.CENTER_LEFT);
        birthday_box.getChildren().addAll(birthday_label,birthday_picker);
        
        //ComboBox for city
        ComboBox city_combo = new ComboBox();
        
        //Putting city label and comboBox in a HBox
        HBox city_box = new HBox();
        city_box.setSpacing(20);
        city_box.setAlignment(Pos.CENTER);
        city_box.getChildren().addAll(city_label,city_combo);
        
        
        //Radio button for female
        RadioButton female_button = new RadioButton("Kvinde");
        
        //Radio button for male
        RadioButton male_button = new RadioButton("Mand");
        
        //Radio button for other
        RadioButton other_button = new RadioButton("Andet");
        
        //Toggle group for the radio buttons
        ToggleGroup radioGroup = new ToggleGroup();
        female_button.setToggleGroup(radioGroup);
        male_button.setToggleGroup(radioGroup);
        other_button.setToggleGroup(radioGroup);
        
        
        //Putting text fields first name and last name in a HBox
        HBox name_box = new HBox();
        name_box.setSpacing(10);
        name_box.setAlignment(Pos.CENTER);
        name_box.getChildren().addAll(first_name_text,last_name_text);
        
        //Putting text fields email and password in a HBox
        HBox user_box = new HBox();
        user_box.setSpacing(10);
        user_box.setAlignment(Pos.CENTER);
        user_box.getChildren().addAll(email_text,password_text);
        
        //Putting radio buttons in a HBox
        HBox radiobutton_box = new HBox();
        radiobutton_box.setSpacing(30);
        radiobutton_box.setAlignment(Pos.CENTER);
        radiobutton_box.getChildren().addAll(female_button,male_button,other_button);
        
        //Putting user info in VBox
        VBox info_box = new VBox();
        info_box.setSpacing(20);
        info_box.setAlignment(Pos.CENTER);
        info_box.getChildren().addAll(logo_view,user_view,user_box,name_box,birthday_box,city_box,radiobutton_box);
        
        
        //The BorderPane is created called layout
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(30, 30, 30, 30));
        layout.setTop(back_button);
        layout.setCenter(info_box);
        layout.setBottom(signup_button);

        //Scene is created and put inside the primaryStage
        Scene signup_scene = new Scene(layout, 357, 667);
        signup_scene.getStylesheets().add("mykitchengarden/layoutstyles.css");
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(signup_scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
