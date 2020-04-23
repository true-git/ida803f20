/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykicthengarden.Views;

 

import mykicthengarden.Views.AddPlants_GUI;
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
import javafx.scene.control.TextArea;

 

/**
 *
 * @author Team PlantLet
 */
public class AskExperts_GUI extends Application {
       private Button back_button, button_alert_OK, ok_button;
       
        private TextField input;
        
       @Override
    public void start(Stage primaryStage) throws Exception {
        

        //Making the Back button
        Button back_button_askexpert = new Button();
        Image back_icon = new Image ("https://img.icons8.com/ios/40/000000/circled-left-2.png", 40, 40, false, true);
        back_button_askexpert.setGraphic(new ImageView(back_icon));
        StackPane pane1 = new StackPane();
        pane1.getChildren().addAll(back_button_askexpert);
        pane1.setAlignment(back_button_askexpert, Pos.TOP_LEFT);
        pane1.setPadding(new Insets (20,20, 0, 20));
        back_button_askexpert.setId("buttons");
        
        //Inserting the image 
        Image image_icon = new Image("https://i.imgur.com/BKbRAvv.png", 60, 60, true, false);
        ImageView imageview_icon = new ImageView(image_icon);
        

         //Making the label for title
        Label label1 = new Label("Spørg Ekspertne");
        label1.setId("titles");
        
          //Making a HBox containing the icon and label 
       HBox hbox_icon_and_label = new HBox(20);
       hbox_icon_and_label.getChildren().addAll(imageview_icon, label1);
       hbox_icon_and_label.setAlignment(Pos.CENTER);
       
       //Label for description
       Label label_description = new Label();
       label_description.setText("I tvivl?\n"+"Send dit spørgsmål til eksperterne,\n"+ "så vil de prøve at svare på det");
       label_description.setId("descriptions");
       
       //Labels for picture buttons
       Label label_picture1 = new Label("Vedhæft billede(r)");
       label_picture1.setId("descriptions");
       
       //Buttons to insert image
       Button button_picture1 = new Button("Vælg fil");
       button_picture1.setId("menu_button_small");
       
       //Vbox for labels and buttons for insert of pictures
       VBox vbox_insert_pictures = new VBox();
       vbox_insert_pictures.getChildren().addAll(label_picture1, button_picture1);
       vbox_insert_pictures.setPadding(new Insets(0,0,0,45));
       
        //TextField bar added for search bar
        TextArea textarea_question = new TextArea();
        textarea_question.setStyle("-fx-pref-width: 270; -fx-pref-height: 200;-fx-font-size:15px;");
        textarea_question.setMaxSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
        textarea_question.setWrapText(true);
        
        //Hint text in text field
        textarea_question.setPromptText("Indtast spørgsmål");
        
        //Question topics
         String question_topic[] = {"Vanding","Høstning","Jord","Drivhus", "CO₂"};
         
        //Making a combobox for selecting question topic        
        ComboBox question_topic_box = new ComboBox(FXCollections.observableArrayList(question_topic));   
        
        question_topic_box.setId("textfield");
        question_topic_box.setPromptText("Vælg emne");

        
        //Making a VBox containing all the content in the center
        VBox vbox_add = new VBox(10);
        vbox_add.getChildren().addAll(hbox_icon_and_label, label_description, question_topic_box, textarea_question,vbox_insert_pictures);
        vbox_add.setAlignment(Pos.CENTER);
        vbox_add.setPadding(new Insets(0,0,20,0));
        
        //Making the submit button
        Button submit_button = new Button("Indsend");
        submit_button.setId("menu_button_small");
        
        StackPane stack_pane = new StackPane(submit_button);
        stack_pane.setAlignment(Pos.BOTTOM_RIGHT);
        stack_pane.setPadding(new Insets(0,45,30,0));
        
        //The BorderPane is created called layout
        BorderPane layout = new BorderPane();
        layout.setTop(pane1);
        layout.setBottom(stack_pane);
        layout.setCenter(vbox_add);

        //Button to change to MyPlants_GUI scene 
        MainMenu instance_MyKitchenGarden_GUI = new MainMenu();
        back_button_askexpert.setOnAction(e -> {
            try {
                instance_MyKitchenGarden_GUI.start(primaryStage);
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
        submit_button.setOnAction(event_alert_accept);
 
                 
        //Scene is created and put inside the PrimaryStage
        Scene AskExpertsScene = new Scene(layout, 357, 667);
        AskExpertsScene.getStylesheets().add("mykitchengarden/layoutstyles.css");
        primaryStage.setTitle("PlantLet");
        primaryStage.setScene(AskExpertsScene);
        primaryStage.show();
        primaryStage.setResizable(false);
        

 

    }
}