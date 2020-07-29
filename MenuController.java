import javafx.scene.Scene;
import javafx.stage.Stage;






/**
 * this class represent  menu page's controller
 * 
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.2
 */
public class MenuController 
{

            /*  Fields  */

    // menu page's view
    private Menuview menuview;

    // game 's stage'
    private Stage stage;









         /* Constructor */

    /**
     * create menu controller
     * 
     *  
     * @param stage
     */
    public MenuController()
    {
        try
        {
            menuview = new Menuview();
        }
        catch (Exception e){}
        
        this.stage = StageConnection.getStage();

        settingBTNActon();
        registerBTNAction();


    }









            /*  Methods  */


    // * getter methods *

    /**
     * @return menu page's view
     */
    public Menuview getMenuview() { return menuview; }



    /**
     * set setting button's action
     */
    public void settingBTNActon(){
        SettingController settingController = new SettingController();
        menuview.getSettingBTN().setOnAction(event -> {
            Scene scene = new Scene(settingController.getSettingView());
            stage.setScene(scene);
            stage.setTitle("Setting");
        });
    }



    /**
     * This method add register button's action listener
     */
    public void registerBTNAction()
    {
        RegisterController registerController = new RegisterController();

        menuview.getRegisterBTN().setOnAction(event -> 
        {
            stage.setScene(new Scene(registerController.getRegisterView()));
            stage.setTitle("Register");
        });
    }    
}
