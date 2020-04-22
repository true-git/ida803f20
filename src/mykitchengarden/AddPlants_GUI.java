/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden;

 

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

 

/**
 *
 * @author lilyhuynh
 */
public class AddPlants_GUI extends Application {
       private Button back_button, button_alert_OK, ok_button;
       
        private TextField input;
        
       @Override
    public void start(Stage primaryStage) throws Exception {
        
     
        //Making the Back button
        Button back_button = new Button();
        Image back_icon = new Image ("https://img.icons8.com/ios/40/000000/circled-left-2.png", 40, 40, false, true);
        back_button.setGraphic(new ImageView(back_icon));
        StackPane pane1 = new StackPane();
        pane1.getChildren().addAll(back_button);
        pane1.setAlignment(back_button, Pos.TOP_LEFT);
        pane1.setPadding(new Insets (20,20, 20, 20));
        back_button.setId("buttons");
        
        //Inserting the image 
        Image image_leaf = new Image("https://i.imgur.com/U2YsVgb.png", 60, 60, true, false);
        ImageView imageview_leaf = new ImageView(image_leaf);
        
        
         //Making the label 
        Label label1 = new Label("Tilføj Plante");
        label1.setId("titles");
        
          //Making a HBox containing the icon and label 
       HBox hbox_icon_and_label = new HBox(20);
       hbox_icon_and_label.getChildren().addAll(imageview_leaf, label1);
       hbox_icon_and_label.setAlignment(Pos.CENTER);
        
        //TextField bar added for search bar
        TextField search_textField = new TextField();
        search_textField.setId("textfield");
        search_textField.setMaxSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
       
        //Hint text in text field
        search_textField.setPromptText("Søg efter Plante"); 
 
        
        //ArrayLists for Plants, Dates, Months, and Years.   
        //String plants[] = {"Plante1", "Plante2"};
        String dates[] = {"Dag", "1", "2","3", "4", "5", "6", "7","8","9","10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String months[] = {"Jan", "Feb", "Mar", "Apr", "Maj", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"};       
        String years[] = {"2020", "2021", "2022"};
        String state[] = {"Frø", "Spirre"};
        
        
        //Making a combobox for plants, the dates, and state of the plant
        //ChoiceBox plants_box = new ChoiceBox(FXCollections.observableArrayList(plants)); 
        ComboBox dates_box = new ComboBox(FXCollections.observableArrayList(dates)); 
        ComboBox months_box = new ComboBox(FXCollections.observableArrayList(months));
        ComboBox years_box = new ComboBox(FXCollections.observableArrayList(years));
        ComboBox state_box = new ComboBox(FXCollections.observableArrayList(state)); 
        
        
        
        //Styles for comboboxes 
        //plants_box.setStyle("-fx-pref-width: 270;-fx-font-size:20;");
        //dates_box.setStyle("-fx-pref-width: 50;-fx-font-size:20;");
        //months_box.setStyle("-fx-pref-width: 100;-fx-font-size:20;");
        //years_box.setStyle("-fx-pref-width: 100;-fx-font-size:20;");
        state_box.setId("textfield");
        
        state_box.setPromptText("Stand");
        
        //Calendar to registrate when the plant has been added
        DatePicker date_picker = new DatePicker();
        date_picker.setId("textfield");
        date_picker.setPromptText("Vælg dato");
        
        //Making a HBox containing Date, Month, and Year 
        //HBox hbox_time = new HBox(20);
        //hbox_time.getChildren().addAll(dates_box, months_box, years_box);
        //hbox_time.setAlignment(Pos.CENTER);
       
        //Making a VBox containing the hbox_time, plants and state
        VBox vbox_add = new VBox(10);
        vbox_add.getChildren().addAll(hbox_icon_and_label, search_textField, date_picker, state_box);
        vbox_add.setAlignment(Pos.CENTER);
        
        //Making the Ok button
        Button ok_button = new Button();
        Image ok_icon = new Image ("https://img.icons8.com/ios/40/ok.png", 40, 40, false, true);
        ok_button.setGraphic(new ImageView(ok_icon));
        StackPane pane2 = new StackPane();
        pane2.getChildren().addAll(ok_button);
        pane2.setAlignment(ok_button, Pos.BOTTOM_CENTER);
        pane2.setPadding(new Insets(0, 0, 200, 0));
        ok_button.setId("buttons");
        
     
                
        //The BorderPane is created called layout
        BorderPane layout = new BorderPane();
        layout.setTop(pane1);
        layout.setBottom(pane2);
        layout.setCenter(vbox_add);
        
        
 

        //Button to change to MyPlants_GUI scene 
        MyPlants_GUI instance_MyPlants_GUI = new MyPlants_GUI();
        back_button.setOnAction(e -> {
            try {
                instance_MyPlants_GUI.start(primaryStage);
            } catch (Exception ex) {
                Logger.getLogger(AddPlants_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
 

    
  // Alert when suggestion is accepted
   Alert alert_accept_OK = new Alert(AlertType.NONE);

 


        EventHandler<ActionEvent> event_alert_accept = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

 

              
                // set alert type 
                alert_accept_OK.setAlertType(AlertType.INFORMATION);
                alert_accept_OK.setTitle(null);
                alert_accept_OK.setHeaderText(null);
                alert_accept_OK.setContentText(" er tilføjet i systemet");
                alert_accept_OK.showAndWait();
                
                DialogPane dialogPane = alert_accept_OK.getDialogPane();
                    dialogPane.setStyle("-fx-padding: 0;");

 

                //Button text
                ((Button) alert_accept_OK.getDialogPane().lookupButton(ButtonType.OK)).setText("OK");
                button_alert_OK = ((Button) alert_accept_OK.getDialogPane().lookupButton(ButtonType.OK));
 
            }
        };
        // when button is pressed
        ok_button.setOnAction(event_alert_accept);

 

        

 

 

        
               
                 
        //Scene is created and put inside the PrimaryStage
        Scene AddPlantsScene = new Scene(layout, 357, 667);
        AddPlantsScene.getStylesheets().add("mykitchengarden/layoutstyles.css");
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(AddPlantsScene);
        primaryStage.show();
        primaryStage.setResizable(false);
        
        
    

 

    }
}