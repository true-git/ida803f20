/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.askExperts;

import javafx.stage.Stage;
import mykicthengarden.mainMenu.MainMenuController;
import mykicthengarden.mainMenu.MainMenuModel;
import mykicthengarden.mainMenu.MainMenuView;

/**
 *
 * @author Team PlantLet
 */
public class AskExpertsController {

    public AskExpertsController(AskExpertsModel askExpertsModel, AskExpertsView askExpertsView, Stage stage) {
    
        //Back button 
        askExpertsView.getBack_button().setOnAction(e -> {
            
            MainMenuModel mainMenuModel = new MainMenuModel(askExpertsModel.user_id, askExpertsModel.userName);
            MainMenuView mainMenuView = new MainMenuView(askExpertsModel.userName);
            stage.getScene().setRoot(mainMenuView);
            MainMenuController mainMenuController = new MainMenuController(mainMenuModel, mainMenuView, stage);
            
        });
}   
}
