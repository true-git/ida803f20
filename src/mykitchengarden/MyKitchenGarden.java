/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 *
 * @author Team PlantLet
 */
public class MyKitchenGarden extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        MyKitchenGardenModel myKitchenGardenModel = new MyKitchenGardenModel();
        MyKitchenGardenView myKitchenGardenView = new MyKitchenGardenView(primaryStage);
        new MyKitchenGardenController(myKitchenGardenModel, myKitchenGardenView);
    }
    
    public static void main(String[] args) {
        launch(args);
        // TODO code application logic here
    }
    
}
