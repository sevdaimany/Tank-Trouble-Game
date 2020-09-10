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
    private MenuView menuview;

    // game 's stage'
    private Stage stage;









         /* Constructor */

    /**
     * create menu controller
     */
    public MenuController()
    {
        try
        {
            menuview = new MenuView();
        }
        catch (Exception e){}
        
        this.stage = Main.getStage();

        settingBTNActon();
        registerBTNAction();
        onePlayerAction();



    }









            /*  Methods  */


    // * getter methods *

    /**
     * @return menu page's view
     */
    public MenuView getMenuview() { return menuview; }



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
    
    
    /**
     * this method add 1player button's actionlistener
     */
    public void onePlayerAction(){
        menuview.getButton1().setOnAction(event -> {
            GameState.newFields();
            LoginView.firstCall();
            LoginGameController loginGameController = new LoginGameController();
            loginGameController.getTankControllerChooser().getButton().setText("Next Player");
            stage.setScene(new Scene(loginGameController.getLoginView()));
            stage.setTitle("login");
        });
    }

}
