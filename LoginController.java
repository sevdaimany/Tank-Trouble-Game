import java.io.IOException;

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

            if(loginView.getUsername().getText().equals("") || loginView.getPassword().getText().equals("")){
                loginView.getErrorLable().setText("  Please fill out fields.  ");
                return;
            }
            boolean isRegistered = false;
            boolean isPasswordCorrect = false;
            try {
                isRegistered = DataBase.isRegistered(loginView.getUsername().getText());
                if(isRegistered) {
                    isPasswordCorrect = DataBase.isPasswordCorrect(loginView.getUsername().getText(), loginView.getPassword().getText());
                }
                else {
                    loginView.getErrorLable().setText("  Please login first.  ");
                    return;
                }
            }catch (IOException e){e.printStackTrace();}

            if(isPasswordCorrect) {
                UserSettingController userSettingController = new UserSettingController();
                stage.setScene(new Scene(userSettingController.getUserSettingView()));
                stage.setTitle("Choose");
            }
            else{
                loginView.getErrorLable().setText("  Password is not correct.  ");
            }
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
