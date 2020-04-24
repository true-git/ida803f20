/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

/**
 *
 * @author Team PlantLet
 */
public class MyPlantsList_GUI extends BorderPane {
    
    private Button back_button;
    private Button squares_button;
    private Button plus_button;

    public Button getBack_button() {
        return back_button;
    }

    public Button getSquares_button() {
        return squares_button;
    }

    public Button getPlus_button() {
        return plus_button;
    }
    
    
     
    public MyPlantsList_GUI() {
        
        //Back button with image
        back_button = new Button();
        Image back_icon = new Image ("https://img.icons8.com/ios/40/000000/circled-left-2.png", 40, 40, false, true);
        back_button.setGraphic(new ImageView(back_icon));
        back_button.setId("buttons");
        
        //Squares button to change listview menu
        squares_button = new Button();
        Image squares_icon = new Image ("https://img.icons8.com/ios/40/000000/four-squares.png", 40, 40, false, true);
        squares_button.setGraphic(new ImageView(squares_icon));
        squares_button.setId("buttons");
        
        //Plus button to add plants
        plus_button = new Button("Tilføj plante");
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
        
        //The BorderPane is created called layout
        setTop(hbox_top);
        setCenter(vbox_center_content);
        setBottom(stackpane_plus_button);
    }
}
