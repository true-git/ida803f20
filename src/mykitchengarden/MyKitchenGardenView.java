/*
 * View class
 */
package mykitchengarden;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mykicthengarden.Views.*;

/**
 *
 * @author Team PlantLet
 */
class MyKitchenGardenView {
    
    private Stage stage;
    private Login_GUI login_GUI;
    private Signup_GUI signup_GUI;
    private MainMenu mainmenu;

    public MainMenu getMainmenu() {
        return mainmenu;
    }

    public Login_GUI getLogin_GUI() {
        return login_GUI;
    }

    public MyKitchenGardenView(Stage stage) {
        this.stage = stage;
        
        login_GUI = new Login_GUI();
        signup_GUI = new Signup_GUI();
        mainmenu = new MainMenu();
        MyPlants_GUI myPlants_GUI = new MyPlants_GUI();
        MyPlantsList_GUI myPlantsList_GUI = new MyPlantsList_GUI();
        AddPlants_GUI addPlants_GUI = new AddPlants_GUI();
        PlantLibrary_GUI plantLibrary_GUI = new PlantLibrary_GUI();
        AskExperts_GUI askExperts_GUI = new AskExperts_GUI();
        
        //--------------------- Here is button events ---------------------
//        login_GUI.getLogin_button().setOnAction(e -> updateView(mainmenu));
        login_GUI.getGuest_button().setOnAction(e -> updateView(mainmenu));
        login_GUI.getSignup_button().setOnAction(e -> updateView(signup_GUI));
        signup_GUI.getBack_button().setOnAction(e -> updateView(login_GUI));
        mainmenu.getButton_my_plants().setOnAction(e -> updateView(myPlants_GUI));
        mainmenu.getButton_plant_library().setOnAction(e -> updateView(plantLibrary_GUI));
        mainmenu.getButton_ask_expert().setOnAction(e -> updateView(askExperts_GUI));
        myPlants_GUI.getBack_button().setOnAction(e -> updateView(mainmenu));
        myPlants_GUI.getList_button().setOnAction(e -> updateView(myPlantsList_GUI));
        myPlants_GUI.getPlus_button().setOnAction(e -> updateView(addPlants_GUI));
        myPlantsList_GUI.getBack_button().setOnAction(e -> updateView(mainmenu));
        myPlantsList_GUI.getSquares_button().setOnAction(e -> updateView(myPlants_GUI));
        myPlantsList_GUI.getPlus_button().setOnAction(e -> updateView(addPlants_GUI));
        addPlants_GUI.getBack_button().setOnAction(e -> updateView(myPlants_GUI));
        plantLibrary_GUI.getBack_button().setOnAction(e -> updateView(mainmenu));
        askExperts_GUI.getBack_button().setOnAction(e -> updateView(mainmenu));
        
        stage.setTitle("PlantLet");
        stage.setScene(new Scene(login_GUI, 357, 667));
        stage.getScene().getStylesheets().add("mykitchengarden/layoutstyles.css");
        stage.show();
        stage.setResizable(false);
    }
    
    public void updateView(Pane pane) {
        stage.getScene().setRoot(pane);
    }
  
}

    
    

