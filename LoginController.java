import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * this class represent login page's controller
 * 
 * @author Sevda Imany
 * @version 0.0.0
 */
public class LoginController {

            /*  Fields  */

    private Stage stage;
    private LoginView loginView ;


         /* Constructor */

    public  LoginController(){
        this.stage =StageConnection.getStage();
        loginView = new LoginView();
        loginAction();
    }

    
    
            /*  Methods  */


    /**
     * set login button's action
     */
     public void loginAction(){
        loginView.getLoginBTN().setOnAction(event -> {
            UserSettingController userSettingController = new UserSettingController();
            stage.setScene(new Scene(userSettingController.getUserSettingView()));
        });
    }


    // * getter methods *


    /**
     * @return logiin's view
     */
    public LoginView getLoginView() {
        return loginView;
    }
}
