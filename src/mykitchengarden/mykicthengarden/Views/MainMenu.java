/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden.mykicthengarden.Views;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Team PlantLet
 * This is purely a test text to test a pull. Please remember to delete me again
 */
public class MainMenu extends Application {
    
     private Button button_my_plants;
     private Button button_plant_library;
     private Button button_to_do_calendar;
     private Button button_weather;
     private Button button_ask_expert;
     private MenuButton combox_menu;
     private Scene menu_scene;
     private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //Menu for setting / logout
        MenuButton combox_menu = new MenuButton();
        combox_menu.setText("Menu");
        combox_menu.setId("combox_menu");
       
        //Items in menu
        MenuItem menu_item_settings = new MenuItem("Settings");
        MenuItem menu_item_log_out = new MenuItem("Log Out");
        combox_menu.getItems().addAll(menu_item_settings, menu_item_log_out);
        
        //icon in menu
        Image image_menu_icon = new Image ("https://img.icons8.com/ios-filled/20/000000/menu.png", 20, 20, true, false);
        ImageView imageview_menu_icon = new ImageView(image_menu_icon);
        combox_menu.setGraphic (imageview_menu_icon);
             
        //Plant icon 
        Image image_leaf = new Image("https://i.imgur.com/2UVnM8V.png", 144, 125, true, false);
        ImageView imageview_leaf = new ImageView(image_leaf);
        
                
        //Label for header
        Label label_header = new Label();
        label_header.setText("Hej Bruger!");
        label_header.setId("titles");
        label_header.setPadding(new Insets(0,0,20,0));
        
        //Icons next to buttons
        //1. placeholder
        Image image_icon1 = new Image("https://i.imgur.com/46hFA3A.png", 50, 50, true, false);
        ImageView imageview_icon1 = new ImageView(image_icon1);
        //2. placeholder
        Image image_icon2 = new Image("https://i.imgur.com/4EQcjuV.png", 50, 50, true, false);
        ImageView imageview_icon2 = new ImageView(image_icon2);
        //3. placeholder
        Image image_icon3 = new Image("https://i.imgur.com/VQd78Cm.png", 50, 50, true, false);
        ImageView imageview_icon3 = new ImageView(image_icon3);
        //4. placeholder
        Image image_icon4 = new Image("https://i.imgur.com/eR64T01.png", 50, 50, true, false);
        ImageView imageview_icon4 = new ImageView(image_icon4);
        //5. placeholder
        Image image_icon5  = new Image("https://i.imgur.com/uMHVS2f.png", 50, 50, true, false);
        ImageView imageview_icon5 = new ImageView(image_icon5);        

        //Button to change page to my plants
        Button button_my_plants = new Button();
        button_my_plants.setText("Mine planter");
        button_my_plants.setId("menu_button");

        //Button to change page to plant library
        Button button_plant_library= new Button();
        button_plant_library.setText("Plante Bibliotek");
        button_plant_library.setId("menu_button");
        
        //Button to change page to to-do calendar
        Button button_to_do_calendar = new Button();
        button_to_do_calendar.setText("To-Do Kalender");
        button_to_do_calendar.setId("menu_button");
        // button_to_do_calendar.setDisable(true);
        
        //Button to change page to weather
        Button button_weather = new Button();
        button_weather.setText("Vejret");
        button_weather.setId("menu_button");
        
        //Button to change page to ask expert
        Button button_ask_expert = new Button();
        button_ask_expert.setText("Spørg Eksperterne");        
        button_ask_expert.setId("menu_button");
        
        GridPane grid_buttons = new GridPane();
        grid_buttons .add(imageview_icon1, 0, 0);
        grid_buttons .add(button_my_plants, 1, 0);
        grid_buttons .add(imageview_icon2, 0, 1);
        grid_buttons .add(button_plant_library, 1, 1);
        grid_buttons .add(imageview_icon3, 0, 2);
        grid_buttons .add(button_to_do_calendar, 1, 2);
        grid_buttons .add(imageview_icon4, 0, 3);
        grid_buttons .add(button_weather, 1, 3);
        grid_buttons .add(imageview_icon5, 0, 4);
        grid_buttons .add(button_ask_expert, 1, 4);

        grid_buttons .setHgap(5);
        grid_buttons .setVgap(5);
        grid_buttons.setAlignment(Pos.CENTER);
        grid_buttons.setPadding(new Insets(0,60,100,0));
        
        //Stackpane for menubox
        StackPane stackpane_menu = new StackPane(combox_menu);
        stackpane_menu.setAlignment(Pos.TOP_RIGHT);
        
        //Vbox for vobx_icon and label_header
        VBox vbox_icon_and_label = new VBox(30);
        vbox_icon_and_label.getChildren().addAll(imageview_leaf, label_header);
        vbox_icon_and_label.setAlignment(Pos.CENTER);
 
        //Vbox for label and vbox_icon
        VBox vbox_center_content = new VBox();
        vbox_center_content.getChildren().addAll(vbox_icon_and_label, grid_buttons);
        vbox_center_content.setAlignment(Pos.CENTER);        
        
        //The BorderPane is created called layout
        BorderPane layout = new BorderPane();
        layout.setTop(stackpane_menu);
        layout.setCenter(vbox_center_content);
        
        //scene is created and put inside the primaryStage
        Scene menu_scene = new Scene(layout, 357, 667);
        menu_scene.getStylesheets().add("mykitchengarden/layoutstyles.css");        
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(menu_scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        
        //--------------------- Here is button events ---------------------
        
        
        //Button to change to PlantLibrary_GUI scene 
        PlantLibrary_GUI instance_PlantLibrary_GUI = new PlantLibrary_GUI ();
        button_plant_library.setOnAction(e -> {
            try {
                instance_PlantLibrary_GUI.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(MyPlants_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //Button to change to AskExperts_GUI scene 
        AskExperts_GUI instance_AskExperts_GUI = new AskExperts_GUI ();
        button_ask_expert.setOnAction(e -> {
            try {
                instance_AskExperts_GUI .start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(MyPlants_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        //Database related
        DatabaseConnection dbc = new DatabaseConnection();
        dbc.executeQuery("Select * from plants");
        while(dbc.myRs.next()) {
            System.out.println(dbc.myRs.getString("common_name") + ", " + dbc.myRs.getString("latin_name") +
                    ", " + dbc.myRs.getString("climate_zone"));
        }
        
    }
    public void changetomenu(){
        primaryStage.setScene(menu_scene);
    }
}
