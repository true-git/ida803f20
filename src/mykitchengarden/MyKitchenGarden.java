/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author Kasper
 * This is purely a test text to test a pull. Please remember to delete me again
 */
public class MyKitchenGarden extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        DatabaseConnection dbc = new DatabaseConnection();
        dbc.executeQuery("Select * from plants");
        while(dbc.myRs.next()) {
            System.out.println(dbc.myRs.getString("common_name") + ", " + dbc.myRs.getString("latin_name") +
                    ", " + dbc.myRs.getString("climate_zone"));
        }
        Scene scene = new Scene(new StackPane(), 900, 600);
        //scene.getStylesheets().add("/mykitchengarden/layoutstyles.css");
                
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);        
    }
}
