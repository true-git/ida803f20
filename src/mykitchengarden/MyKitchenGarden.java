/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden;

import javafx.application.Application;
import javafx.stage.Stage;



/**
 *
 * @author jacobchristensen
 */
public class MyKitchenGarden {
    
    
    
    public static void main(String[] args) {
        
        MyKitchenGardenView myKitchenGardenView = new MyKitchenGardenView();
        
        MyKitchenGardenModel myKitchenGardenModel = new MyKitchenGardenModel();
        
        MyKitchenGardenController myKitchenGardenController = new MyKitchenGardenController(myKitchenGardenModel, myKitchenGardenView);
        
        
        
        
    }
    
}
