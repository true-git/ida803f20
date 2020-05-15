/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.plantLibrary;

import javafx.stage.Stage;
import mykicthengarden.mainMenu.MainMenuController;
import mykicthengarden.mainMenu.MainMenuModel;
import mykicthengarden.mainMenu.MainMenuView;

/**
 *
 * @author Team PlantLet
 */
public class PlantLibraryController {

    public PlantLibraryController(PlantLibraryModel plantLibraryModel, PlantLibraryView plantLibraryView, Stage stage) {
        
        plantLibraryView.getBack_button().setOnAction(e -> {
            
            MainMenuModel mainMenuModel = new MainMenuModel(plantLibraryModel.user_id, plantLibraryModel.userName);
            MainMenuView mainMenuView = new MainMenuView(plantLibraryModel.userName);
            stage.getScene().setRoot(mainMenuView);
            MainMenuController mainMenuController = new MainMenuController(mainMenuModel, mainMenuView, stage);
            
        });
        
        
    }
    
    
    
}
