package mykicthengarden.login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Team PlantLet
 */
public class LoginView extends BorderPane {
    
    private Button guest_button;
    private Button signup_button;
    private Button login_button;
    private TextField email_text;
    PasswordField password_text;

    public PasswordField getPassword_text() {
        return password_text;
    }

    public TextField getEmail_text() {
        return email_text;
    }

    public Button getGuest_button() {
        return guest_button;
    }

    public Button getSignup_button() {
        return signup_button;
    }

    public Button getLogin_button() {
        return login_button;
    }

    public LoginView () {
        
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
        login_button = new Button("Log på",enter_view);
        login_button.setId("buttons");
        
        //Button to sign up
        signup_button = new Button("Tilmeld"); 
        signup_button.setId("menu_button_small");
        
        //Button to access the app as a guest
        guest_button = new Button("Gæst");
        guest_button.setId("menu_button_small");
        
        
        //Text field for email
        email_text= new TextField();
        email_text.setPromptText("E-mail");
        email_text.setId("textfield");
        email_text.setFocusTraversable(false);
        
        //Password field for password
        password_text = new PasswordField();
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
        setPadding(new Insets(30, 30, 100, 30));
        setCenter(login_box);
        setBottom(buttons_box);
        
    } 

}
