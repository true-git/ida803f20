/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Louis
 */
public class MyPlants extends Application {
    
private Button back_button;
    
    public void start(Stage primaryStage) throws Exception {
        //Button to change page
        Button back_button = new Button();
        back_button.setText("Back");
        
        //The BorderPane is created called layout
        BorderPane layout = new BorderPane();
        layout.setCenter(back_button);
        
        //scene is created and put inside the primaryStage
        Scene my_plants_scene = new Scene(layout, 357, 667);
        my_plants_scene.getStylesheets().add("mykitchengarden/layoutstyles.css");
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(my_plants_scene);
        primaryStage.show();
    }
   public static void main(String[] args) {
        launch(args);        
    }
    /**
     * @param args the command line arguments
     */
}
