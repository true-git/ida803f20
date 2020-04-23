package mykitchengarden.mykicthengarden.Views;
import mykitchengarden.mykicthengarden.Views.MainMenu;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlantLibrary_GUI extends Application {
    @Override
    public void start(Stage primaryStage)throws Exception {
        
         //Back button
        Image back_image = new Image("https://img.icons8.com/ios/40/000000/circled-left-2.png");
        ImageView back_View = new ImageView();
        back_View.setImage(back_image);
        back_View.setFitHeight(40);
        back_View.setFitWidth(40);
        
        Button back_button = new Button("", back_View);
        back_button.setAlignment(Pos.TOP_LEFT);
        back_button.setId("buttons");
        
        
        //Create image 
        Image book_image = new Image("https://i.imgur.com/gicCVd5.png");
        ImageView book_View = new ImageView();
        book_View.setImage(book_image);
        book_View.setFitHeight(60);
        book_View.setFitWidth(60);
        
        //create text
        Text text_title = new Text("Plante Bibliotek");
        text_title.setId("titles");
        Text text_under = new Text("Søg efter den plante som du\n" + "ønsker information om.");
        text_under.setFont(new Font("Calibri", 18));
       
        
        //create a textfield 
        TextField search_field = new TextField(); 
        search_field.setPromptText("Søg");
        search_field.setId("textfield");
       
        
        //creating Hbox for title and image 
        HBox center_box = new HBox(10);
        center_box.setAlignment(Pos.CENTER);
        center_box.getChildren().addAll(book_View, text_title);
        
        
        //creating Vbox for undertitle and searchfield
        VBox search_box = new VBox(10);
        search_box.setSpacing(10);
        search_box.setAlignment(Pos.CENTER);
        search_box.getChildren().addAll(center_box, text_under, search_field);
        search_box.setPadding(new Insets(25,0,0,0));
 

        //The BorderPane is created called layout
        VBox layout = new VBox();
        layout.getChildren().addAll(back_button, search_box);
        layout.setPadding(new Insets(30, 30, 30, 30));
 
        //Scene is created and put inside the primaryStage
        Scene plantLibrary_scene = new Scene(layout, 357, 667);
        plantLibrary_scene.getStylesheets().add("mykitchengarden/layoutstyles.css");
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(plantLibrary_scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        
        
        //--------------------- Here is button events ---------------------
        
        //Button to change to MyKitchenGarden_GUI scene 
        MainMenu instance_MyKitchenGarden_GUI = new MainMenu ();
        back_button.setOnAction(e -> {
            try {
                instance_MyKitchenGarden_GUI.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(PlantLibrary_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
       
    
}
}