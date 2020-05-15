/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.mainMenu;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;
import mykicthengarden.askExperts.AskExpertsController;
import mykicthengarden.askExperts.AskExpertsModel;
import mykicthengarden.askExperts.AskExpertsView;
import mykicthengarden.myPlants.MyPlantsController;
import mykicthengarden.myPlants.MyPlantsModel;
import mykicthengarden.myPlants.MyPlantsView;
import mykicthengarden.plantLibrary.PlantLibraryController;
import mykicthengarden.plantLibrary.PlantLibraryModel;
import mykicthengarden.plantLibrary.PlantLibraryView;

/**
 *
 * @author jacobchristensen
 */
public class MainMenuController {
    
    public MainMenuController(MainMenuModel mainMenuModel, MainMenuView mainMenuView, Stage stage) {
        
        
        mainMenuView.getButton_my_plants().setOnAction(e -> {
            MyPlantsModel myPlantsModel = new MyPlantsModel(mainMenuModel.user_id, mainMenuModel.userName);
            MyPlantsView myPlantsView = new MyPlantsView(mainMenuModel.user_id);
            stage.getScene().setRoot(myPlantsView);
            try {  
                MyPlantsController myPlantsController = new MyPlantsController(myPlantsModel, myPlantsView, stage);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        mainMenuView.getButton_plant_library().setOnAction(e -> {
            System.out.print("test");
            PlantLibraryModel plantLibraryModel = new PlantLibraryModel(mainMenuModel.user_id, mainMenuModel.userName);
            PlantLibraryView plantLibraryView = new PlantLibraryView();
            stage.getScene().setRoot(plantLibraryView);
            PlantLibraryController plantLibraryController = new PlantLibraryController(plantLibraryModel, plantLibraryView, stage);      
        });
        

        mainMenuView.getButton_ask_expert().setOnAction(e ->{
            System.out.print("test");
            AskExpertsModel askExpertsModel = new AskExpertsModel(mainMenuModel.user_id, mainMenuModel.userName);
            AskExpertsView askExpertsView = new AskExpertsView();
            stage.getScene().setRoot(askExpertsView);
            AskExpertsController askExpertsController = new AskExpertsController(askExpertsModel, askExpertsView, stage);        
        });
        
        mainMenuView.getMenu_item_log_out().setOnAction(e -> {
            System.out.println("log out");
        });
        
        mainMenuView.getMenu_item_settings().setOnAction(e -> {
            System.out.println("settings");
        });
        
        mainMenuView.getButton_to_do_calendar().setOnAction(e ->{
            System.out.print("test");
        });
        
        mainMenuView.getButton_weather().setOnAction(e -> {
            System.out.print("test"); 
        });
    }
    
}
