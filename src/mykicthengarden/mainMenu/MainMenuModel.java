/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.mainMenu;

/**
 *
 * @author Team PlantLet
 */
public class MainMenuModel {
    
    public int user_id;
    public String userName;
    
    public MainMenuModel(int user_id, String userName){
        this.user_id = user_id;
        this.userName = userName;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getFirstName() {
        
        return userName;
    }
    
    
    
}
