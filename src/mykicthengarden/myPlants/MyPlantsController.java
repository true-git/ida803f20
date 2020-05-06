/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.myPlants;

import javafx.stage.Stage;
import mykicthengarden.mainMenu.MainMenuController;
import mykicthengarden.mainMenu.MainMenuModel;
import mykicthengarden.mainMenu.MainMenuView;

/**
 *
 * @author jacobchristensen
 */
public class MyPlantsController {

    public MyPlantsController(MyPlantsModel myPlantsModel, MyPlantsView myPlantsView, Stage stage) {
        
        
        myPlantsView.getBack_button().setOnAction(e -> {
            
            MainMenuModel mainMenuModel = new MainMenuModel();
            MainMenuView mainMenuView = new MainMenuView();
            stage.getScene().setRoot(mainMenuView);
            MainMenuController mainMenuController = new MainMenuController(mainMenuModel, mainMenuView, stage);
            
            
        });
        
    }
    
    
    
}
