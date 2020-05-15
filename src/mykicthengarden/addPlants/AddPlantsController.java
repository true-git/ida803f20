/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.addPlants;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import mykicthengarden.Views.DatabaseConnection;
import mykicthengarden.myPlants.MyPlantsController;
import mykicthengarden.myPlants.MyPlantsModel;
import mykicthengarden.myPlants.MyPlantsView;

/**
 *
 * @author jacobchristensen
 */
public class AddPlantsController {

    private String searchTerm;
    private String plant;
    private DatabaseConnection dbc;
    private LocalDate date;
    private String state;
    public int user_id;
    private int plant_id;

    public AddPlantsController(AddPlantsModel addPlantsModel, AddPlantsView addPlantsView, Stage stage) {
     
        
        
        addPlantsView.getBack_button().setOnAction(e -> {
            MyPlantsModel myPlantsModel = new MyPlantsModel(addPlantsModel.user_id, addPlantsModel.userName);
            MyPlantsView myPlantsView = new MyPlantsView(addPlantsModel.user_id);
            stage.getScene().setRoot(myPlantsView);
            
            try {
                MyPlantsController myPlantsController = new MyPlantsController(myPlantsModel, myPlantsView, stage);
            } catch (SQLException ex) {
                Logger.getLogger(AddPlantsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        
        
        addPlantsView.getOk_button().setOnAction(e -> {
            
            try {
                //Getting the input of the textfield
                searchTerm = addPlantsView.getInput();
                
                //Check if the user has enterede a valid search term, and return the result.
                if(searchTerm.equals("")){
                    System.out.println("Please select a plant to add.");
                } else {
                    //If the searchterm is valid, check the database for the plant
                    //If the plant is in the database, get the date and state input from the user, 
                    //and registre the plant to the user.
                    if(addPlantsModel.plantExists(searchTerm)){
                        plant_id = addPlantsModel.getPlantId(searchTerm);
                        date = addPlantsView.getDate();
                        state = addPlantsView.getState();
                        user_id = addPlantsModel.user_id;
                        
                        
                        addPlantsModel.registrePlant(user_id, plant_id, date, state);
                        System.out.println("Plant registred!");
                        
                    
                } else {
                        System.out.println("We dont have that plant in our database. Please try another plant.");
                    }
   
                }
   
            } catch (Exception exception) {
            }
        });
   
    }
   
}
