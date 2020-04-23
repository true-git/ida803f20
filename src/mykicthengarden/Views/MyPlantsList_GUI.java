/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.Views;

import mykicthengarden.Views.MainMenu;
import mykicthengarden.Views.AddPlants_GUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Team PlantLet
 */
public class MyPlantsList_GUI extends Application {
     
    public void start(Stage primaryStage) throws Exception {
        
        //Back button with image
        Button back_button = new Button();
        Image back_icon = new Image ("https://img.icons8.com/ios/40/000000/circled-left-2.png", 40, 40, false, true);
        back_button.setGraphic(new ImageView(back_icon));
        back_button.setId("buttons");
        
        //Squares button to change listview menu
        Button squares_button = new Button();
        Image squares_icon = new Image ("https://img.icons8.com/ios/40/000000/four-squares.png", 40, 40, false, true);
        squares_button.setGraphic(new ImageView(squares_icon));
        squares_button.setId("buttons");
        
        //Plus button to add plants
        Button plus_button = new Button("Tilføj plante");
        plus_button.setId("menu_button_small");
        
        //Icon label 
        Label image_label = new Label("Mine Planter");
        image_label.setId("titles");
        
        //Inserting the image 
        Image image_leaf = new Image("https://i.imgur.com/U2YsVgb.png", 60, 60, true, false);
        ImageView imageview_leaf = new ImageView(image_leaf);
        
        //Description label 
        Label description_label = new Label("Klik og se mere");
        description_label.setFont(new Font("Calibri", 18));
        
        
        //List
        ListView listview = new ListView();
        listview.setMaxSize(270,500);
        
        
        
        //Making a HBox containing the icon and label 
        HBox hbox_icon_and_label = new HBox(20);
        hbox_icon_and_label.getChildren().addAll(imageview_leaf, image_label);
        hbox_icon_and_label.setAlignment(Pos.CENTER);
        hbox_icon_and_label.setPadding(new Insets(20,0,0,0));
        
        //VBox for icon, icon label and decription label
        VBox vbox_icon_and_description = new VBox();
        vbox_icon_and_description.getChildren().addAll(hbox_icon_and_label, description_label);
        vbox_icon_and_description.setAlignment(Pos.CENTER);
        
        
        //Vbox for all content in center
        VBox vbox_center_content = new VBox(20);
        vbox_center_content.getChildren().addAll(vbox_icon_and_description, listview);
        vbox_center_content.setAlignment(Pos.CENTER);
        
        //Stackpane for back button
        HBox hbox_top = new HBox(200);
        hbox_top.getChildren().addAll(back_button, squares_button);
        hbox_top.setPadding(new Insets (20,0,0,20));
        
        //Stackpane for plus button
          StackPane stackpane_plus_button = new StackPane(plus_button);
        stackpane_plus_button.setAlignment(plus_button, Pos.BOTTOM_CENTER);
        stackpane_plus_button.setPadding(new Insets(20, 0, 30, 0));
        
        
        //--------------------- Here is button events ---------------------
        
        //Button to change to MyKitchenGarden_GUI scene 
        MainMenu instance_MyKitchenGarden_GUI = new MainMenu();
        back_button.setOnAction(e -> {
            try {
                instance_MyKitchenGarden_GUI.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(MyPlants_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //Button to change to MyPlants_GUI scene 
        MyPlants_GUI instance_MyPlants_GUI = new MyPlants_GUI();
        squares_button.setOnAction(e -> {
            try {
                instance_MyPlants_GUI.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(MyPlantsList_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //Button to change to AddPlants_GUI scene 
        AddPlants_GUI instance_AddPlants_GUI = new AddPlants_GUI();
        plus_button.setOnAction(e -> {
            try {
                instance_AddPlants_GUI.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(MyPlantsList_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //The BorderPane is created called layout
        BorderPane layout = new BorderPane();
        layout.setTop(hbox_top);
        layout.setCenter(vbox_center_content);
        layout.setBottom(stackpane_plus_button);
        
        //scene is created and put inside the primaryStage
        Scene my_plants_scene = new Scene(layout, 357, 667);
        my_plants_scene.getStylesheets().add("mykitchengarden/layoutstyles.css");
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(my_plants_scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
