/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.myPlants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import mykicthengarden.Views.DatabaseConnection;

/**
 *
 * @author Team PlantLet
 */
public class MyPlantsModel {
    
    DatabaseConnection dbc;
    public int user_id;
    public String userName;
    public ArrayList<String> myPlantsArray;
    
    
    public MyPlantsModel(int user_id, String userName) {
        this.user_id = user_id;
        this.userName = userName;
        dbc = new DatabaseConnection();
    }
    
    public ArrayList<Plant> getRegisteredPlants() throws SQLException{
        ArrayList<Plant> registeredPlants = new ArrayList<>();
        Image plant_image1 = new Image ("https://image.shutterstock.com/image-vector/default-ui-image-placeholder-wireframes-260nw-1037719192.jpg", 120, 120, false, true);
        
//        String query = "Select common_name from plants where common_name = '" + searchTerm + "'";
        String query = "select * from plants where plant_id in (select plant_id from registered_plants where user_id = '" + user_id + "')";
        
        dbc.getConnection();
        try {
            ResultSet myRs = dbc.getMyStmt().executeQuery(query);
            
            while(myRs.next()){
                registeredPlants.add(new Plant(myRs.getString("common_name").toString(), plant_image1));
                System.out.println(myRs.getString("common_name").toString());
            } 
            dbc.getMyConn().close();
        } finally {
            dbc.getMyConn().close();
        }
        return registeredPlants;
    }
}
