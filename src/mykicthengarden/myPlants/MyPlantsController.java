/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.myPlants;

import java.sql.SQLException;
import javafx.stage.Stage;
import mykicthengarden.addPlants.AddPlantsController;
import mykicthengarden.addPlants.AddPlantsModel;
import mykicthengarden.addPlants.AddPlantsView;
import mykicthengarden.mainMenu.MainMenuController;
import mykicthengarden.mainMenu.MainMenuModel;
import mykicthengarden.mainMenu.MainMenuView;
import mykicthengarden.plantLibrary.PlantLibraryController;
import mykicthengarden.plantLibrary.PlantLibraryModel;
import mykicthengarden.plantLibrary.PlantLibraryView;

/**
 *
 * @author jacobchristensen
 */
public class MyPlantsController {

    public MyPlantsController(MyPlantsModel myPlantsModel, MyPlantsView myPlantsView, Stage stage) throws SQLException {
        
        //Get the user's plants from model/db and update view
        myPlantsView.addRegisteredPlants(myPlantsModel.getRegisteredPlants());
        
        //Back button navigation
        myPlantsView.getBack_button().setOnAction(e -> {
            
            MainMenuModel mainMenuModel = new MainMenuModel(myPlantsModel.user_id, myPlantsModel.userName);
            MainMenuView mainMenuView = new MainMenuView(myPlantsModel.userName);
            stage.getScene().setRoot(mainMenuView);
            MainMenuController mainMenuController = new MainMenuController(mainMenuModel, mainMenuView, stage);
        });
        
        
        
        myPlantsView.getAddPlantButton().setOnAction(e -> {
        
            AddPlantsModel addPlantsModel = new AddPlantsModel(myPlantsModel.user_id, myPlantsModel.userName);
            AddPlantsView addPlantsView = new AddPlantsView();
            //addPlantsModel.setUserId(myPlantsModel.user_id);
            stage.getScene().setRoot(addPlantsView);
            AddPlantsController addPlantsController = new AddPlantsController(addPlantsModel, addPlantsView, stage);
            
        });
        
    }
    
    
    
}
