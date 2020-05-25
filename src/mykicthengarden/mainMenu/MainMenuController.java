/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.mainMenu;

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
 * @author Team PlantLet
 */
public class MainMenuController {
    
    public MainMenuController(MainMenuModel mainMenuModel, MainMenuView mainMenuView, Stage stage) {
        
        //get the my_plants_button from the view, and change the scene to myPlantsView
        mainMenuView.getButton_my_plants().setOnAction(e -> {
            MyPlantsModel myPlantsModel = new MyPlantsModel(mainMenuModel.user_id, mainMenuModel.userName);
            MyPlantsView myPlantsView = new MyPlantsView(mainMenuModel.user_id);
            stage.getScene().setRoot(myPlantsView);
            MyPlantsController myPlantsController = new MyPlantsController(myPlantsModel, myPlantsView, stage);  
        });
        
        
        //get the plantLibrary_button from the view, and change the scene to plantLibrary
        mainMenuView.getButton_plant_library().setOnAction(e -> {
            System.out.print("test");
            PlantLibraryModel plantLibraryModel = new PlantLibraryModel(mainMenuModel.user_id, mainMenuModel.userName);
            PlantLibraryView plantLibraryView = new PlantLibraryView();
            stage.getScene().setRoot(plantLibraryView);
            PlantLibraryController plantLibraryController = new PlantLibraryController(plantLibraryModel, plantLibraryView, stage);      
        });
        
        
        //get the askExperts_button from the view, and change the scene to askExpertsView
        mainMenuView.getButton_ask_expert().setOnAction(e ->{
            System.out.print("test");
            AskExpertsModel askExpertsModel = new AskExpertsModel(mainMenuModel.user_id, mainMenuModel.userName);
            AskExpertsView askExpertsView = new AskExpertsView();
            stage.getScene().setRoot(askExpertsView);
            AskExpertsController askExpertsController = new AskExpertsController(askExpertsModel, askExpertsView, stage);        
        });
        
        //testing the button
        mainMenuView.getMenu_item_log_out().setOnAction(e -> {
            System.out.println("log out");
        });
        
        
        //testing the button
        mainMenuView.getMenu_item_settings().setOnAction(e -> {
            System.out.println("settings");
        });
        
        
        //testing the button
        mainMenuView.getButton_to_do_calendar().setOnAction(e ->{
            System.out.print("test");
        });
        
        
        //testing the button
        mainMenuView.getButton_weather().setOnAction(e -> {
            System.out.print("test"); 
        });
    }
    
}
