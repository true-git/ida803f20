/*
This is the controller class.
The controller coordinates interactions between the view and the model
 */
package mykitchengarden;

/**
 *
 * @author Team PlantLet
 */
public class MyKitchenGardenController {
    
    private final MyKitchenGardenModel myKitchenGardenModel;
    private final MyKitchenGardenView myKitchenGardenView;
    
    public MyKitchenGardenController(MyKitchenGardenModel myKitchenGardenModel, MyKitchenGardenView myKitchenGardenView) {
        this.myKitchenGardenModel = myKitchenGardenModel;
        this.myKitchenGardenView = myKitchenGardenView;
        
        goToLoginView();
    }
    
    public void goToLoginView(){
        myKitchenGardenView.updateView(myKitchenGardenView.getLogin_GUI());
        myKitchenGardenView.getLogin_GUI().getLogin_button().setOnAction(e -> {
            if(myKitchenGardenModel.userValidated(myKitchenGardenView.getLogin_GUI().getEmail_text().getText(), 
                    myKitchenGardenView.getLogin_GUI().getPassword_text().getText())){
                goToMainMenuView();
            } else{
                //update gui med "email or password is incorrect". Evt 3 forsøg.
            }
                });
        
    }
    
    public void goToMainMenuView(){
        myKitchenGardenView.updateView(myKitchenGardenView.getMainmenu());
        
    }
    
}
