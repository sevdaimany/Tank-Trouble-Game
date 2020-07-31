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


    // * getter methods *

    /**
     * @return login's view
     */
    public LoginView getLoginView() { return loginView; }
}
