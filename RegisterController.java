import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;






/**
 * This class represent register page's controller
 * 
 * 
 * @author Sevda Imany
 * @version 0.0.5
 */
public class RegisterController 
{
            /*  Fields  */

    // register page's view
    private RegisterView registerView;

    private Stage stage;





         /* Constructor */

    /**
     * Create register page's controller
     */
    public RegisterController() 
    {
        registerView = new RegisterView();
        this.stage = Main.getStage();
        registerAction();
        menuAction();
    }






            /*  Methods  */

    /**
     * This method sets register button's action listener
     */
    public void registerAction() 
    {
        registerView.getRegisterBTN().setOnAction(event -> {

            try 
            {
                String name = registerView.getFirstname().getText();
                String lastname = registerView.getLastname().getText();
                String username = registerView.getUsername().getText();
                String password = registerView.getPassword().getText();
                String repeatPassword = registerView.getRepeatPassword().getText();

                if (!name.equals("") && !lastname.equals("") && !username.equals("") && !password.equals("")
                && !repeatPassword.equals("")) {
                    if (!DataBase.isRegistered(username)) {
                        if (password.equals(repeatPassword)) {
                            Player player = new Player(name, lastname, username, password);
                            DataBase.savePlayer(player);
                            MenuController menuController = new MenuController();
                            stage.setScene(new Scene(menuController.getMenuview()));
                            stage.setTitle("Tank Trouble");
                        } else {
                            registerView.getErrorLable().setText("The two password fields didn’t match.");
                        }

                    } else {
                        registerView.getErrorLable().setText("A user with that username already exists.");
                    }
                } else {
                    registerView.getErrorLable().setText("Please fill out fields");
                }
            } catch (IOException e) {
            }

        });
    }


    /**
     * This method set menu button's action listener
     */
    public void menuAction() 
    {
        registerView.getMenu().setOnAction(event -> {
            MenuController menuController = new MenuController();
            stage.setScene(new Scene(menuController.getMenuview()));
            stage.setTitle("Tank Trounle");
        });
    }



    // * getter methods *

    /**
     * @return register page's view
     */
    public RegisterView getRegisterView() { return registerView; }
}
