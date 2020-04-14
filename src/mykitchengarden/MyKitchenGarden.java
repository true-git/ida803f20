/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author Kasper
 * This is purely a test text to test a pull. Please remember to delete me again
 */
public class MyKitchenGarden extends Application {
    
     private Button button_my_plants;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Button to change page
        Button button_my_plants = new Button();
        button_my_plants.setText("Mine planter");
        
        
        DatabaseConnection dbc = new DatabaseConnection();
        dbc.executeQuery("Select * from plants");
        while(dbc.myRs.next()) {
            System.out.println(dbc.myRs.getString("common_name") + ", " + dbc.myRs.getString("latin_name") +
                    ", " + dbc.myRs.getString("climate_zone"));
        }
        //The BorderPane is created called layout
        BorderPane layout = new BorderPane();
        layout.setCenter(button_my_plants);
        
        //scene is created and put inside the primaryStage
        Scene menuScene = new Scene(layout, 357, 667);
        //scene.getStylesheets().add("/mykitchengarden/layoutstyles.css");
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(menuScene);
        primaryStage.show();
                 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);        
    }
}
