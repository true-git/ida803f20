/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.myPlants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mykicthengarden.Views.DatabaseConnection;

/**
 *
 * @author jacobchristensen
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
        //myPlantsArray = getMyPlants(user_id);
        
        
        
        //System.out.println(myPlantsArray);
        
        
    }
    
//    private ArrayList getMyPlants(int user_id) {
//        ArrayList<String> myPlants = new ArrayList<>();
//        String query = "Select plant_id from registred_plants where user_id = '" + user_id + "'";
//        //dbc.getConnection();
//        try{
//            ResultSet myRs = dbc.getMyStmt().executeQuery(query);
//            while (myRs.next()) {
//                myPlants.add(myRs.getString("plant_id"));
//                
//                
//        } 
//        
//        }catch (SQLException e) {}
//        return null;
//    }
    
    
    
    

    
    
}
