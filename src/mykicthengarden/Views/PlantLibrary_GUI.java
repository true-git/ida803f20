package mykicthengarden.Views;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlantLibrary_GUI extends VBox {
    
    private Button back_button;

    public Button getBack_button() {
        return back_button;
    }

    public PlantLibrary_GUI() {
        
         //Back button
        Image back_image = new Image("https://img.icons8.com/ios/40/000000/circled-left-2.png");
        ImageView back_View = new ImageView();
        back_View.setImage(back_image);
        back_View.setFitHeight(40);
        back_View.setFitWidth(40);
        
        back_button = new Button("", back_View);
        back_button.setAlignment(Pos.TOP_LEFT);
        back_button.setId("buttons");
        
        //Create image 
        Image book_image = new Image("https://i.imgur.com/gicCVd5.png");
        ImageView book_View = new ImageView();
        book_View.setImage(book_image);
        book_View.setFitHeight(60);
        book_View.setFitWidth(60);
        
        //create text
        Text text_title = new Text("Plante Bibliotek");
        text_title.setId("titles");
        Text text_under = new Text("Søg efter den plante som du\n" + "ønsker information om.");
        text_under.setFont(new Font("Calibri", 18));
       
        //create a textfield 
        TextField search_field = new TextField(); 
        search_field.setPromptText("Søg");
        search_field.setId("textfield");
        
        //creating Hbox for title and image 
        HBox center_box = new HBox(10);
        center_box.setAlignment(Pos.CENTER);
        center_box.getChildren().addAll(book_View, text_title);
        
        //creating Vbox for undertitle and searchfield
        VBox search_box = new VBox(10);
        search_box.setSpacing(10);
        search_box.setAlignment(Pos.CENTER);
        search_box.getChildren().addAll(center_box, text_under, search_field);
        search_box.setPadding(new Insets(25,0,0,0));

        //The BorderPane is created called layout
        getChildren().addAll(back_button, search_box);
        setPadding(new Insets(30, 30, 30, 30));
    }
}