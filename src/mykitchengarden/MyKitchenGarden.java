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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Kasper
 * This is purely a test text to test a pull. Please remember to delete me again
 */
public class MyKitchenGarden extends Application {
    
     private Button button_my_plants;
     private Button button_plant_library;
     private Button button_to_do_calendar;
     private Button button_weather;
     private Button button_ask_expert;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Button to change page to my plants
        Button button_my_plants = new Button();
        button_my_plants.setText("Mine planter");
        button_my_plants.setId("menu_button");

        //Button to change page to my plants
        Button button_plant_library= new Button();
        button_plant_library.setText("Plante Bibliotek");

        //Button to change page to my plants
        Button button_to_do_calendar = new Button();
        button_to_do_calendar.setText("To-Do Kalender");
        
        //Button to change page to my plants
        Button button_weather = new Button();
        button_weather.setText("Vejret");
        
        //Button to change page to my plants
        Button button_ask_expert = new Button();
        button_ask_expert.setText("Spørg Eksperterne");        
        
        
        
        
        DatabaseConnection dbc = new DatabaseConnection();
        dbc.executeQuery("Select * from plants");
        while(dbc.myRs.next()) {
            System.out.println(dbc.myRs.getString("common_name") + ", " + dbc.myRs.getString("latin_name") +
                    ", " + dbc.myRs.getString("climate_zone"));
        }
        
        //Vbox for button
        VBox vbox_buttons_menu = new VBox(20);
        vbox_buttons_menu.getChildren().addAll(button_my_plants, button_plant_library, button_to_do_calendar,button_weather,button_ask_expert);
        vbox_buttons_menu.setAlignment(Pos.CENTER);
        
        //The BorderPane is created called layout
        BorderPane layout = new BorderPane();
        layout.setCenter(vbox_buttons_menu);
        
        //scene is created and put inside the primaryStage
        Scene menu_scene = new Scene(layout, 357, 667);
        menu_scene.getStylesheets().add("mykitchengarden/layoutstyles.css");        
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(menu_scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);        
    }
}
