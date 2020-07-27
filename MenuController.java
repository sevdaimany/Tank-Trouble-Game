import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * this class represent  menu page's controller
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class MenuController {

        /* Fields */

    // menu page's view
    private Menuview menuview;
    // game 's stage'
    private Stage stage;


         /* Constructor */

    /**
     * creat menu controller 
     * @param stage
     */
    public MenuController(Stage stage){
        try {
            menuview = new Menuview();
        }catch (Exception e){}

        registerBTNAction();

        this.stage = stage;
    }


        /* Methods */


    /**
     *this method add register button's action listener
     */
    public void registerBTNAction(){
        RegisterController registerController = new RegisterController();
        menuview.getRegisterBTN().setOnAction(event -> {
            stage.setScene(new Scene(registerController.getRegisterView()));
            stage.setTitle("Register");
        });
    }

    // * getter methods *

    /**
     * @return menu page's view
     */
    public Menuview getMenuview() {
        return menuview;
    }
}
