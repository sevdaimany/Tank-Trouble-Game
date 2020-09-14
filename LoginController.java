import javafx.scene.Scene;
import javafx.stage.Stage;





/**
 * This class represent login page's controller
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.5
 */
public class LoginController 
{

            /*  Fields  */

    private Stage stage;
    private LoginView loginView ;








         /* Constructor */

    public  LoginController()
    {
        this.stage =Main.getStage();
        loginView = new LoginView();
        loginAction();
        menuAction();
    }

    




    
            /*  Methods  */


    /**
     * Set login button's action
     */
     public void loginAction()
     {
        loginView.getLoginBTN().setOnAction(event -> {
            UserSettingController userSettingController = new UserSettingController();
            stage.setScene(new Scene(userSettingController.getUserSettingView()));
        });
    }

    /**
     * This method set menu button's action listener
     */
    public void menuAction()
    {
        loginView.getMenu().setOnAction(event -> {
            MenuController menuController = new MenuController();
            stage.setScene(new Scene(menuController.getMenuview()));
            stage.setTitle("Tank Trounle");
        });
    }



    // * getter methods *

    /**
     * @return login's view
     */
    public LoginView getLoginView() { return loginView; }
}
