/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.myPlants;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


/**
 *
 * @author Team PlantLet
 */
public class MyPlantsView extends BorderPane {
    
    Label plant_label;
    private Button back_button;
    private Button list_button;
    private Button plus_button;

    public Button getBack_button() {
        return back_button;
    }

    public Button getList_button() {
        return list_button;
    }

    public Button getPlus_button() {
        return plus_button;
    }
    
    public MyPlantsView() {
        
        //Back button with image
        back_button = new Button();
        Image back_icon = new Image ("https://img.icons8.com/ios/40/000000/circled-left-2.png", 40, 40, false, true);
        back_button.setGraphic(new ImageView(back_icon));
        back_button.setId("buttons");
        
        //Button to change list menu
        list_button = new Button();
        Image list_icon = new Image ("https://img.icons8.com/material-rounded/40/000000/list.png", 40, 40, false, true);
        list_button.setGraphic(new ImageView(list_icon));
        list_button.setId("buttons");
        
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
        
        //Imageviews and labels for testing of placement for center content
        Image plant_image1 = new Image ("https://image.shutterstock.com/image-vector/default-ui-image-placeholder-wireframes-260nw-1037719192.jpg", 120, 120, false, true);
        //ImageView plant_imageview1 = new ImageView(plant_image1);

        Plant plant1 = new Plant("Gulerødder", plant_image1);
        Plant plant2 = new Plant("Kartofler", plant_image1);
        Plant plant3 = new Plant("Radisser", plant_image1);
        
        ArrayList<Plant> list = new ArrayList<>();
        list.add(plant1);
        list.add(plant2);
        list.add(plant3);
        list.add(plant1);
        list.add(plant2);
        list.add(plant3);
        list.add(plant1);
        list.add(plant2);
        list.add(plant3);
        
        int row = 0;
        int column = 0;
        
        //GridPane for center content
        GridPane grid_plants = new GridPane();
        for(Plant p : list ){
            VBox vbox_content = vbox_generator(p.image, p.name);
            grid_plants.add(vbox_content, column, row);
            if (column == 0){
                column = 1;
            } else if(column == 1) {
                column = 0;
                row ++;
            }
        }

        grid_plants .setHgap(30);
        grid_plants .setVgap(20);
        
        //Scroll pane for grid content
        ScrollPane scrollpane_grid = new ScrollPane(grid_plants);
        scrollpane_grid.setPadding(new Insets(30,20,0,45));
        
        //Making a HBox containing the icon and label
        HBox hbox_icon_and_label = new HBox(20);
        hbox_icon_and_label.getChildren().addAll(imageview_leaf, image_label);
        hbox_icon_and_label.setAlignment(Pos.CENTER);
        //this line places the top padding of the top label and icon which pushes all center content down
        hbox_icon_and_label.setPadding(new Insets(20,0,0,0));
        
        //Vbox for all center content - icon, label, description, and grid
        VBox vbox_icon_and_description = new VBox();
        vbox_icon_and_description.getChildren().addAll(hbox_icon_and_label, description_label, scrollpane_grid);
        vbox_icon_and_description.setAlignment(Pos.CENTER);
        
        //Stackpane for back button
        HBox hbox_top = new HBox(200);
        hbox_top.getChildren().addAll(back_button, list_button);
        hbox_top.setPadding(new Insets (20,0,0,20));
        
        //Stackpane for plus button
        StackPane stackpane_plus_button = new StackPane(plus_button);
        StackPane.setAlignment(plus_button, Pos.BOTTOM_CENTER);
        stackpane_plus_button.setPadding(new Insets(20, 0, 30, 0));     
        
        //The BorderPane is created called layout
        setTop(hbox_top);
        setCenter(vbox_icon_and_description);
        setBottom(stackpane_plus_button);
    }
    
    private VBox vbox_generator(Image image, String name) {
        Label plant_label = new Label(name);
        ImageView plant_imageview = new ImageView(image);
        plant_label.setStyle("-fx-font-size:15px;");
        
        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(plant_imageview,plant_label);
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }
}
