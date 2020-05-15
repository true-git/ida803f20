/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.addPlants;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import mykicthengarden.Views.DatabaseConnection;

/**
 *
 * @author Team PlantLet
 */
public class AddPlantsModel {
    
    private DatabaseConnection dbc;
    public int user_id;
    public String userName;
    
    public AddPlantsModel(int user_id, String userName) {
        dbc = new DatabaseConnection();
        this.user_id = user_id;
        this.userName = userName;
    }

    
    //Chech if the plant exists in the database
    public boolean plantExists(String searchTerm) throws SQLException {
        String query = "Select common_name from plants where common_name = '" + searchTerm + "'";
        
        dbc.getConnection();
        try {
            ResultSet myRs = dbc.getMyStmt().executeQuery(query);
            
            while(myRs.next()){
                if(myRs.getString("common_name").equals(searchTerm)){
                    dbc.getMyConn().close();
                    return true;
                }
            }
        } finally {
            dbc.getMyConn().close();
        }
      
        return false;
    }

    public Integer getPlantId(String searchTerm) throws SQLException {
        String query = "Select plant_id from plants where common_name = '" + searchTerm + "';";
        
        dbc.getConnection();
        try {
            ResultSet myRs = dbc.getMyStmt().executeQuery(query);
            
            while(myRs.next()) {
                Integer plant_id = myRs.getInt("plant_id");
                dbc.getMyConn().close();
                return plant_id;
            }
 
        } finally {
            dbc.getMyConn().close(); 
        }
        return null;
    } 
    
    public void registrePlant(Integer user_id, Integer plant_id, LocalDate date, String state) throws SQLException {
        
        String query = "Insert into registered_plants values ('" + user_id + "', '" + plant_id + "', '"+ state + "', '" + date + "');"; 
        
        dbc.getConnection();
        
        try {
        dbc.getMyStmt().executeUpdate(query);
        dbc.getMyConn().close();
        } finally {
            
        }
        
            
    }

    
    
}
